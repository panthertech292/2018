/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team292.robot;

import org.usfirst.frc.team292.robot.commands.*;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public XboxController xboxController;
	
	public OI() {
		xboxController = new XboxController(RobotMap.controller);
		
		JoystickButton button1 = new JoystickButton(xboxController, 1);
		button1.whileHeld(new TiltDown());
		
		JoystickButton button2 = new JoystickButton(xboxController, 2);
		button2.whileHeld(new Grab());
	}
}
