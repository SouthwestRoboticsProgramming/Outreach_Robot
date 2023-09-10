package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public final class ShuffleBoard {
    private static final ShuffleboardTab TAB_TUNING = Shuffleboard.getTab("Tune Values");
    
    private static final ShuffleboardLayout DRIVE = TAB_TUNING.getLayout("Tank Drive", BuiltInLayouts.kList);
    public static final NetworkTableEntry DRIVE_INVERT_L = DRIVE.addPersistent("Invert Left", false).getEntry();
    public static final NetworkTableEntry DRIVE_INVERT_R = DRIVE.addPersistent("Invert Right", true).getEntry();
    public static final NetworkTableEntry DRIVE_SPEED = DRIVE.addPersistent("Drive Speed", 0.5).getEntry();
    public static final NetworkTableEntry DRIVE_TURN_SPEED = DRIVE.addPersistent("Turn Speed", 0.5).getEntry();

    private static final ShuffleboardLayout SHOOTER = TAB_TUNING.getLayout("Shooter", BuiltInLayouts.kList);
    public static final NetworkTableEntry SHOOTER_SPEED = SHOOTER.addPersistent("Max Speed", 0.7).getEntry();
    
    private static final ShuffleboardLayout HOPPER = TAB_TUNING.getLayout("Hopper", BuiltInLayouts.kList);
    public static final NetworkTableEntry HOPPER_TIMER_TIME = HOPPER.addPersistent("Block Timer Time", 50).getEntry();
    public static final NetworkTableEntry HOPPER_SERVO_OPEN = HOPPER.addPersistent("Servo Open", 65).getEntry();
    public static final NetworkTableEntry HOPPER_SERVO_CLOSE = HOPPER.addPersistent("Servo Close", 117).getEntry();
}
