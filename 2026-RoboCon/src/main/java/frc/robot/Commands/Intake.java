package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Carpet;
import frc.robot.Subsystems.Intaker;

public class Intake extends Command {
    private Intaker s_Intake;
    private Carpet s_Carpet;
    public Intake(Intaker s_Intake, Carpet s_Carpet) {
        this.s_Intake = s_Intake;
        this.s_Carpet = s_Carpet;
        addRequirements(s_Intake, s_Carpet);
    }

    @Override
    public void initialize() {
        //Starts the intake and carpet motors.
        s_Intake.intakeBalls();
        s_Carpet.setCarpetSpeed();

    }

    @Override
    public void end(boolean interrupted) {
        //Stops the intake and carpet motors.
        s_Intake.intakeBalls();
        s_Carpet.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
