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

    public double getDriveX() {
        if (Math.abs(main.getLeftX()) > DEADZONE) {
            return main.getLeftX();
        }
        return deadzone(buddy.getLeftX());
    }

    public double getDriveY() {
        if (Math.abs(main.getLeftY()) > DEADZONE) {
            return main.getLeftY();
        }
        return deadzone(buddy.getLeftY());
    }

    public double getDriveRot() {
        if (Math.abs(main.getRightX()) > DEADZONE) {
            return main.getRightX();
        }
        return deadzone(buddy.getRightX());
    }

    public double getShooterSpeed() {
        if (main.getRightTriggerAxis() > DEADZONE) {
            return main.getRightTriggerAxis();
        }
        return buddy.getRightTriggerAxis();
    }

    public boolean getHopper() {
        return main.getAButton() /*|| buddy.getAButton()*/;
    }

    public boolean getDriveEnable() {
        return main.getLeftBumper();
    }

    private double deadzone(double number) {
        if (number < DEADZONE) {
            return 0;
        }
        return number;
    }
    
}
