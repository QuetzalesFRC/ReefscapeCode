package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

/** Comando para bajar el brazo */
public class ArmUpCommand extends Command {
  private final ArmSubsystem m_arm;

  /**
   * Baja el brazo y cuando termina lo mantiene ahi,
   *
   * @param arm = el subsistema a llamar
   */
  public ArmUpCommand(ArmSubsystem arm) {
    m_arm = arm;
    // Declarar las dependencias del subsystem
    addRequirements(arm);
  }

  // Ejecutar el comando cuando sea llamado
  @Override
  public void initialize() {}

  // Se ejecuta cada vez que se llama el comando
  @Override
  public void execute() {
    m_arm.setArmSpeed(ArmConstants.kArmUp);
  }

  // Se ejecuta cuando el comando termina

  @Override
  public void end(boolean interrupted) {
    m_arm.setArmSpeed(0);
  }

  // Regresa "true" cuando el comando haya terminado
  @Override
  public boolean isFinished() {
    return false;
  }
}