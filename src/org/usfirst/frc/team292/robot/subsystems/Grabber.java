package org.usfirst.frc.team292.robot.subsystems;

import org.usfirst.frc.team292.robot.RobotMap;
import org.usfirst.frc.team292.robot.commands.grabber.Release;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

    private DoubleSolenoid grabberSolenoid;
    
    public Grabber(){
    	grabberSolenoid = new DoubleSolenoid(RobotMap.grabberOpen, RobotMap.grabberClose);
    }
    
    public void grab(){
    	grabberSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void release(){
    	grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand() {   
    }
}

