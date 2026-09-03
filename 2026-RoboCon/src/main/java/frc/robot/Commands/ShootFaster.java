package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;

public class ShootFaster extends Command {
    private Shooter s_Shoot;
    private double increment = 0.05;

    public ShootFaster(Shooter shooter) {
        s_Shoot = shooter;
        addRequirements(s_Shoot);
    }

    @Override
    public void initialize() {
        // Increase the speed of the shooter
        s_Shoot.increaseSpeed(increment);
    }   
}
