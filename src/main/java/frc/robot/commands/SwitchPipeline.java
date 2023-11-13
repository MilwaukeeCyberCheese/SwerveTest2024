package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CameraSubsystem;
import java.util.function.DoubleSupplier;

public class SwitchPipeline extends Command {
    private CameraSubsystem m_cameraSubsystem;
    private DoubleSupplier m_pipelineIndex;

    public SwitchPipeline(CameraSubsystem cameraSubsystem, DoubleSupplier pipelineIndex) {
        m_cameraSubsystem = cameraSubsystem;
        m_pipelineIndex = pipelineIndex;
        addRequirements(m_cameraSubsystem);
    }

    @Override
    public void initialize() {
        CameraSubsystem.switchRightIndex((int) m_pipelineIndex.getAsDouble());
    }

    @Override
    public boolean isFinished(){
        return true;
    }

}
