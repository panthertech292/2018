package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.LiftStop;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

    public WPI_TalonSRX liftMotor;
    
    public Lift() {
    	liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new LiftStop());
    }
}

