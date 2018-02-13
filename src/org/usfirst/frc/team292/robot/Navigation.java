package org.usfirst.frc.team292.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Navigation  {

    private AHRS gyro;
    
    public Navigation() {
    	gyro = new AHRS(I2C.Port.kOnboard);
    	SmartDashboard.putNumber("Angle", gyro.getAngle());
    }
    
    public double getAngle() {
    	return gyro.getAngle();
    }
    
    public void reset() {
    	gyro.reset();
    }
}

