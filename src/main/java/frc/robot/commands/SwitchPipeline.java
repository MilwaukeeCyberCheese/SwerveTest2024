package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CameraSubsystem;
import java.util.function.IntSupplier;

public class SwitchPipeline extends Command {
    private CameraSubsystem m_cameraSubsystem;
    private IntSupplier m_pipelineIndex;

    public SwitchPipeline(CameraSubsystem cameraSubsystem, IntSupplier pipelineIndex) {
        m_cameraSubsystem = cameraSubsystem;
        m_pipelineIndex = pipelineIndex;
        addRequirements(m_cameraSubsystem);
    }

    @Override
    public void initialize() {
        CameraSubsystem.switchRightIndex(m_pipelineIndex.getAsInt());
    }

    @Override
    public boolean isFinished(){
        return true;
    }

}
