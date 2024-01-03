//TODO make this prettier
package frc.robot.subsystems;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.targeting.PhotonTrackedTarget;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CameraSubsystem extends SubsystemBase {
    private PhotonTrackedTarget target;

    /**
     * CameraSubsystem class holds the cameras used for vision
     */
    public CameraSubsystem() {

    }

    /**
     * switches pipeline of a camera
     * 
     * @param index  pipeline to switch to
     * @param camera camera to switch pipelines for
     */
    public static void switchIndex(int index, int camera) {
        switch (camera) {
            case 0:
                Constants.VisionConstants.kLefty.setPipelineIndex(index);
                break;

            case 1:
                Constants.VisionConstants.kRighty.setPipelineIndex(index);
                break;
        }

    }


    /**
     * Returns target detected by the left camera
     * <p>
     * Before using the target, ensure that it is present
     * 
     * @return the target found by the left camera
     * 
     */
    public PhotonTrackedTarget getLeftTarget() {

        var result = Constants.VisionConstants.kLefty.getLatestResult();
        target = result.getBestTarget();
        return target;

    }

    /**
     * Returns target detected by the right camera
     * <p>
     * Before using the target, ensure that it is present
     * 
     * @return the target found by the right camera
     * 
     */
    public PhotonTrackedTarget getRightTarget() {

        var result = Constants.VisionConstants.kRighty.getLatestResult();
        target = result.getBestTarget();
        return target;

    }

    public void log() {
        SmartDashboard.putNumber("Gyro Yaw", Constants.Sensors.gyro.getYaw() * ((Constants.DriveConstants.kGyroReversed) ? -1 : 1));
    }

    @Override
    public void periodic() {
        log();
        updateOdometry();
    }

    /**
     * Update the odometry based on aprilTags
     */
    public void updateOdometry() {
        Constants.VisionConstants.kPhotonPoseEstimator
                .setReferencePose(Constants.DriveConstants.m_odometry.getEstimatedPosition());
        var result = Constants.VisionConstants.kPhotonPoseEstimator.update();
        if (result.isPresent()) {
            EstimatedRobotPose estimate = result.get();
            Constants.DriveConstants.m_odometry.addVisionMeasurement(estimate.estimatedPose.toPose2d(),
                    estimate.timestampSeconds);
            // may be necessary to use @link Timer instead of .timestampSeconds
        }
    }

}
