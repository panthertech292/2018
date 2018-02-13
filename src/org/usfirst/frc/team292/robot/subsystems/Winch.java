package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.winch.WinchStop;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
	private WPI_TalonSRX winchMotor1;
	private WPI_TalonSRX winchMotor2;
    private SpeedControllerGroup winchMotors;
    
    public Winch(){
    	winchMotor1 = new WPI_TalonSRX(RobotMap.winchMotor1);
    	winchMotor2 = new WPI_TalonSRX(RobotMap.winchMotor2);
    	winchMotors = new SpeedControllerGroup(winchMotor1, winchMotor2);
    }
    
    public void setSpeed(double percentage){
    	winchMotors.set(percentage);
    }
    


    public void initDefaultCommand() {
        setDefaultCommand(new WinchStop());
    }
}

