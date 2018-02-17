package org.usfirst.frc.team292.robot.commands.lift;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class FloorLift extends InstantCommand {

    public FloorLift() {
        super();
        requires(Robot.lift);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.lift.setSetpoint(0);
    }

}
