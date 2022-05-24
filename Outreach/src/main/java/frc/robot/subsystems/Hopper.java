package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import static frc.robot.Constants.*;

public class Hopper {
    private Servo servo;
    public Hopper() {
        servo = new Servo(0);
    
    }
    public void blockBalls(boolean block) {
        if (block) {
            servo.setAngle(SERVO_CLOSE);
            System.out.println("Servo open");
        } else {
            servo.setAngle(SERVO_OPEN);
        }
    }
}
