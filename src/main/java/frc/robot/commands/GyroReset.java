package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class GyroReset extends Command {

    /**
     * Resets the gyro angle to zero
     * 
     */
    public GyroReset() {
    }

    @Override
    public void initialize() {
        Constants.Sensors.gyro.reset();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}