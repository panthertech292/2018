package org.usfirst.frc.team292.robot.commands;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchLeft extends CommandGroup {

    public LeftSwitchLeft() {
    	//placeholder values
        addSequential(new DriveForward(500));
        addSequential(new AutoTurn(90));
        addSequential(new DriveForward(50));
        addSequential(new PlaceCube());

    }
}
