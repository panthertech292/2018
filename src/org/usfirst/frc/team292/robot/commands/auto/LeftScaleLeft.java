package org.usfirst.frc.team292.robot.commands.auto;

import org.usfirst.frc.team292.robot.commands.drive.DriveForward;
import org.usfirst.frc.team292.robot.commands.grabber.Release;
import org.usfirst.frc.team292.robot.commands.grabber.TiltDown;
import org.usfirst.frc.team292.robot.commands.lift.LiftUp;
import org.usfirst.frc.team292.robot.commands.lift.ScaleLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScaleLeft extends CommandGroup {

    public LeftScaleLeft() {
    	addSequential(new TiltDown());
        addSequential(new DriveForward(324));
        addParallel(new ScaleLift());
        addSequential(new AutoTurn(90));
        addSequential(new DriveForward(30));
        addSequential(new Release());
    }
}
