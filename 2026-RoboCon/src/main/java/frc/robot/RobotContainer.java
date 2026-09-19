// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project..

package frc.robot;

import frc.robot.Subsystems.Carpet;
import frc.robot.Subsystems.Intaker;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Drive.Swerve;
import frc.robot.Commands.Drive;
import frc.robot.Commands.ShootFaster;
import frc.robot.Commands.ShootSlower;
import frc.robot.Util.Controllers;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  public Controllers u_Controllers;
  public Swerve s_Swerve;
  public Drive c_Drive;
  public Shooter s_Shooter; 
  public Intaker s_Intaker;
  public Carpet s_Carpet;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings 
    robotFiles();
    s_Swerve.setDefaultCommand(c_Drive);
    configureBindings();
    //TODO: Add auto chooser here.
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void robotFiles() {
    u_Controllers = new Controllers();
    s_Swerve = new Swerve();
    s_Shooter = new Shooter();
    s_Intaker = new Intaker();
    s_Carpet = new Carpet();
    c_Drive = new Drive(s_Swerve, u_Controllers.leftStick, u_Controllers.rightStick);
  }

  private void configureBindings() {
    //Drive Bindings
    u_Controllers.FO_toggle.toggleOnTrue(s_Swerve.fieldOrientedToggle());
    u_Controllers.zeroHeading.toggleOnTrue(Commands.runOnce(() -> s_Swerve.zeroHeading()));
    u_Controllers.resetWheels.onTrue(s_Swerve.resetWheels());

    //Subsystem Bindings
    u_Controllers.shootInc.onTrue(new ShootFaster(s_Shooter));
    u_Controllers.shootDec.onTrue(new ShootSlower(s_Shooter));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return Commands.none();
  }
}
