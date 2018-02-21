package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.lift.LiftSustain;
import org.usfirst.frc.team292.robot.commands.lift.ManualLift;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Subsystem {
	final static double ticksPerInch = 1000 / (2.5 * Math.PI);
	final static double deadband = .1;
	public static final double upSpeed = .80;
	public static final double downSpeed = -.25;
	public static final double sustainSpeed = .1;
	public static final double switchHeight = 18;
	public static final double scaleHeight = 70;
	public static final double floorHeight = 0;

    private WPI_TalonSRX liftMotor;
    
    public Lift() {
    	liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);
    	liftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	liftMotor.configPeakOutputReverse(-.25, 0);
    	liftMotor.configPeakOutputForward(.75, 0);
    	liftMotor.setInverted(false);
    	liftMotor.setSensorPhase(false);
    	liftMotor.setSelectedSensorPosition(0, 0, 0);
    	liftMotor.configSetParameter(ParamEnum.eClearPositionOnLimitR, 1, 0, 0, 0);
    }

    public void resetHeight() {
    	liftMotor.setSelectedSensorPosition(0, 0, 0);
    }
    
    public double getHeight() {
    	double height;
    	height = liftMotor.getSelectedSensorPosition(0) / ticksPerInch;
    	return height;
    }
    
    public void setSpeed(double percentage){
    	liftMotor.set(percentage);
    }
    
    public void setManualSpeed(double value) {
    	double output;
		if (Math.abs(value) > deadband) {
			output = (Math.abs(value) - deadband) / (1.0 - deadband);
			if (value > 0.0) {
				output = sustainSpeed + (upSpeed - sustainSpeed) * output;
			} else {
				output = sustainSpeed + (downSpeed - sustainSpeed) * output;
			}
		} else {
			output = 0;
		}
    	liftMotor.set(output);    	
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new ManualLift());
    }
}

