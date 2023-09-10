package frc.robot.control;

import edu.wpi.first.wpilibj.XboxController;
import static frc.robot.Constants.DEADZONE;

public class Input {

    private final XboxController main;
    private final XboxController buddy;
    
    public Input() {
        main = new XboxController(0);
        buddy = new XboxController(1);
    }

    // public double getDriveX() {
    //     if (Math.abs(main.getLeftX()) > DEADZONE) {
    //         return deadzone(main.getLeftX());
    //     }
    //     return deadzone(buddy.getLeftX());
    // }

    public double getDriveY() {
        if (Math.abs(main.getLeftY()) > DEADZONE) {
            return deadzone(-main.getLeftY());
        }
        return deadzone(-buddy.getLeftY());
    }

    public double getDriveRot() {
        if (Math.abs(main.getRightX()) > DEADZONE) {
            return deadzone(main.getRightX());
        }
        return deadzone(buddy.getRightX());
    }

    public double getShooterSpeed() {
        if (main.getRightTriggerAxis() > DEADZONE) {
            return deadzone(main.getRightTriggerAxis());
        }
        return deadzone(buddy.getRightTriggerAxis());
    }

    public boolean getHopper() {
        return main.getAButton() || buddy.getAButton();
    }

    public boolean getDriveEnable() {
        return main.getLeftBumper();
    }

    public static double map(double value, double minOld, double maxOld, double minNew, double maxNew) {
        return (value - minOld) / (maxOld - minOld) * (maxNew - minNew) + minNew;
    }

    public static double deadzone(double measurement) {
        if (Math.abs(measurement) < DEADZONE) {
            return 0;
        }

        if (measurement > 0)
            return map(measurement, DEADZONE, 1, 0, 1);
        else
            return -map(-measurement, DEADZONE, 1, 0, 1);
    }
    
}
