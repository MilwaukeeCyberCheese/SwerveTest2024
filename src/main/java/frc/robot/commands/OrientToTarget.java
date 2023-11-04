package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class OrientToTarget extends CommandBase {
    private final DriveSubsystem m_driveSubsystem;
    private final CameraSubsystem m_cameraSubsytem;

    public OrientToTarget(DriveSubsystem driveSubsystem, CameraSubsystem cameraSubsystem) {
        m_driveSubsystem = driveSubsystem;
        m_cameraSubsytem = cameraSubsystem;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
