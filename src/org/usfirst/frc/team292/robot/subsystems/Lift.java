package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.lift.LiftStop;

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
	final static double defaultP = 2.0;
	final static double defaultI = 0.001;
	final static double defaultD = 0.0;

    private WPI_TalonSRX liftMotor;
    
    public Lift() {
    	liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);
    	liftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	liftMotor.configPeakOutputReverse(-.25, 0);
    	liftMotor.setInverted(false);
    	liftMotor.setSensorPhase(false);
    	liftMotor.setSelectedSensorPosition(0, 0, 0);
    	SmartDashboard.putNumber("Lift P", defaultP);
    	SmartDashboard.putNumber("Lift I", defaultI);
    	SmartDashboard.putNumber("Lift D", defaultD);
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
    
    public void setSetpoint(double setpoint) {
    	liftMotor.config_kP(0, SmartDashboard.getNumber("Lift P", defaultP), 0);
    	liftMotor.config_kI(0, SmartDashboard.getNumber("Lift I", defaultI), 0);
    	liftMotor.config_kD(0, SmartDashboard.getNumber("Lift D", defaultD), 0);
    	liftMotor.set(ControlMode.Position, setpoint * ticksPerInch);
    }

    public void initDefaultCommand() {
    }
}

