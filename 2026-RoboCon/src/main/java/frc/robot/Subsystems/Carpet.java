package frc.robot.Subsystems;
import frc.robot.Util.RobotMap;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import frc.robot.Util.Constants.Constants_Carpet;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Carpet extends SubsystemBase {
    private SparkFlex carpetMotor;
  
    public Carpet() {
       // Config
       SparkFlexConfig carpetConfig = new SparkFlexConfig();
       carpetConfig.idleMode(IdleMode.kBrake);
       carpetConfig.inverted(Constants_Carpet.carpetInverted);
       carpetConfig.smartCurrentLimit(40);

       // Motor
       carpetMotor = new SparkFlex(RobotMap.MAP_SUBSYSTEMS.carpetMotor, SparkFlex.MotorType.kBrushless);
       carpetMotor.configure(carpetConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void stop() {
        carpetMotor.stopMotor();
    }

    public void setCarpetSpeed() {
        carpetMotor.set(Constants_Carpet.carpetSpeed);
    }

    public Command freeBalls() {
        return runOnce(() ->
        {
            carpetMotor.set(-Constants_Carpet.carpetSpeed);
        });
    }
}