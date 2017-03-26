package org.usfirst.frc.team5633;

import org.usfirst.frc.team5633.commands.Hopper;
import org.usfirst.frc.team5633.commands.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static Joystick jstick;

    /** Drive Buttons **/
    public static JoystickButton stopShooterButton, startShooterButton, hopperButton, climbUpButton, climbDownButton, sweeperInButton, sweeperOutButton;
   

    public OI() {
	jstick = new Joystick(RobotMap.joystickPort);

	hopperButton  = new JoystickButton(jstick, RobotMap.Hopper_BUTTON);
	hopperButton.whileHeld(new Hopper());
	
	
    }
}
