package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.RollerConstants;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCoralOutBackCommand extends Command {

    private final RollerSubsystem m_roller;

    public RollerCoralOutBackCommand(RollerSubsystem roller) {
    
        m_roller = roller;

        addRequirements(roller);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        m_roller.runRollers(RollerConstants.kArmRollerCoralOutBack);
    }

    // Se ejecuta cuando el comando termina

    @Override
    public void end(boolean interrupted) {
        m_roller.runRollers(0);
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}

