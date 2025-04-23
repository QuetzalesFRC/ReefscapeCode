package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj2.command.Command;


public class GyroResetCommand extends Command {
     private final DriveSubsystem m_drive;

  /**
   * Baja el brazo y cuando termina lo mantiene ahi,
   *
   * @param arm = el subsistema a llamar
   */
  public GyroResetCommand(DriveSubsystem drive) {
    m_drive = drive;
    // Declarar las dependencias del subsystem
    addRequirements(drive);
  }

  // Ejecutar el comando cuando sea llamado
  @Override
  public void initialize() {}

  // Se ejecuta cada vez que se llama el comando
  @Override
  public void execute() {
    m_drive.zeroHeading();
  }

  // Se ejecuta cuando el comando termina

  @Override
  public void end(boolean interrupted) {
  }

  // Regresa "true" cuando el comando haya terminado
  @Override
  public boolean isFinished() {
    return false;
  }
}
