package org.usfirst.frc.team5633.subsystems;

import org.usfirst.frc.team5633.OI;
import org.usfirst.frc.team5633.RobotMap;
import org.usfirst.frc.team5633.commands.Climber;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new Climber());
    }
    
    /** Joystick Input **/
    public void jinput(Joystick stick)
    {
	if (stick.getRawButton(RobotMap.ClimbUp_BUTTON)) {
	    RobotMap.climberController.set(1.0);
//	    SmartDashboard.putString("Climb", "Up");
	} else if (stick.getRawButton(RobotMap.ClimbDown_BUTTON)) {
	    RobotMap.climberController.set(-1.0);
//	    SmartDashboard.putString("Climb", "Down");
	} else {
	    RobotMap.climberController.stopMotor();
	}
    }
}

