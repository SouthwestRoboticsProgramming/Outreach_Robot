package frc.robot.control;

import edu.wpi.first.wpilibj.XboxController;

public class Input {

    private final XboxController main;
    private final XboxController buddy;

    // TODO: Use deadzone in place of 0 when deciding to use buddy controller
    
    public Input() {
        main = new XboxController(0);
        buddy = new XboxController(1);
    }

    public double getDriveX() {
        if (Math.abs(main.getLeftX()) > 0) {
            return main.getLeftX();
        }
        return buddy.getLeftX();
    }

    public double getDriveY() {
        if (Math.abs(main.getLeftY()) > 0) {
            return main.getLeftY();
        }
        return buddy.getLeftY();
    }

    public double getDriveRot() {
        if (Math.abs(main.getRightX()) > 0) {
            return main.getRightX();
        }
        return buddy.getRightX();
    }

    public boolean getShooter() {
        return main.getXButton();
    }
    
}
