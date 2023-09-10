package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.ShuffleBoard;

public class Hopper {
    private Servo servo;
    private boolean lastBlock = false;
    private int timer;

    public Hopper() {
        servo = new Servo(0);
    }

    public void blockBalls(boolean block) {
        if (block && !lastBlock) {
            timer = (int) ShuffleBoard.HOPPER_TIMER_TIME.getDouble(50);
        }

        if (block || timer > 0) {
            servo.setAngle(ShuffleBoard.HOPPER_SERVO_OPEN.getDouble(30));
            System.out.println("Servo open");
        } else {
            servo.setAngle(ShuffleBoard.HOPPER_SERVO_CLOSE.getDouble(100));
        }

        if (timer > 0)
            timer--;
    }
}
