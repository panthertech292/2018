/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team292.robot;


import org.usfirst.frc.team292.robot.commands.auto.Score;
import org.usfirst.frc.team292.robot.commands.grabber.Grab;
import org.usfirst.frc.team292.robot.commands.grabber.Release;
import org.usfirst.frc.team292.robot.commands.grabber.TiltDown;
import org.usfirst.frc.team292.robot.commands.grabber.TiltUp;
import org.usfirst.frc.team292.robot.commands.winch.WinchDown;
import org.usfirst.frc.team292.robot.commands.winch.WinchUp;
import org.usfirst.frc.team292.robot.triggers.XboxTrigger;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public XboxController driveController;
	public XboxController operController;
	
	private SendableChooser<Command> autonomousChooser = new SendableChooser<>();
	private SendableChooser<String> positionChooser = new SendableChooser<>();
	
	
	
	public OI() {
		SmartDashboard.putData("Auto mode", auto());
		driveController = new XboxController(RobotMap.driveController);
		operController = new XboxController(RobotMap.operController);
		
		
		JoystickButton button3 = new JoystickButton(operController, 3);
		button3.whileHeld(new WinchUp());
		
		JoystickButton button4 = new JoystickButton(operController, 4);
		button4.whileHeld(new WinchDown());
		
		JoystickButton button5 = new JoystickButton(operController, 5);
		button5.whileHeld(new TiltDown());
		
		JoystickButton button6 = new JoystickButton(operController, 6);
		button6.whileHeld(new TiltUp());
		
		XboxTrigger leftTrigger = new XboxTrigger(operController, Hand.kLeft);
		leftTrigger.whileHeld(new Release());
		
		XboxTrigger rightTrigger = new XboxTrigger(operController, Hand.kRight);
		rightTrigger.whileHeld(new Grab());
		
		autonomousChooser.addDefault("Score", new Score());
		
		positionChooser.addObject("Left", "Left");
		positionChooser.addObject("Middle", "Middle");
		positionChooser.addObject("Right", "Right");
		
	}
	public String position() {
		return positionChooser.getSelected();
	}
	
	public Command auto(){
		return autonomousChooser.getSelected();
	}
		
}

