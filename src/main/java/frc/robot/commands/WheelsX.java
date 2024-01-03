package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class WheelsX extends Command {
    private final DriveSubsystem m_driveSubsystem;

    /**
     * Locks the wheels into a x position
     * 
     * @param DriveSubsystem subsystem for driving
     *                       {@link frc.robot.subsystems.DriveSubsystem link}
     */
    public WheelsX(DriveSubsystem subsystem) {
        m_driveSubsystem = subsystem;
        addRequirements(m_driveSubsystem);
    }

    @Override
    public void initialize() {
        m_driveSubsystem.setX();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}