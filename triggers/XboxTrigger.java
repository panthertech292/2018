package org.usfirst.frc.team292.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 */
public class XboxTrigger extends Button {
private final XboxController controller;
private final Hand hand;
	public XboxTrigger(XboxController controller, Hand hand){
		this.controller = controller;
		this.hand = hand;
	}
    public boolean get() {
        return controller.getTriggerAxis(hand) > 0.25;
    }
}
