package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CameraSubsystem;
import java.util.function.IntSupplier;

public class SwitchRightPipeline extends Command {
    private CameraSubsystem m_cameraSubsystem;
    private IntSupplier m_pipelineIndex;

    /**
     * Switch pipeline of a camera
     * 
     * @param cameraSubsystem subsystem containing the cameras
     *                        {@link frc.robot.subsystems.CameraSubsystem link}
     * @param pipelineIndex   the number of the pipeline to switch to
     */
    public SwitchRightPipeline(CameraSubsystem cameraSubsystem, IntSupplier pipelineIndex) {
        m_cameraSubsystem = cameraSubsystem;
        m_pipelineIndex = pipelineIndex;
        addRequirements(m_cameraSubsystem);
    }

    @Override
    public void initialize() {
        CameraSubsystem.switchIndex(m_pipelineIndex.getAsInt(), 1);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
