package org.usfirst.frc.team292.robot.commands;

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
    	Robot.drivetrain.tankDrive.tankDrive(-Robot.oi.xboxController.getY(Hand.kLeft), -Robot.oi.xboxController.getY(Hand.kRight));
    	SmartDashboard.putNumber("Left Joystick", Robot.oi.xboxController.getY(Hand.kLeft));
    	SmartDashboard.putNumber("Right Joystick", Robot.oi.xboxController.getY(Hand.kRight));
    	SmartDashboard.putNumber("Front Right", Robot.drivetrain.frontRightMotor.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Front Left", Robot.drivetrain.frontLeftMotor.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Rear Right", Robot.drivetrain.rearRightMotor.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Rear Left", Robot.drivetrain.rearLeftMotor.getSelectedSensorPosition(0));
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
