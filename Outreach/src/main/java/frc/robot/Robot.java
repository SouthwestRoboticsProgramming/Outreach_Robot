package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.control.Input;
import frc.robot.subsystems.Drive;

public class Robot extends RobotBase {
  public static final double PERIODIC_PER_SECOND = 50;
  private static final Robot INSTANCE = new Robot();

  public static Robot get() {
    return INSTANCE;
  }

  public Input input;
  public Drive drive;

  private volatile boolean running;

  public void robotInit() {
    input = new Input();
    drive = new Drive(input);
  }

  public void robotPeriodic() {

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
