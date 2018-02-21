package org.usfirst.frc.team292.robot.commands.lift;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LiftSustain extends InstantCommand {

    public LiftSustain() {
        super();
        requires(Robot.lift);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.lift.setSpeed(0.05);
    }

}
