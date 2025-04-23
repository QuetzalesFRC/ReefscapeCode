package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Limelight.LimelightHelpers;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.math.controller.PIDController;

public class SnapToAprilTagCommand extends Command{

    private final DriveSubsystem m_drive;

    private final PIDController pidController;

    public SnapToAprilTagCommand(DriveSubsystem drive) {
    
        m_drive = drive;

        this.pidController = new PIDController(0.01, 0.0, 0.001);

        pidController.enableContinuousInput(-180, 180);

        pidController.setTolerance(2.0);

        addRequirements(drive);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        double tx = 90 - LimelightHelpers.getTX("limelight");

        double rotationalSpeed = pidController.calculate(tx, 0);
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