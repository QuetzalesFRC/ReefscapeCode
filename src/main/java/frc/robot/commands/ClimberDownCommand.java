package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ClimberConstants;
import frc.robot.subsystems.ClimberSubsystem;

/** Comando para bajar el brazo */
public class ClimberDownCommand extends Command {
  private final ClimberSubsystem m_climber;

  /**
   * Baja el brazo y cuando termina lo mantiene ahi,
   *
   * @param arm = el subsistema a llamar
   */
  public ClimberDownCommand(ClimberSubsystem climber) {
    m_climber = climber;
    // Declarar las dependencias del subsystem
    addRequirements(climber);
  }

  // Ejecutar el comando cuando sea llamado
  @Override
  public void initialize() {}

  // Se ejecuta cada vez que se llama el comando
  @Override
  public void execute() {
    m_climber.setClimberSpeed(ClimberConstants.kArmClimberDown);
  }

  // Se ejecuta cuando el comando termina

  @Override
  public void end(boolean interrupted) {
    m_climber.setClimberSpeed(0);
  }

  // Regresa "true" cuando el comando haya terminado
  @Override
  public boolean isFinished() {
    return false;
  }
}
