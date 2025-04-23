package frc.robot.subsystems;

//import edu.wpi.first.math.geometry.Rotation2d;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
//import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import frc.robot.Configs.ArmIntakeModule;
import frc.robot.Constants.ArmConstants;

/*
 * 
 * Se tiene que revisar el uso de encoders 
 * 
 */

public class ArmSubsystem extends SubsystemBase {

    //Declarar los motores / encoders
    private final SparkMax m_armSpark;
    //private final RelativeEncoder m_armEncoder;


    // Este valor es cuantos grados tiene de offset el arm con respecto a los 90 grados, 
    //por defecto a 0 ya que es desconocido, se usa con el encoder.
    //private double m_armAngularOffset = 0;

    
    /**
     * Este subsistema controla el brazo del intake 
     */
    public ArmSubsystem () {

    // Declarar el motor como un brushless y asignar su encoder
    m_armSpark = new SparkMax(ArmConstants.kArmPivotCanId, MotorType.kBrushless);
    //m_armEncoder = m_armSpark.getEncoder();

    m_armSpark.setCANTimeout(250);

    // Configurar el motor, esto usa los valores de configs.java
    m_armSpark.configure(ArmIntakeModule.armPivotConfig, ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }
    /** 
     * Metodo para mover el arm a una velocidad determinada,
     * cambiara de velocidad a radianes o grados 
     * 
     * @param speed velocidad del motor de -1 a 1, 0 lo detiene
     */
    public void setArmSpeed(double speed){
        m_armSpark.set(speed);
    }
}