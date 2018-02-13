package org.usfirst.frc.team292.robot.commands.auto;

import org.usfirst.frc.team292.robot.commands.drive.DriveForward;
import org.usfirst.frc.team292.robot.commands.grabber.Release;
import org.usfirst.frc.team292.robot.commands.grabber.TiltDown;
import org.usfirst.frc.team292.robot.commands.lift.LiftUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleSwitchLeft extends CommandGroup {

    public MiddleSwitchLeft() {
    	addSequential(new TiltDown());
    	addParallel(new LiftUp());
    	addSequential(new DriveForward(90));
    	addSequential(new AutoTurn(-90));
    	addSequential(new DriveForward(50));
    	addSequential(new AutoTurn(90));
    	addSequential(new DriveForward(45));
    	addSequential(new Release());
       
    }
}
