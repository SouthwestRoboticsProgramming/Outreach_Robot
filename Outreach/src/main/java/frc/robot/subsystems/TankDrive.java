package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ShuffleBoard;

public class TankDrive extends SubsystemBase {
    private static final int FL_ID = 10;
    private static final int FR_ID = 11;
    private static final int BL_ID = 12;
    private static final int BR_ID = 13;

    private final TalonSRX leftLeader;
    private final TalonSRX rightLeader;

    public TankDrive() {
        leftLeader = new TalonSRX(FL_ID);
        rightLeader = new TalonSRX(FR_ID);

        TalonSRX leftFollower = new TalonSRX(BL_ID);
        TalonSRX rightFollower = new TalonSRX(BR_ID);
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);

        leftLeader.setInverted(ShuffleBoard.DRIVE_INVERT_L.getBoolean(false));
        rightLeader.setInverted(ShuffleBoard.DRIVE_INVERT_R.getBoolean(true));
        leftFollower.setInverted(InvertType.FollowMaster);
        rightFollower.setInverted(InvertType.FollowMaster);
    }

    // +drive forward, +turn right
    public void drive(double drive, double turn) {
        double left = drive + turn;
        double right = drive - turn;

        double max = Math.max(Math.abs(left), Math.abs(right));
        if (max > 1) {
            left /= max;
            right /= max;
        }

        leftLeader.set(ControlMode.PercentOutput, left);
        rightLeader.set(ControlMode.PercentOutput, right);
    }
}
