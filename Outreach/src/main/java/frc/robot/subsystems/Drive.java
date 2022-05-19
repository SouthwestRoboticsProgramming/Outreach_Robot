package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;

public class Drive {
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


    public Drive() {

        // System.out.println("Drive created");
        kinematics = new MecanumDriveKinematics(frontLeft, frontRight, backLeft, backRight);

        w1 = new MecanumModule(10, true);
        w2 = new MecanumModule(11, false);
        w3 = new MecanumModule(12, true);
        w4 = new MecanumModule(13, false);
    }
    

    public void setChassis(ChassisSpeeds chassis) {
    
    MecanumDriveWheelSpeeds speeds = kinematics.toWheelSpeeds(chassis);

    w1.set(speeds.frontLeftMetersPerSecond);
    w2.set(speeds.frontRightMetersPerSecond);
    w3.set(speeds.rearLeftMetersPerSecond);
    w4.set(speeds.rearRightMetersPerSecond);

    }
}
