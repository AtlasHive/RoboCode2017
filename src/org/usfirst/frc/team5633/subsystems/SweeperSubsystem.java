package org.usfirst.frc.team5633.subsystems;

import org.usfirst.frc.team5633.OI;
import org.usfirst.frc.team5633.RobotMap;
import org.usfirst.frc.team5633.commands.Sweeper;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SweeperSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	// setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new Sweeper());
    }

    /** Joystick Input **/
    public void jinput(Joystick stick) {
//	DriverStation.reportWarning(String.format("%d", stick.getRawAxis(RobotMap.Sweepin_BUTTON)), false);
	if (stick.getRawButton(RobotMap.Sweepin_BUTTON)) {
	    RobotMap.sweepController.set(1.0);
	    // SmartDashboard.putString("Sweeper", "In");
	} else if (stick.getRawButton(RobotMap.Sweepout_BUTTON)) {
	    RobotMap.sweepController.set(-1.0);
//	    SmartDashboard.putString("Sweeper", "Out");
	} else {
	    RobotMap.sweepController.stopMotor();
	}
    }
}
