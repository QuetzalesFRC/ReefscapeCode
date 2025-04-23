package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ClimberModule;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase {
    //Declarar los motores
    private final SparkMax m_climberSpark;

    /**
     * Este subsistema controla el climber
     */
    public ClimberSubsystem () {

    // Declarar el motor como un brushless
     m_climberSpark = new SparkMax(ClimberConstants.kClimberCanId, MotorType.kBrushless);

    
    m_climberSpark.setCANTimeout(250);
    

    // Configurar el motor, esto usa los valores de configs.java
    m_climberSpark.configure(ClimberModule.ClimberConfig, ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }

    /** 
     * Metodo para hacer girar el motor del climber a una velocidad determinada,
     * 
     * @param speed velocidad del motor de -1 a 1, 0 lo detiene
     */

    public void setClimberSpeed(double speed){
         m_climberSpark.set(speed);
    }

}