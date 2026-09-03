package frc.robot.Commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Carpet;

public class Shoot extends Command {
    
    private Shooter s_Shoot;
    private Carpet s_Carpet;
    private Timer delay = new Timer();

    public Shoot(Shooter s_Shoot, Carpet s_Carpet) 
    {
        this.s_Shoot = s_Shoot;
        this.s_Carpet = s_Carpet;
        addRequirements(s_Shoot, s_Carpet);
    }

    @Override
    public void initialize() 
    {
        //Starts a timer to delay carpet until shooter revs up.
        delay.start();
    }

    @Override
    public void execute() 
    {
        //Starts the shooter and carpet motors.
        s_Shoot.setShooterSpeed();
        s_Shoot.setFeedSpeed();
        if (delay.get() > 0.5) 
            s_Carpet.setCarpetSpeed();
    }

    @Override
    public void end(boolean interrupted) {
        //Stops the shooter and carpet motors.
        s_Shoot.stop();
        s_Carpet.stop();
        delay.stop();
        delay.reset();
    } 
}