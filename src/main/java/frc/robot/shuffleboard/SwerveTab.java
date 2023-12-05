package frc.robot.shuffleboard;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.MAXSwerveModule;

public class SwerveTab {

    public static ShuffleboardTab swerve = Shuffleboard.getTab("Swerve");

    public static GenericEntry fLRot = swerve.add("FL Rotation", 0).withWidget(BuiltInWidgets.kDial)
            .withProperties(Map.of("min", 0, "max", 360))
            .getEntry();
    public static GenericEntry fLSpeed = swerve.add("FL Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
            .withProperties(Map.of("min", -3, "max", 3))
            .getEntry();

    public static GenericEntry fRRot = swerve.add("FR Rotation", 0).withWidget(BuiltInWidgets.kDial)
            .withProperties(Map.of("min", 0, "max", 360))
            .getEntry();
    public static GenericEntry fRSpeed = swerve.add("FR Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
            .withProperties(Map.of("min", -3, "max", 3))
            .getEntry();

    public static GenericEntry bLRot = swerve.add("BL Rotation", 0).withWidget(BuiltInWidgets.kDial)
            .withProperties(Map.of("min", 0, "max", 360))
            .getEntry();
    public static GenericEntry bLSpeed = swerve.add("BL Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
            .withProperties(Map.of("min", -3, "max", 3))
            .getEntry();

    public static GenericEntry bRRot = swerve.add("BR Rotation", 0).withWidget(BuiltInWidgets.kDial)
            .withProperties(Map.of("min", 0, "max", 360))
            .getEntry();
    public static GenericEntry bRSpeed = swerve.add("BR Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
            .withProperties(Map.of("min", -3, "max", 3))
            .getEntry();

    public static void logSwerve(MAXSwerveModule m_frontLeft, MAXSwerveModule m_frontRight, MAXSwerveModule m_backLeft,
            MAXSwerveModule m_backRight) {
        fLRot.setDouble(m_frontLeft.getState().angle.getDegrees());
        fLSpeed.setDouble(m_frontLeft.getState().speedMetersPerSecond);
        fRRot.setDouble(m_frontRight.getState().angle.getDegrees());
        fRSpeed.setDouble(m_frontRight.getState().speedMetersPerSecond);
        bLRot.setDouble(m_backLeft.getState().angle.getDegrees());
        bLSpeed.setDouble(m_backLeft.getState().speedMetersPerSecond);
        bRRot.setDouble(m_backRight.getState().angle.getDegrees());
        bRSpeed.setDouble(m_backRight.getState().speedMetersPerSecond);

    }
}