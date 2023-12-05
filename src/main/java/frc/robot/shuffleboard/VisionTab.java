package frc.robot.shuffleboard;

import java.util.Map;

import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class VisionTab {
    public static ShuffleboardTab visionTab = Shuffleboard.getTab("Vision");

    HttpCamera leftCam = new HttpCamera("Lefty Camera", "http://frcvision.local:1181/stream.mjpg");
    HttpCamera rightCam = new HttpCamera("Righty Camera", "http://frcvision.local:1183/stream.mjpg")
    //TODO put proper url

    visionTab.add(leftCam);
    visionTab.add(rightCam);

    

    
    
}