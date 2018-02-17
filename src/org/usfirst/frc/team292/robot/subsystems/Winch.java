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
	private WPI_TalonSRX winchMotor;
    
    public Winch(){
    	winchMotor = new WPI_TalonSRX(RobotMap.winchMotor);

    }
    
    public void setSpeed(double percentage){
    	winchMotor.set(percentage);
    }
    


    public void initDefaultCommand() {
        setDefaultCommand(new WinchStop());
    }
}

