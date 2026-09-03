package frc.robot.Subsystems;

import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Util.Constants.Constants_Shooter;
import frc.robot.Util.RobotMap;

public class Shooter extends SubsystemBase {
    private SparkFlex rollMotor;
    private SparkFlex feedMotor;
    private RelativeEncoder rollEncoder;
    private double currentSpeed = Constants_Shooter.rollSpeed;

    public Shooter() {
       //Roll Config
       SparkFlexConfig rollConfig = new SparkFlexConfig();
       rollConfig.idleMode(IdleMode.kBrake);
       rollConfig.inverted(Constants_Shooter.shootInverted);
       rollConfig.smartCurrentLimit(40);

       //Roll PID
       rollConfig.closedLoop.p(Constants_Shooter.P_SHOOT);
       rollConfig.closedLoop.i(Constants_Shooter.I_SHOOT);
       rollConfig.closedLoop.d(Constants_Shooter.D_SHOOT);

       //Roll Motor
       rollMotor = new SparkFlex(RobotMap.MAP_SUBSYSTEMS.rollMotor, SparkFlex.MotorType.kBrushless);
       rollMotor.configure(rollConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
       rollEncoder = rollMotor.getEncoder();

       //Feed Config
       SparkFlexConfig feedConfig = new SparkFlexConfig();
       feedConfig.idleMode(IdleMode.kBrake);
       feedConfig.inverted(Constants_Shooter.feedInverted);
       feedConfig.smartCurrentLimit(40);

       //Feed Motor
       feedMotor = new SparkFlex(RobotMap.MAP_SUBSYSTEMS.feedMotor, SparkFlex.MotorType.kBrushless);
       feedMotor.configure(feedConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void stop() {
        rollMotor.stopMotor();
        feedMotor.stopMotor();
    }

    public void setShooterSpeed() {
        rollMotor.set(currentSpeed);
    }

    public void increaseSpeed(double delta) {
        currentSpeed += delta;
    }
    
    public void decreaseSpeed(double delta) {
        currentSpeed -= delta;
    }

    public void setFeedSpeed() {
        feedMotor.set(Constants_Shooter.feedSpeed);
    }

    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("RPM Velocity", rollEncoder.getVelocity());
    }
}
