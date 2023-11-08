package frc.robot.commands;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class OrientToTarget extends CommandBase {
    private final DriveSubsystem m_driveSubsystem;
    private final CameraSubsystem m_cameraSubsytem;
    private ProfiledPIDController thetaController = new ProfiledPIDController(
                Constants.AutoConstants.kPThetaController, 0, 0, Constants.AutoConstants.kThetaControllerConstraints);

    public OrientToTarget(DriveSubsystem driveSubsystem, CameraSubsystem cameraSubsystem) {
        m_driveSubsystem = driveSubsystem;
        m_cameraSubsytem = cameraSubsystem;
    }

    @Override
    public void execute() {
        double desiredAngle = Constants.Sensors.gyro.getYaw() + m_cameraSubsytem.getRightTarget().getYaw();
        thetaController.setGoal(desiredAngle);

        double thetaOutput = thetaController.calculate(Constants.Sensors.gyro.getYaw());

        m_driveSubsystem.drive(0.0, 0.0, thetaOutput, false, true, false);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
