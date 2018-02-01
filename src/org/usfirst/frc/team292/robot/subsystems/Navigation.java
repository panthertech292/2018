package org.usfirst.frc.team292.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Navigation extends Subsystem {

    public AHRS gyro;
    
    public Navigation() {
    	gyro = new AHRS(I2C.Port.kOnboard);
    	SmartDashboard.putNumber("Angle", gyro.getAngle());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

