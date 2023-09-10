package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.control.Input;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TankDrive;

import static frc.robot.Constants.*;

public class Robot extends TimedRobot {
  public static final double PERIODIC_PER_SECOND = 50;
  private static final Robot INSTANCE = new Robot();

  public static Robot get() {
    return INSTANCE;
  }

  public Input input;
  public TankDrive drive;
  public Shooter shooter;
  public Hopper hopper;

  private volatile boolean running;

  public void robotInit() {
    System.out.println("Robot init");

    input = new Input();
    drive = new TankDrive();
    shooter = new Shooter();
    hopper = new Hopper();
  }

  public void robotPeriodic() {
    boolean enableDrive = input.getDriveEnable();
    double drive, turn;
    if (enableDrive) {
      drive = input.getDriveY() * ShuffleBoard.DRIVE_SPEED.getDouble(0);
      turn = input.getDriveRot() * ShuffleBoard.DRIVE_TURN_SPEED.getDouble(0);
    } else {
      drive = 0;
      turn = 0;
    }
    // ChassisSpeeds chassis = new ChassisSpeeds(driveY, driveX, driveRot); // All in m/s [Forward, Left, Counterclocwise (radians)]
    // drive.setChassis(chassis);
    this.drive.drive(drive, turn);

    hopper.blockBalls(input.getHopper());

    shooter.spin(input.getShooterSpeed() * ShuffleBoard.SHOOTER_SPEED.getDouble(0));
  }

  public void disabledInit() {

  }

  public void disabledPeriodic() {

  }

  public void teleopInit() {

  }

  public void teleopPeriodic() {

  }

  public void autonomousInit() {

  }

  public void autonomousPeriodic() {

  }

  public void testInit() {

  }

  public void testPeriodic() {

  }

  @Override
  public void startCompetition() {
    running = true;
    robotInit();

    System.out.println("****** Robot program startup complete ******");

    HAL.observeUserProgramStarting();

    long lastTime = System.nanoTime();
    double secondsPerPeriodic = 1.0 / PERIODIC_PER_SECOND;
    double unprocessedTime = 0;

    RobotState lastState = RobotState.DISABLED;
    while (running && !Thread.currentThread().isInterrupted()) {
      long currentTime = System.nanoTime();
      unprocessedTime += (currentTime - lastTime) / 1_000_000_000.0;
      lastTime = currentTime;

      while (unprocessedTime > secondsPerPeriodic) {
        unprocessedTime -= secondsPerPeriodic;

        robotPeriodic();

        RobotState state = getCurrentState();

        if (state != lastState) {
          switch (state) {
            case DISABLED:
              disabledInit();
              break;
            case TELEOP:
              teleopInit();
              break;
            case AUTONOMOUS:
              autonomousInit();
              break;
            case TEST:
              testInit();
              break;
          }
        }
        lastState = state;

        switch (state) {
          case DISABLED:
            disabledPeriodic();
            break;
          case TELEOP:
            teleopPeriodic();
            break;
          case AUTONOMOUS:
            autonomousPeriodic();
            break;
          case TEST:
            testPeriodic();
            break;
        }
      }
    }
  }

  @Override
  public void endCompetition() {
    running = false;
  }

  public RobotState getCurrentState() {
    if (isDisabled())
      return RobotState.DISABLED;
    if (isAutonomous())
      return RobotState.AUTONOMOUS;
    if (isTeleop())
      return RobotState.TELEOP;
    if (isTest())
      return RobotState.TEST;

    throw new IllegalStateException("Illegal robot state");
  }
}
