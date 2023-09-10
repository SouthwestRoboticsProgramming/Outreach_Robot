package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Shooter {
    private final TalonSRX motor;

    public Shooter() {
        motor = new TalonSRX(20);
    }

    public void spin(double speed) {
        motor.set(ControlMode.PercentOutput, speed);
    }
}
