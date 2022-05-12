package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MecanumModule extends SubsystemBase{
    private final TalonSRX motor;
    private double speed;

    private static final double MAX_VELOCITY = 4; // Increase if you want it to go slower

    public MecanumModule(int motorID) {
        motor = new TalonSRX(motorID);
    }

    public void set(double speed) {
        this.speed = speed;
    }

    @Override
    public void periodic() {
        motor.set(ControlMode.PercentOutput, speed / MAX_VELOCITY);
    }
}
