package frc.robot.control;

import edu.wpi.first.wpilibj.XboxController;


public class Input {
    private static final double DEADZONE = 0.1;

    private final XboxController main;
    
    public Input() {
        main = new XboxController(0);
    }

    public double getDriveX() {
        return deadzone(main.getLeftX());
    }

    public double getDriveY() {
        return deadzone(main.getLeftY());
    }

    public double getDriveRot() {
        return deadzone(main.getRightX());
    }

    private double deadzone(double number) {
        if (number < DEADZONE) {
            return 0;
        }
        return number;
    }
    
}
