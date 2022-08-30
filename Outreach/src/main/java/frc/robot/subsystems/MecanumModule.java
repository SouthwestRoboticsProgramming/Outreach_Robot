package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MecanumModule {

    // Constant
    private static final double MAX_POSSIBLE_VELOCITY = 3.7;

    // Final because the motor will never swap ID's
    private final TalonSRX motor; 

    // v This is a constructor
    public MecanumModule(int motorID, boolean isInverted) {
        // Set the motor's ID
        motor = new TalonSRX(motorID);

        // Set if the motor should be inverted
        motor.setInverted(isInverted);
    }

    // Public because used in other files, void because there is no output
    public void setVelocity(double velocity) {

        // Convert from velocity to percentage
        double percentOutput = velocity / MAX_POSSIBLE_VELOCITY;

        // Set the motor to that percentage
        motor.set(ControlMode.PercentOutput, percentOutput);
    }
}
