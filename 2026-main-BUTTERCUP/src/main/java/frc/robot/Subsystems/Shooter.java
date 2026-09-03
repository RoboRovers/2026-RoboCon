package frc.robot.Subsystems;
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;
import com.revrobotics.spark.SparkFlex;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Util.Constants.Constants_Shooter;
import frc.robot.Util.RobotMap;


public class Shooter extends SubsystemBase {
    // Creating Motor
    private SparkFlex shootMotor;
    private SparkFlex feedMotor;
  
    
    //Default Constructor
    public Shooter() {
       // Shoot Config
       SparkFlexConfig shooterConfig = new SparkFlexConfig();
       shooterConfig.idleMode(IdleMode.kBrake);
       shooterConfig.inverted(Constants_Shooter.shootInverted);
       shooterConfig.smartCurrentLimit(40);

       // Shoot Motor
       shootMotor = new SparkFlex(RobotMap.MAP_SUBSYSTEMS.shootMotor, SparkFlex.MotorType.kBrushless);
       shootMotor.configure(shooterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

       // Feed Config
       SparkFlexConfig feedConfig = new SparkFlexConfig();
       feedConfig.idleMode(IdleMode.kBrake);
       feedConfig.inverted(Constants_Shooter.feedInverted);
       feedConfig.smartCurrentLimit(40);

       // Feed Motor
       feedMotor = new SparkFlex(RobotMap.MAP_SUBSYSTEMS.carpetMotor, SparkFlex.MotorType.kBrushless);
       feedMotor.configure(feedConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }


    //Fail safe just in case.
    public void stop() {
        shootMotor.stopMotor();
        feedMotor.stopMotor();
    }
    //Shoots balls.
    public void setShooterSpeed() {
        shootMotor.set(Constants_Shooter.defaultShootSpeed);
    }

    public void setFeedSpeed() {
        feedMotor.set(Constants_Shooter.defaultShootSpeed);
    }

    public void win() {
        boolean robotWin = true;
    }
}
