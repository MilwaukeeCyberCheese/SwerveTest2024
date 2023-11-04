//TODO make this prettier
package frc.robot.subsystems;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CameraSubsystem extends SubsystemBase{

    /**
     * CameraSubsystem class holds the cameras used for vision
     */
    public CameraSubsystem(){

    }

    public static PhotonCamera getRighty(){
        return Constants.VisionConstants.righty;
    }

    public static PhotonCamera getLeft(){
        return Constants.VisionConstants.lefty;
    }

}
