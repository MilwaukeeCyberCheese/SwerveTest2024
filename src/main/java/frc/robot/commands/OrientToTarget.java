package frc.robot.commands;

import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class OrientToTarget extends Command {
    private final DriveSubsystem m_driveSubsystem;
    private final CameraSubsystem m_cameraSubsytem;
    private PIDController thetaController = new PIDController(Constants.AutoConstants.kThetaPIDConstants.kP,
            Constants.AutoConstants.kThetaPIDConstants.kI, Constants.AutoConstants.kThetaPIDConstants.kD);

    /**
     * 
     * @param driveSubsystem  subsystem for driving the robot
     *                        {@link frc.robot.subsystems.DriveSubsystem link}
     * @param cameraSubsystem subsystem containing the cameras
     *                        {@link frc.robot.subsystems.CameraSubsystem link}
     */
    public OrientToTarget(DriveSubsystem driveSubsystem, CameraSubsystem cameraSubsystem) {
        m_driveSubsystem = driveSubsystem;
        m_cameraSubsytem = cameraSubsystem;
        addRequirements(m_cameraSubsytem, m_driveSubsystem);
    }

    @Override
    public void execute() {
        double thetaOutput = 0;
        PhotonTrackedTarget target = m_cameraSubsytem.getRightTarget();
        if (target != null) {
            double desiredAngle = Constants.Sensors.gyro.getYaw() + target.getYaw();
            thetaController.setSetpoint(desiredAngle);
            thetaOutput = thetaController.calculate(Constants.Sensors.gyro.getYaw());
        }

        m_cameraSubsytem.logging(thetaOutput, 0, 0);

        m_driveSubsystem.drive(0.0, 0.0, thetaOutput, false, false, false);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
