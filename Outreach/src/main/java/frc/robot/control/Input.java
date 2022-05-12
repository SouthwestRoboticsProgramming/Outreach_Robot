package frc.robot.control;

import edu.wpi.first.wpilibj.XboxController;

public class Input {

    private final XboxController main;
    private final XboxController buddy;
    
    public Input() {
        main = new XboxController(0);
        buddy = new XboxController(1);
    }

    public double getDriveX() {
        return main.getLeftX();
    }
    
    public double getDriveY() {
        return main.getLeftY();
    }

    public double getDriveRot() {
        return main.getRightX();
    }
}
