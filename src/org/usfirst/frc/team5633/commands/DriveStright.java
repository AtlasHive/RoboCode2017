package org.usfirst.frc.team5633.commands;

import org.usfirst.frc.team5633.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStright extends Command {
    protected double mSpeed = 0.5; // Scaled Motor Speed
    protected double mTime = 5.0; // Seconds

    public DriveStright(double speed, double time) {
	// Use requires() here to declare subsystem dependencies
	requires(Robot.driveTrain);
	mSpeed = speed;
	mTime = time;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	    // If is has been less than 'mTime' seconds since autonomous started, drive forwards
	    if(Robot.mAutoTimer.get() < mTime){
	        Robot.robotDrive.drive(mSpeed, 0.0);
	    }

	    // If more than 'mTime' seconds have elapsed, stop driving and turn off the timer
	    else {
	        Robot.robotDrive.stopMotor();
	        Robot.mAutoTimer.stop();
	    }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
