package org.usfirst.frc.team292.robot.subsystems;


import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.drive.DriveStop;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
	final static double ticksPerInch = 4096 / (6 * Math.PI);
	
	
	private DifferentialDrive drive;
	private WPI_TalonSRX frontRightMotor;
	private WPI_TalonSRX frontLeftMotor;
	private WPI_TalonSRX rearRightMotor;
	private WPI_TalonSRX rearLeftMotor;
	private SpeedControllerGroup rightMotors;
	private SpeedControllerGroup leftMotors;
	
	public Drivetrain() {
		frontRightMotor = new WPI_TalonSRX(RobotMap.frontRightMotor);
		rearRightMotor = new WPI_TalonSRX(RobotMap.rearRightMotor);
		rightMotors = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
		
		frontLeftMotor = new WPI_TalonSRX(RobotMap.frontLeftMotor);		
		rearLeftMotor = new WPI_TalonSRX(RobotMap.rearLeftMotor);
		leftMotors = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
		drive = new DifferentialDrive(leftMotors, rightMotors);
		
		//Only two motors will have encoders
		rearRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rearLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rearRightMotor.setSensorPhase(false);
		rearLeftMotor.setSensorPhase(true);
		drive.setDeadband(0.1);
	}
	
	public void resetDistance() {
    	rearLeftMotor.setSelectedSensorPosition(0, 0, 0);
    	rearRightMotor.setSelectedSensorPosition(0, 0, 0);
	}

	public double getDistance() {
		SmartDashboard.putNumber("Left Ticks", rearLeftMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right Ticks", rearRightMotor.getSelectedSensorPosition(0));
		double total = 0;
		total += rearLeftMotor.getSelectedSensorPosition(0) / ticksPerInch;
		total += rearRightMotor.getSelectedSensorPosition(0) / ticksPerInch;
		return total / 2.0;
	}
	
	public void tankDrive(double leftPercentage, double rightPercentage){
		drive.tankDrive(leftPercentage, rightPercentage);
	}
    public void initDefaultCommand() {
        setDefaultCommand(new DriveStop());
    }
}

