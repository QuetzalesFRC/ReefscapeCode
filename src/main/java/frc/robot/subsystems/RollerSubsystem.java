package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ArmIntakeModule;
import frc.robot.Constants.RollerConstants;

/*
 * 
 * Los rollers no usan encoders
 * 
 */

public class RollerSubsystem extends SubsystemBase {
    //Declarar los motores
    private final SparkMax m_rollerSpark;
    /**
     * Este subsistema controla las ruedas del intake 
     */
    public RollerSubsystem () {

    // Declarar el motor como un brushless
    m_rollerSpark = new SparkMax(RollerConstants.kArmRollerCanId, MotorType.kBrushless);

    m_rollerSpark.setCANTimeout(250);

    // Configurar el motor, esto usa los valores de configs.java
    m_rollerSpark.configure(ArmIntakeModule.armRollerConfig, ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }

    /** 
     * Metodo para hacer girar los rollers a una velocidad determinada
     * 
     * @param speed velocidad del motor de -1 a 1, 0 lo detiene
     */
    public void runRollers(double speed){
        m_rollerSpark.set(speed);
    }

}