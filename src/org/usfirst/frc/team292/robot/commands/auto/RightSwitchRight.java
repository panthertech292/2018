package org.usfirst.frc.team292.robot.commands.auto;

import org.usfirst.frc.team292.robot.commands.drive.DriveForward;
import org.usfirst.frc.team292.robot.commands.grabber.Release;
import org.usfirst.frc.team292.robot.commands.grabber.TiltDown;
import org.usfirst.frc.team292.robot.commands.lift.LiftUp;
import org.usfirst.frc.team292.robot.commands.lift.SwitchLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchRight extends CommandGroup {

    public RightSwitchRight() {
    	addSequential(new TiltDown());
    	addParallel(new SwitchLift());
        addSequential(new DriveForward(168));
        addSequential(new AutoTurn(-90));
        addSequential(new DriveForward(35));
        addSequential(new Release());
    }
}
