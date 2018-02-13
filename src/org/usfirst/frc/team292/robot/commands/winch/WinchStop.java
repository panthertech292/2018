package org.usfirst.frc.team292.robot.commands.winch;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class WinchStop extends InstantCommand {

    public WinchStop() {
        super();
        requires(Robot.winch);
    }

    protected void initialize() {
    	Robot.winch.setSpeed(0);
    }

}
