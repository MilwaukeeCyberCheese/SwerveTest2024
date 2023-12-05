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
    private PIDController thetaController = new PIDController(Constants.AutoConstants.kThetaPIDConstants.kP,
            Constants.AutoConstants.kThetaPIDConstants.kI, Constants.AutoConstants.kThetaPIDConstants.kD);

    private PIDController translationController = new PIDController(Constants.AutoConstants.kTranslationPIDConstants.kP,
            Constants.AutoConstants.kTranslationPIDConstants.kI, Constants.AutoConstants.kTranslationPIDConstants.kD);

    /**
     * Point towards, and move towards, a detected
     * {@link org.photonvision.targeting.PhotonTrackedTarget#PhotonTrackedTarget()
     * PhotonTrackedTarget}
     * 
     * @param driveSubsystem  subsystem used for driving
     *                        {@link frc.robot.subsystems.DriveSubsystem link}
     * @param cameraSubsystem subsystem containing the cameras
     *                        {@link frc.robot.subsystems.CameraSubsystem link}
     */
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
                yOutput = -translationController.calculate(range, 0.5);
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
