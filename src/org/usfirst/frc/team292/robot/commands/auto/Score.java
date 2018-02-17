package org.usfirst.frc.team292.robot.commands.auto;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Score extends CommandGroup {
	private DriverStation ds;
	private boolean switchPosition;
	private boolean scalePosition;

	public Score() {
		ds = DriverStation.getInstance();

		if (ds.getGameSpecificMessage().length() > 0) {
			switchPosition = ds.getGameSpecificMessage().charAt(0) == 'L';
			scalePosition = ds.getGameSpecificMessage().charAt(0) == 'L';
		}

		switch (Robot.oi.position()) {

		case "Left":
			if (switchPosition) {
				addSequential(new LeftSwitchLeft());
			} else if (scalePosition) {
				addSequential(new LeftScaleLeft());
			} else {
				// call the left side right scale auto code
			}
			break;
		case "Right":
			if (!switchPosition) {
				addSequential(new RightSwitchRight());
			} else if (!scalePosition) {
				addSequential(new RightScaleRight());
			} else {
				// call the right side left scale auto code
			}
			break;
		case "Middle":
			if (switchPosition) {
				addSequential(new MiddleSwitchLeft());
			} else {
				addSequential(new MiddleSwitchRight());
			}

			if (scalePosition) {
				// call the middle left scale auto code
			} else {
				// call the middle right scale auto code
			}
		}

	}
}
