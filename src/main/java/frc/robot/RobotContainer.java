// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveStop;
import frc.robot.commands.FollowTarget;
import frc.robot.commands.GyroReset;
import frc.robot.commands.OrientToTarget;
import frc.robot.commands.SwitchPipeline;
import frc.robot.commands.WheelsX;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.utils.FilteredButton;
import frc.robot.utils.FilteredJoystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
        // Initialize subsystems
        public final static DriveSubsystem m_robotDrive = new DriveSubsystem();
        private final static CameraSubsystem m_cameraSubsytem = new CameraSubsystem();

        // initialize the controllers
        // the one on the left
        public static FilteredJoystick m_leftJoystick = new FilteredJoystick(0);
        // the one on the right
        public static FilteredJoystick m_rightJoystick = new FilteredJoystick(1);
        FilteredButton m_buttons = new FilteredButton(OIConstants.kButtonPort);

        /**
         * The container for the robot. Contains subsystems, OI devices, and commands.
         */
        public RobotContainer() {
                // Configure the button bindings
                configureButtonBindings();

                // set default command for drive
                m_robotDrive.setDefaultCommand(new DriveCommand(m_robotDrive, m_rightJoystick::getX,
                                m_rightJoystick::getY, m_leftJoystick::getX,
                                () -> !m_rightJoystick.getButtonSix(),
                                Constants.DriveConstants.kRateLimitsEnabled, m_rightJoystick::getButtonTwo,
                                m_rightJoystick::getThrottle));

        }

        /**
         * 2
         * Use this method to define your button->command mappings. Buttons can be
         * created by
         * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
         * subclasses ({@link
         * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
         * passing it to a
         * {@link JoystickButton}.
         */
        private void configureButtonBindings() {
                // top left button and x button on controller sets wheels to x
                new Trigger(m_buttons::getOneA).or(
                                m_rightJoystick::getButtonSeven).whileTrue(new WheelsX(m_robotDrive));
                // top right button resets gyro
                new Trigger(m_buttons::getOneC).or(m_rightJoystick::getButtonFive).onTrue(new GyroReset());
                // bottom middle button stops drive
                new Trigger(m_buttons::getThreeB).whileTrue(new DriveStop(m_robotDrive));
                //orient to target
                new Trigger(m_rightJoystick::getButtonThree).whileTrue(new OrientToTarget(m_robotDrive, m_cameraSubsytem));
                new Trigger(m_rightJoystick::getButtonFour).whileTrue(new FollowTarget(m_robotDrive, m_cameraSubsytem));
                new Trigger(m_leftJoystick::getButtonFour).onTrue(new SwitchPipeline(m_cameraSubsytem, Constants.VisionConstants.kConeIndex));
                new Trigger(m_leftJoystick::getButtonFive).onTrue(new SwitchPipeline(m_cameraSubsytem, Constants.VisionConstants.kCubeIndex));
                
        }

        /**
         * Use this to pass the autonomous command to the main {@link Robot} class.
         *
         * @return the command to run in autonomous
         */
        public Command getAutonomousCommand() {
                return Robot.m_autoChooser.getSelected();
        }
}
