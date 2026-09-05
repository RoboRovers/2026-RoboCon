package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;

public class ShootSlower extends Command {
    private Shooter s_Shoot;
    private double decrement = 0.05;

    public ShootSlower(Shooter shooter) {
        s_Shoot = shooter;
        addRequirements(s_Shoot);
    }

    @Override
    public void initialize() {
        // Decrease the speed of the shooter
        s_Shoot.decreaseSpeed(decrement);
    }   

    @Override
    public void end(boolean interrupted) {
        
    }
}
