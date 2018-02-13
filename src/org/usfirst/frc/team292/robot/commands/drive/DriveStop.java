package org.usfirst.frc.team292.robot.commands.drive;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class DriveStop extends InstantCommand {

    public DriveStop() {
        super();
        requires(Robot.drivetrain);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.drivetrain.tankDrive(0, 0);
    }

}
