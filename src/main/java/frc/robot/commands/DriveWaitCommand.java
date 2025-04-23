package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveWaitCommand extends Command {
    
    private final DriveSubsystem m_drive;
    private final Timer m_timer = new Timer();

    public DriveWaitCommand(DriveSubsystem drive) {

        m_drive = drive;

        addRequirements(drive);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        m_timer.start();
        while (m_timer.get() < 3) {
            
            m_drive.drive(0,0,0,false);

        }
        m_timer.reset();
    }
}
