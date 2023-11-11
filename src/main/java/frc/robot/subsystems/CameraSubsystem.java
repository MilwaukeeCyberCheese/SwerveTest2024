//TODO make this prettier
package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CameraSubsystem extends SubsystemBase {
    private PhotonTrackedTarget target;
    double in;
    double in2;
    double in3;

    /**
     * CameraSubsystem class holds the cameras used for vision
     */
    public CameraSubsystem() {

    }

    public static PhotonCamera getRighty() {
        return Constants.VisionConstants.righty;
    }

    public static void switchRightIndex(int index){
        Constants.VisionConstants.righty.setPipelineIndex(index);
    }

    public static PhotonCamera getLeft() {
        return Constants.VisionConstants.lefty;
    }

    public PhotonTrackedTarget getRightTarget() {

        var result = Constants.VisionConstants.righty.getLatestResult();
        target = result.getBestTarget();
        return target;

    }

    public void logging(double in, double in2, double in3){
        this.in = in;
        this.in2 = in2;
        this.in3 = in3;
    }

    public void log() {
        SmartDashboard.putNumber("Gyro Yaw", Constants.Sensors.gyro.getYaw());
        SmartDashboard.putNumber("Pipeline Index", Constants.VisionConstants.righty.getPipelineIndex());
        try {
            SmartDashboard.putNumber("Target Yaw (deg)", target.getYaw());
            SmartDashboard.putNumber("Desired Angle (deg)", Constants.Sensors.gyro.getYaw() + target.getYaw());
            SmartDashboard.putNumber("Theta Output", in);

            SmartDashboard.putNumber("Target Distance (m)", in2);
            SmartDashboard.putNumber("Target Distance (in)", Units.metersToInches(in2));
            SmartDashboard.putNumber("Y Output", in3);
        } catch (Exception e) {
        }
    }

    @Override
    public void periodic() {
        log();
    }

}
