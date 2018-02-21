package org.usfirst.frc.team292.robot.commands.drive;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForward extends Command {
	private double targetDistance;
	private boolean initialized = false;

	public DriveForward(double distance) {
		requires(Robot.drivetrain);
		targetDistance = distance;
		Robot.drivetrain.resetDistance();
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putNumber("Target Distance", targetDistance);
		Robot.drivetrain.resetDistance();
		initialized = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.tankDrive(.40, .40);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return initialized && (Robot.drivetrain.getDistance() > targetDistance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
