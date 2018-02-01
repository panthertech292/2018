package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.Release;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

    public DoubleSolenoid grabberSolenoid;
    
    public Grabber(){
    	grabberSolenoid = new DoubleSolenoid(RobotMap.grabberOpen, RobotMap.grabberClose);
    }

    public void initDefaultCommand() {   
    	setDefaultCommand(new Release());
    }
}

