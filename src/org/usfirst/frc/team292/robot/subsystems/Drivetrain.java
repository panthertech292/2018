package org.usfirst.frc.team292.robot.subsystems;


import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.drive.DriveStop;

import com.ctre.phoenix.motorcontrol.ControlMode;
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
	final static double defaultP = 2.0;
	final static double defaultI = 0.0006;
	final static double defaultD = -.025;
	final static double deadband = .1;
	
	private WPI_TalonSRX frontRightMotor;
	private WPI_TalonSRX frontLeftMotor;
	private WPI_TalonSRX rearRightMotor;
	private WPI_TalonSRX rearLeftMotor;
	
	private double startDistance;
	
	public Drivetrain() {
		frontRightMotor = new WPI_TalonSRX(RobotMap.frontRightMotor);
		rearRightMotor = new WPI_TalonSRX(RobotMap.rearRightMotor);
		
		frontLeftMotor = new WPI_TalonSRX(RobotMap.frontLeftMotor);		
		rearLeftMotor = new WPI_TalonSRX(RobotMap.rearLeftMotor);
		rearRightMotor.setInverted(true);
		frontRightMotor.setInverted(true);
		frontRightMotor.follow(rearRightMotor);
		frontLeftMotor.follow(rearLeftMotor);
		
		//Only two motors will have encoders
		rearRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rearLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rearRightMotor.setSensorPhase(false);
		rearLeftMotor.setSensorPhase(true);
		
		SmartDashboard.putNumber("Drive P", defaultP);
    	SmartDashboard.putNumber("Drive I", defaultI);
    	SmartDashboard.putNumber("Drive D", defaultD);
    	
    	startDistance = getRawDistance();
	}
	
	public void driveDistance(double distance){
		rearRightMotor.config_kP(0, SmartDashboard.getNumber("Drive P", defaultP), 0);
    	rearRightMotor.config_kI(0, SmartDashboard.getNumber("Drive I", defaultI), 0);
    	rearRightMotor.config_kD(0, SmartDashboard.getNumber("Drive D", defaultD), 0);
    	rearLeftMotor.config_kP(0, SmartDashboard.getNumber("Drive P", defaultP), 0);
    	rearLeftMotor.config_kI(0, SmartDashboard.getNumber("Drive I", defaultI), 0);
    	rearLeftMotor.config_kD(0, SmartDashboard.getNumber("Drive D", defaultD), 0);
    	rearRightMotor.follow(rearLeftMotor);
		rearRightMotor.set(ControlMode.Position, distance * ticksPerInch);
		rearLeftMotor.set(ControlMode.Position, distance * ticksPerInch);
	}
	
	public void resetDistance() {
    	startDistance = getRawDistance();
	}

	private double getRawDistance() {
		SmartDashboard.putNumber("Left Ticks", rearLeftMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right Ticks", rearRightMotor.getSelectedSensorPosition(0));
		double total = 0;
		total += Math.abs(rearLeftMotor.getSelectedSensorPosition(0) / ticksPerInch);
		total += Math.abs(rearRightMotor.getSelectedSensorPosition(0) / ticksPerInch);
		return total / 2.0;
	}
	
	public double getDistance() {
		return (getRawDistance() - startDistance);
	}
	
	protected double applyDeadband(double value, double deadband) {
		if (Math.abs(value) > deadband) {
			if (value > 0.0) {
				return (value - deadband) / (1.0 - deadband);
			} else {
				return (value + deadband) / (1.0 - deadband);
			}
		} else {
			return 0.0;
		}
	}

	public void tankDrive(double leftPercentage, double rightPercentage){
		rearLeftMotor.set(ControlMode.PercentOutput, applyDeadband(leftPercentage, deadband));
		rearRightMotor.set(ControlMode.PercentOutput, applyDeadband(rightPercentage, deadband));
		
	}
	
    public void initDefaultCommand() {
    }
}

