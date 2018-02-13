package org.usfirst.frc.team292.robot.commands.grabber;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Grab extends InstantCommand {

    public Grab() {
        requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabber.grab();
    }

}
