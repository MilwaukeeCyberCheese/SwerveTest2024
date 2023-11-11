package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraSubsystem;

public class SwitchPipeline extends CommandBase{
    private CameraSubsystem m_cameraSubsystem;

    public SwitchPipeline(CameraSubsystem cameraSubsystem){
        m_cameraSubsystem = cameraSubsystem;
        addRequirements(m_cameraSubsystem);
    }
    
}
