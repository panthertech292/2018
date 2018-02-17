package org.usfirst.frc.team292.robot.subsystems;


import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.grabber.TiltUp;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Tilt extends Subsystem {
	private DoubleSolenoid tiltSolenoid;
	
	public Tilt(){
		tiltSolenoid = new DoubleSolenoid(RobotMap.tiltOpen, RobotMap.tiltClose);
		
	}
	
	public void up(){
		tiltSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void down(){
		tiltSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

    public void initDefaultCommand() {

    }
}

