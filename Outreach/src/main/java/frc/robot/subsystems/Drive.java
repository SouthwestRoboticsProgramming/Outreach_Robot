package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.control.Input;

public class Drive implements Subsystem{
    // Locations of wheels

    // Front back: 37 cm
    // Left right: 50.5 cm
    Translation2d frontLeft = new Translation2d(0.2525,0.185);
    Translation2d frontRight = new Translation2d(0.2525,-0.185);
    Translation2d backLeft = new Translation2d(-0.2525,0.185);
    Translation2d backRight = new Translation2d(0.2525,-0.185);

    MecanumModule w1;
    MecanumModule w2;
    MecanumModule w3;
    MecanumModule w4;

    MecanumDriveKinematics kinematics;

    private final Input input;

    public Drive(Input input) {
        kinematics = new MecanumDriveKinematics(frontLeft, frontRight, backLeft, backRight);

        w1 = new MecanumModule(10);
        w2 = new MecanumModule(11);
        w3 = new MecanumModule(12);
        w4 = new MecanumModule(13);

        this.input = input;
    }



    @Override
    public void periodic() {
        // Calculate what we want the robot to do based on the controller
        
        double driveX = -input.getDriveX();
        double driveY = input.getDriveY();
        double driveRot = -input.getDriveRot();

        ChassisSpeeds chassis = new ChassisSpeeds(driveY, driveX, driveRot); // All in m/s [Forward, Left, Counterclocwise (radians)]
        
        MecanumDriveWheelSpeeds speeds = kinematics.toWheelSpeeds(chassis);

        w1.set(speeds.frontLeftMetersPerSecond);
        w2.set(speeds.frontRightMetersPerSecond);
        w3.set(speeds.rearLeftMetersPerSecond);
        w4.set(speeds.rearRightMetersPerSecond);
    }
}
