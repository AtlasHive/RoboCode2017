package org.usfirst.frc.team5633.subsystems;

import org.usfirst.frc.team5633.RobotMap;
import org.usfirst.frc.team5633.commands.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private boolean running = false;

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	// setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new Shooter());
    }

    /** Joystick Input **/
    public boolean jinput(Joystick stick) {
	if (stick.getRawButton(RobotMap.StartShoot_BUTTON)) {
	    this.setRunning(true);
	}

	if (stick.getRawButton(RobotMap.StopShoot_BUTTON)) {
	    this.setRunning(false);
	}

	setShooter(this.isRunning());

	return this.isRunning();
    }

    private void setShooter(boolean isGo) {
	if (isGo) {
	    RobotMap.shooterController.set(1.0d);
	} else {
	    RobotMap.shooterController.stopMotor();
	}
    }

    public boolean isRunning() {
	return running;
    }

    public void setRunning(boolean running) {
	this.running = running;
    }
}
