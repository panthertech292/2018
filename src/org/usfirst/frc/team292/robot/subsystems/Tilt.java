package org.usfirst.frc.team292.robot.subsystems;


import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.TiltUp;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Tilt extends Subsystem {
	public DoubleSolenoid tiltSolenoid;
	
	public Tilt(){
		tiltSolenoid = new DoubleSolenoid(RobotMap.tiltOpen, RobotMap.tiltClose);
		
	}

    public void initDefaultCommand() {
        setDefaultCommand(new TiltUp());;

    }
}

