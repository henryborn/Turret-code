// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain m_drivetrain;
  // The robot's subsystems and commands are defined here...

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drivetrain = new Drivetrain();

    m_drivetrain.setDefaultCommand(new RunCommand(() -> {
      double forwardVal = applyDeadband(m_driverController.getLeftY());
      double rotationalVal = applyDeadband(m_driverController.getRightX());

      if (forwardVal != 0 || rotationalVal != 0) m_drivetrain.Drive(forwardVal, rotationalVal);
      else m_drivetrain.stopDrive();
      
    }, m_drivetrain));

  }

  private double applyDeadband(double value) {
    if (Math.abs(value) < 0.00) { return 0; } return value;
  }
}
