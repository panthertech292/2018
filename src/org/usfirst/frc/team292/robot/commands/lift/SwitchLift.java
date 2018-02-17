package org.usfirst.frc.team292.robot.commands.lift;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SwitchLift extends InstantCommand {

    public SwitchLift() {
        super();
        requires(Robot.lift);
    }

    protected void initialize() {
    	 Robot.lift.setSetpoint(18);
    }

}
