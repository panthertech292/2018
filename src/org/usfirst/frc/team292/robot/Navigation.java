package org.usfirst.frc.team292.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Navigation  {

    private AHRS gyro;
    private double startAngle;
    
    public Navigation() {
    	gyro = new AHRS(I2C.Port.kOnboard);
    	startAngle = getRawAngle();
    }
    
    private double getRawAngle() {
    	return gyro.getAngle();
    }
    
    public double getAngle() {
    	return getRawAngle() - startAngle;
    }
    
    public void reset() {
    	startAngle = getRawAngle();
    }
}

