// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;
//import frc.robot.commands.ArmDownAlgaeInCommand;
import frc.robot.commands.ArmDownCommand;
import frc.robot.commands.ArmUpCommand;
import frc.robot.commands.ClimberUpCommand;
import frc.robot.commands.ClimberDownCommand;
import frc.robot.commands.DriveWaitCommand;
import frc.robot.commands.GyroResetCommand;
//import// frc.robot.commands.GyroResetCommand;
//import frc.robot.commands.RotateToAngleCommand;
//import frc.robot.commands.SnapToAprilTagCommand;
import frc.robot.commands.RollerAlgaeInCommand;
import frc.robot.commands.RollerCoralOutCommandAuto;
import frc.robot.commands.RollerAlgaeOutCommand;
import frc.robot.commands.RollerCoralOutCommand;
import frc.robot.commands.RollerCoralOutBackCommand;
import frc.robot.subsystems.ArmSubsystem;

import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  

  // The driver's controller

  private final CommandXboxController m_driverController = 
            new CommandXboxController(OIConstants.kDriverControllerPort);


  private final CommandXboxController m_CommandController = 
      new CommandXboxController(1);

  public final RollerSubsystem m_roller = new RollerSubsystem();
  public final ArmSubsystem m_arm = new ArmSubsystem();
  public final ClimberSubsystem m_climber = new ClimberSubsystem();
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    

    NamedCommands.registerCommand("RollerCoralOutCommand", new RollerCoralOutCommandAuto(m_roller));
    NamedCommands.registerCommand("coralPick", new DriveWaitCommand(m_robotDrive));

    // Configure the button bindings
        configureBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */
  private void configureBindings() {


            // Configure default commands
    m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
         new RunCommand(
            () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(m_driverController.getLeftY(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getLeftX(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getRightX(), OIConstants.kDriveDeadband),
                true),
            m_robotDrive));


            /* m_driverController.povUp().whileTrue(new RotateToAngleCommand(m_robotDrive, 90));
            m_driverController.y().whileTrue(new GyroResetCommand(m_robotDrive));
            m_driverController.povLeft().whileTrue(new RotateToAngleCommand(m_robotDrive, 180));
            m_driverController.povDown().whileTrue(new RotateToAngleCommand(m_robotDrive, 270));
            m_driverController.povRight().whileTrue(new RotateToAngleCommand(m_robotDrive, 0));

           // m_CommandController.leftStick().whileTrue(new SnapToAprilTagCommand(m_robotDrive));



            //Controles del arm
     /*   m_driverController.leftBumper().whileTrue(new ArmDownCommand(m_arm));
        m_driverController.rightBumper().whileTrue(new ArmUpCommand(m_arm));
        //Controlles del alga
        m_driverController.x().whileTrue(new RollerCoralOutCommand(m_roller));
        m_driverController.a().whileTrue(new RollerAlgaeInCommand(m_roller));

        //Reset Giroscopio
        m_driverController.y().whileTrue(new GyroResetCommand(m_robotDrive));

        //Climber
        m_driverController.leftTrigger().whileTrue(new ClimberUpCommand(m_climber));
        m_driverController.rightTrigger().whileTrue(new ClimberDownCommand(m_climber));

        */



            //Controles del arm
            m_CommandController.leftBumper().whileTrue(new ArmDownCommand(m_arm));


            m_driverController.rightTrigger().whileTrue(new RunCommand(
              () -> m_robotDrive.drive(
                  -MathUtil.applyDeadband(m_driverController.getLeftY() * 0.6, OIConstants.kDriveDeadband),
                  -MathUtil.applyDeadband(m_driverController.getLeftX()* 0.6, OIConstants.kDriveDeadband),
                  -MathUtil.applyDeadband(m_driverController.getRightX()* 0.6, OIConstants.kDriveDeadband),
                  false),
              m_robotDrive));


            m_CommandController.rightBumper().whileTrue(new ArmUpCommand(m_arm));
            //Controlles del alga
            m_CommandController.x().whileTrue(new RollerAlgaeOutCommand(m_roller));
            m_CommandController.a().whileTrue(new RollerAlgaeInCommand(m_roller));

            //Controles del Coral
            m_CommandController.y().whileTrue(new RollerCoralOutCommand(m_roller));
            m_CommandController.b().whileTrue(new RollerCoralOutBackCommand(m_roller));
    
            //Reset Giroscopio
            m_driverController.y().whileTrue(new GyroResetCommand(m_robotDrive));
    
            //Climber
            m_CommandController.leftTrigger().whileTrue(new ClimberUpCommand(m_climber));
            m_CommandController.rightTrigger().whileTrue(new ClimberDownCommand(m_climber));

    
        
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    return new PathPlannerAuto("Get_Out");
 
  }
}