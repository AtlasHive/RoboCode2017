package org.usfirst.frc.team5633.commands;

import org.usfirst.frc.team5633.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Hopper extends Command {

    protected boolean complete = false;

    public Hopper() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	RobotMap.hopperController.set(1.0);
	SmartDashboard.putBoolean("Hopper", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return complete;
    }

    // Called once after isFinished returns true
    @SuppressWarnings("static-access")
    protected void end() {
	RobotMap.hopperController.stopMotor();
	this.SmartDashDefault();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	complete = true;
    }
    
    public static void SmartDashDefault() {
	SmartDashboard.putBoolean("Hopper", false);
    }
}
