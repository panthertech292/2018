package org.usfirst.frc.team292.robot.commands.lift;

import org.usfirst.frc.team292.robot.Robot;
import org.usfirst.frc.team292.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchLift extends Command {
	private boolean goDown = false;
    public SwitchLift() {
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.lift.getHeight() > Lift.switchHeight) {
    		goDown = true;
    	} else {
    		goDown = false;
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (goDown) {
    		Robot.lift.setSpeed(Lift.downSpeed);
    	} else {
    		Robot.lift.setSpeed(Lift.upSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (goDown) {
        	return Robot.lift.getHeight() <= Lift.switchHeight;
        } else {
        	return Robot.lift.getHeight() >= Lift.switchHeight;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.setSpeed(Lift.sustainSpeed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
