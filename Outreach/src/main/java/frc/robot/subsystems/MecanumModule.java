package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MecanumModule {
    private final TalonSRX motor;

    private static final double MAX_VELOCITY = 2; // Increase if you want it to go slower

    public MecanumModule(int motorID, boolean inverted) {
        motor = new TalonSRX(motorID);
        motor.setInverted(inverted);
    }

    public void set(double speed) {
        motor.set(ControlMode.PercentOutput, speed / MAX_VELOCITY);
        System.out.println(speed / MAX_VELOCITY);
    }
}
