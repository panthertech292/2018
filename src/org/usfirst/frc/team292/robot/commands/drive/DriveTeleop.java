package org.usfirst.frc.team292.robot.commands.drive;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTeleop extends Command {

    public DriveTeleop() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.tankDrive(-Robot.oi.driveController.getY(Hand.kLeft), -Robot.oi.driveController.getY(Hand.kRight));
    	SmartDashboard.putNumber("Left Joystick", Robot.oi.driveController.getY(Hand.kLeft));
    	SmartDashboard.putNumber("Right Joystick", Robot.oi.driveController.getY(Hand.kRight));
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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