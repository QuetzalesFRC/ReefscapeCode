package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.math.controller.PIDController;

public class RotateToAngleCommand extends Command{

    private final DriveSubsystem m_drive;

    private final PIDController pidController;

    private final double targetAngle;

    public RotateToAngleCommand(DriveSubsystem drive, double targetAngle) {
    
        m_drive = drive;

        this.targetAngle = targetAngle;

        this.pidController = new PIDController(0.01, 0.0, 0.001);

        pidController.enableContinuousInput(-180, 180);

        pidController.setTolerance(2.0);

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        pidController.setSetpoint(targetAngle);
    }

    @Override
    public void execute() {
        double rotationalSpeed = pidController.calculate(m_drive.getHeading());
        m_drive.drive(0,0,rotationalSpeed,true);
    }

    // Se ejecuta cuando el comando termina

    @Override
    public void end(boolean interrupted) {
        m_drive.drive(0,0,0,true);
    }

    @Override
    public boolean isFinished() {
        return pidController.atSetpoint();
    }
    
}
