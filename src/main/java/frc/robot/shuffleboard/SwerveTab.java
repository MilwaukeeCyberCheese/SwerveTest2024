package frc.robot.shuffleboard;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.MAXSwerveModule;

public class SwerveTab {

        public static ShuffleboardTab swerveTab = Shuffleboard.getTab("Swerve");

        public static GenericEntry fLRot = swerveTab.add("FL Rotation", 0).withWidget(BuiltInWidgets.kDial)
                        .withProperties(Map.of("min", 0, "max", 360)).withSize(5, 5).withPosition(3, 0)
                        .getEntry();
        public static GenericEntry fLSpeed = swerveTab.add("FL Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withProperties(Map.of("min", -3, "max", 3)).withSize(2, 5).withPosition(1, 0)
                        .getEntry();

        public static GenericEntry fRRot = swerveTab.add("FR Rotation", 0).withWidget(BuiltInWidgets.kDial)
                        .withProperties(Map.of("min", 0, "max", 360)).withSize(5, 5).withPosition(11, 0)
                        .getEntry();
        public static GenericEntry fRSpeed = swerveTab.add("FR Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withPosition(9, 0)
                        .withProperties(Map.of("min", -3, "max", 3)).withSize(2, 5)
                        .getEntry();

        public static GenericEntry bLRot = swerveTab.add("BL Rotation", 0).withWidget(BuiltInWidgets.kDial)
                        .withProperties(Map.of("min", 0, "max", 360)).withSize(5, 5).withPosition(3, 5)
                        .getEntry();
        public static GenericEntry bLSpeed = swerveTab.add("BL Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withPosition(1, 5)
                        .withProperties(Map.of("min", -3, "max", 3)).withSize(2, 5)
                        .getEntry();

        public static GenericEntry bRRot = swerveTab.add("BR Rotation", 0).withWidget(BuiltInWidgets.kDial)
                        .withProperties(Map.of("min", 0, "max", 360)).withSize(5, 5).withPosition(11, 5)
                        .getEntry();
        public static GenericEntry bRSpeed = swerveTab.add("BR Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withPosition(9, 5)
                        .withProperties(Map.of("min", -3, "max", 3)).withSize(2, 5)
                        .getEntry();

        public static void logSwerve(MAXSwerveModule m_frontLeft, MAXSwerveModule m_frontRight,
                        MAXSwerveModule m_backLeft,
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