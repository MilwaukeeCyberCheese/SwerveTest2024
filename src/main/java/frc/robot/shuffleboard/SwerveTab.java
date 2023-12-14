package frc.robot.shuffleboard;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ComplexWidget;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants;
import frc.robot.subsystems.MAXSwerveModule;

public class SwerveTab {

        public static ShuffleboardTab swerveTab = Shuffleboard.getTab("Swerve");

        public static GenericEntry fLRot = swerveTab.add("FL Rotation", 0).withWidget(BuiltInWidgets.kGyro)
                        .withProperties(Map.of()).withSize(2, 2).withPosition(1, 0)
                        .getEntry();
        public static GenericEntry fLSpeed = swerveTab.add("FL Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withProperties(Map.of("min", 0, "max", 3, "orientation", "VERTICAL", "show text", false))
                        .withSize(1, 2).withPosition(0, 0)
                        .getEntry();

        public static GenericEntry fRRot = swerveTab.add("FR Rotation", 0).withWidget(BuiltInWidgets.kGyro)
                        .withProperties(Map.of()).withSize(2, 2).withPosition(8, 0)
                        .getEntry();
        public static GenericEntry fRSpeed = swerveTab.add("FR Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withProperties(Map.of("min", 0, "max", 3, "orientation", "VERTICAL", "show text", false))
                        .withSize(1, 2).withPosition(7, 0)
                        .getEntry();

        public static GenericEntry bLRot = swerveTab.add("BL Rotation", 0).withWidget(BuiltInWidgets.kGyro)
                        .withProperties(Map.of()).withSize(2, 2).withPosition(1, 2)
                        .getEntry();
        public static GenericEntry bLSpeed = swerveTab.add("BL Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withProperties(Map.of("min", 0, "max", 3, "orientation", "VERTICAL", "show text", false))
                        .withSize(1, 2).withPosition(0, 2)
                        .getEntry();

        public static GenericEntry bRRot = swerveTab.add("BR Rotation", 0).withWidget(BuiltInWidgets.kGyro)
                        .withProperties(Map.of()).withSize(2, 2).withPosition(8, 2)
                        .getEntry();
        public static GenericEntry bRSpeed = swerveTab.add("BR Speed", 0).withWidget(BuiltInWidgets.kNumberBar)
                        .withProperties(Map.of("min", 0, "max", 3, "orientation", "VERTICAL", "show text", false))
                        .withSize(1, 2).withPosition(7, 2)
                        .getEntry();

        public static ComplexWidget gyroOdo = swerveTab.add("Gyroscope", Constants.Sensors.gyro)
                        .withWidget(BuiltInWidgets.kGyro)
                        .withProperties(Map.of("major tick spacing", 30)).withSize(2, 2).withPosition(4, 0);

        public static ComplexWidget gyroAccel = swerveTab.add("Accelerometer", Constants.Sensors.gyro)
                        .withWidget(BuiltInWidgets.k3AxisAccelerometer).withProperties(Map.of()).withSize(2, 2)
                        .withPosition(4, 3);

        /**
         * Add positions of swerve modules to the dashboard
         * 
         * @param m_frontLeft  front left module
         * @param m_frontRight front right module
         * @param m_backLeft   back left module
         * @param m_backRight  back right module
         */
        public static void logSwerve(MAXSwerveModule m_frontLeft, MAXSwerveModule m_frontRight,
                        MAXSwerveModule m_backLeft,
                        MAXSwerveModule m_backRight) {
                fLRot.setDouble(m_frontLeft.getState().angle.getDegrees());
                fLSpeed.setDouble(Math.abs(m_frontLeft.getState().speedMetersPerSecond));
                fRRot.setDouble(m_frontRight.getState().angle.getDegrees());
                fRSpeed.setDouble(Math.abs(m_frontRight.getState().speedMetersPerSecond));
                bLRot.setDouble(m_backLeft.getState().angle.getDegrees());
                bLSpeed.setDouble(Math.abs(m_backLeft.getState().speedMetersPerSecond));
                bRRot.setDouble(m_backRight.getState().angle.getDegrees());
                bRSpeed.setDouble(Math.abs(m_backRight.getState().speedMetersPerSecond));

        }
}