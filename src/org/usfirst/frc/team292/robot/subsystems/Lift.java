package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.lift.LiftStop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	final static double ticksPerInch = 250 / (2.75 * Math.PI);

    private WPI_TalonSRX liftMotor;
    
    public Lift() {
    	liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);
    	liftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
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
    	liftMotor.set(ControlMode.Position, setpoint * ticksPerInch);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new LiftStop());
    }
}

