// Tell java what folders the file is in
package frc.robot.subsystems;

// Get some code that we didn't write
import com.ctre.phoenix.motorcontrol.ControlMode;
// Get some more code that we didn't write
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// Tell what one mecanum module should be able to do
public class MecanumModule {

    // Create a permanent motor controled by a TalonSRX

     // Create a Mecanum Module that needs to know motor ID and if it should spin backwards
    public MecanumModule(int motorID, boolean backwards) {

        // Give the motor an ID using the 'motorID' variable

        // Set if the motor should always drive backwards using the 'backwards' variable
    }

    // Create a function that needs to know how fast to set the motor. It will not have an number output.
    public void setPercent(double percent) {

        // Tell the motor to spin at the percent using the 'percent' variable.
    }





     
}
