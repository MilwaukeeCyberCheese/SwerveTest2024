// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autos.AutoTest;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // creates sendable chooser for autos
  public static final SendableChooser<SequentialCommandGroup> m_autoChooser = new SendableChooser<>();

=======
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
>>>>>>> fae966c (updated to 2024)
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
<<<<<<< HEAD
   * This function is run when the robot is first started up and should be used
   * for any
=======
   * This function is run when the robot is first started up and should be used for any
>>>>>>> fae966c (updated to 2024)
   * initialization code.
   */
  @Override
  public void robotInit() {
<<<<<<< HEAD
    // add autos
    m_autoChooser.setDefaultOption("Zilch", null);
    m_autoChooser.addOption("Test", new AutoTest(RobotContainer.m_robotDrive));
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
=======
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
>>>>>>> fae966c (updated to 2024)
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
<<<<<<< HEAD
   * This function is called every 20 ms, no matter the mode. Use this for items
   * like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
=======
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
>>>>>>> fae966c (updated to 2024)
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
<<<<<<< HEAD
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
=======
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
>>>>>>> fae966c (updated to 2024)
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
<<<<<<< HEAD
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
=======
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
>>>>>>> fae966c (updated to 2024)
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
<<<<<<< HEAD
  public void autonomousPeriodic() {
  }
=======
  public void autonomousPeriodic() {}
>>>>>>> fae966c (updated to 2024)

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
<<<<<<< HEAD
  public void teleopPeriodic() {
  }
=======
  public void teleopPeriodic() {}
>>>>>>> fae966c (updated to 2024)

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
<<<<<<< HEAD
  public void testPeriodic() {
  }
=======
  public void testPeriodic() {}
>>>>>>> fae966c (updated to 2024)
}
