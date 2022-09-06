package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import static frc.robot.Constants.*;

public class Hopper {
    private Servo servo;
    private boolean lastBlock = false;
    private int timer;

    public Hopper() {
        servo = new Servo(0);
    }

    public void blockBalls(boolean block) {
        if (block && !lastBlock) {
            timer = BLOCK_TIMER_TIME;
        }

        if (block || timer > 0) {
            servo.setAngle(SERVO_OPEN);
            System.out.println("Servo open");
        } else {
            servo.setAngle(SERVO_CLOSE);
        }

        if (timer > 0)
            timer--;
    }
}
