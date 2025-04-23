package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.RollerConstants;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCoralOutCommandAuto extends Command {

    private final RollerSubsystem m_roller;

    private final Timer timer;

    public RollerCoralOutCommandAuto(RollerSubsystem roller) {
    
        m_roller = roller;

        addRequirements(roller);

        timer = new Timer();
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        m_roller.runRollers(RollerConstants.kArmRollerCoralOutFront);
    }

    // Se ejecuta cuando el comando termina
    // En este caso se necesita conservar el arm en su poscicion
    // Cuando el siguiente comando sea llamado, este se detendra
    @Override
    public void end(boolean interrupted) {
        m_roller.runRollers(0);
        timer.reset();
    }

    @Override
    public boolean isFinished() {
      if (timer.get() > 1) {
        return true;
      } else {
        return false;
      }
    }
}

