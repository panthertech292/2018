/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team292.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int frontRightMotor = 2;
	public static int frontLeftMotor = 0;
	public static int rearRightMotor = 3;
	public static int rearLeftMotor = 1;
	public static int liftMotor = 5;
	public static int controller = 0;
	public static int grabberOpen = 0;
	public static int grabberClose = 1;
	public static int tiltOpen = 2;
	public static int tiltClose = 3;
}
