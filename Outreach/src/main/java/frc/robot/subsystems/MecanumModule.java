package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import static frc.robot.Constants.MAX_WHEEL_VELOCITY;

public class MecanumModule {
    private final TalonSRX motor;

    public MecanumModule(int motorID, boolean inverted) {
        motor = new TalonSRX(motorID);
        motor.setInverted(inverted);
    }

    public void set(double speed) {
        motor.set(ControlMode.PercentOutput, speed / MAX_WHEEL_VELOCITY);
        System.out.println(speed / MAX_WHEEL_VELOCITY);
    }
}
