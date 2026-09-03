package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Util.RobotMap;

public class Intake extends SubsystemBase {
    
    public Intake() {
        TalonFX intakeMotor = new TalonFX(RobotMap.MAP_SUBSYSTEMS.intakeMotor);
        
    }
}
