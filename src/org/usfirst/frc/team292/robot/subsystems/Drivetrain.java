package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.Robot;
import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.DriveStop;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem implements DrivetrainBase {
	final static double ticksPerInch = 217.3;
	static double total = 0;
	
	public DifferentialDrive tankDrive;
	public WPI_TalonSRX frontRightMotor;
	public WPI_TalonSRX frontLeftMotor;
	public WPI_TalonSRX rearRightMotor;
	public WPI_TalonSRX rearLeftMotor;
	public SpeedControllerGroup rightMotors;
	public SpeedControllerGroup leftMotors;
	
	public Drivetrain() {
		frontRightMotor = new WPI_TalonSRX(RobotMap.frontRightMotor);
		//rearRightMotor = new WPI_TalonSRX(RobotMap.rearRightMotor);
		rightMotors = new SpeedControllerGroup(frontRightMotor);
		
		frontLeftMotor = new WPI_TalonSRX(RobotMap.frontLeftMotor);		
		//rearLeftMotor = new WPI_TalonSRX(RobotMap.rearLeftMotor);
		leftMotors = new SpeedControllerGroup(frontLeftMotor);
		
		tankDrive = new DifferentialDrive(leftMotors, rightMotors);	
		frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rearRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rearLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		tankDrive.setDeadband(0.1);
	}
	
	public void resetDistance() {
    	Robot.drivetrain.frontLeftMotor.setSelectedSensorPosition(0, 0, 0);
    	Robot.drivetrain.frontRightMotor.setSelectedSensorPosition(0, 0, 0);
    	Robot.drivetrain.rearLeftMotor.setSelectedSensorPosition(0, 0, 0);
    	Robot.drivetrain.rearRightMotor.setSelectedSensorPosition(0, 0, 0);
	}

	public double getDistance() {
		total += Robot.drivetrain.frontLeftMotor.getSelectedSensorPosition(0) / ticksPerInch;
		total += Robot.drivetrain.frontRightMotor.getSelectedSensorPosition(0) / ticksPerInch;
		total += Robot.drivetrain.rearLeftMotor.getSelectedSensorPosition(0) / ticksPerInch;
		total += Robot.drivetrain.rearRightMotor.getSelectedSensorPosition(0) / ticksPerInch;
		return total / 4.0;
	}
    public void initDefaultCommand() {
        setDefaultCommand(new DriveStop());
    }
}

