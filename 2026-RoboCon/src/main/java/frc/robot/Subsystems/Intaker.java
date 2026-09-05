package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Util.RobotMap;
import frc.robot.Util.Constants.Constants_Intake;

public class Intaker extends SubsystemBase {    
    TalonFX intakeMotor;
    TalonFXConfiguration intakeConfig;
    DutyCycleOut shootPower;
    public Intaker() {
        //Intake set up. What the hell even is a Talon.
        intakeMotor = new TalonFX(RobotMap.MAP_SUBSYSTEMS.intakeMotor, "rio");
        intakeConfig = new TalonFXConfiguration();

        //Config. So much worse than spark max :c
        intakeConfig.MotorOutput.Inverted = Constants_Intake.intakeInverted;
        intakeMotor.getConfigurator().apply(intakeConfig);

        shootPower = new DutyCycleOut(0);
        
    }
    
    //Should pick up balls.
    public void intakeBalls() {
        intakeMotor.setControl(shootPower.withOutput(Constants_Intake.intakeSpeed));
    }
}
