package frc.robot.commands;

import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class FollowTarget extends Command {
    private final DriveSubsystem m_driveSubsystem;
    private final CameraSubsystem m_cameraSubsytem;
    private PIDController thetaController = new PIDController(
            0.01, 0, 0);
    private PIDController yController = new PIDController(0.05, 0, 0);

    public FollowTarget(DriveSubsystem driveSubsystem, CameraSubsystem cameraSubsystem) {
        m_driveSubsystem = driveSubsystem;
        m_cameraSubsytem = cameraSubsystem;
        addRequirements(m_cameraSubsytem, m_driveSubsystem);
    }

    @Override
    public void execute() {
        double thetaOutput = 0;
        double yOutput = 0;
        PhotonTrackedTarget target = m_cameraSubsytem.getRightTarget();
        double range = 0;
        if (target != null) {
            double desiredAngle = Constants.Sensors.gyro.getYaw() + target.getYaw();
            thetaOutput = thetaController.calculate(Constants.Sensors.gyro.getYaw(), desiredAngle);

            range = PhotonUtils.calculateDistanceToTargetMeters(
                    Constants.VisionConstants.kCameraHeight,
                    Constants.VisionConstants.kCubeHeight,
                    0,
                    Units.degreesToRadians(target.getPitch()));
            if (range > 0.2) {
                yOutput = -yController.calculate(range, 0.5);
            }
        }

        m_cameraSubsytem.logging(thetaOutput, range, yOutput);

        m_driveSubsystem.drive(0.0, yOutput, thetaOutput, false, false, false);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
