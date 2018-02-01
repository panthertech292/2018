package org.usfirst.frc.team292.robot.commands;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Release extends InstantCommand {

    public Release() {
        requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabber.grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

}
