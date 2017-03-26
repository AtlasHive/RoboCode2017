package org.usfirst.frc.team5633;

import org.usfirst.frc.team5633.commands.Climber;
import org.usfirst.frc.team5633.commands.DoNothing;
import org.usfirst.frc.team5633.commands.DriveStright;
import org.usfirst.frc.team5633.commands.Hopper;
import org.usfirst.frc.team5633.subsystems.ClimberSubsystem;
import org.usfirst.frc.team5633.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team5633.subsystems.ShooterSubsystem;
import org.usfirst.frc.team5633.subsystems.SweeperSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static OI oi;

    public static RobotDrive robotDrive;
    public static DriveTrainSubsystem driveTrain;
    public static Timer mAutoTimer;
    
    public static ClimberSubsystem climber;
    public static SweeperSubsystem sweeper;
    public static ShooterSubsystem shooter;

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
	RobotMap.climberController = new Spark(RobotMap.Climber_SPEEDCONTROLLER);
	RobotMap.hopperController = new Spark(RobotMap.Hopper_SPEEDCONTROLLER);
	RobotMap.driveLeftController = new Talon(RobotMap.Left_SPEEDCONTROLLER);
	RobotMap.driveRightController = new Talon(RobotMap.Right_SPEEDCONTROLLER);
	RobotMap.shooterController = new Talon(RobotMap.Shooter_SPEEDCONTROLLER);
	RobotMap.sweepController = new Talon(RobotMap.Sweep_SPEEDCONTROLLER);

	robotDrive = new RobotDrive(RobotMap.driveLeftController, RobotMap.driveRightController);
	driveTrain = new DriveTrainSubsystem(robotDrive);

	chooser.addDefault("Cross Line", new DriveStright(0.5, 5));
	chooser.addObject("Do Nothing", new DoNothing());
	
	/** Climber **/
	climber = new ClimberSubsystem();
	sweeper = new SweeperSubsystem();
	shooter = new ShooterSubsystem();
	
	mAutoTimer = new Timer();

	SmartDashboard.putData("Auto mode", chooser);

	CameraServer.getInstance().startAutomaticCapture("Back", 0);
	CameraServer.getInstance().startAutomaticCapture("Front", 1);

	Climber.SmartDashDefault();
	Hopper.SmartDashDefault();

	oi = new OI();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
	Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
	autonomousCommand = chooser.getSelected();

	// Reset timer to 0sec
	mAutoTimer.reset();

	// Start timer
	mAutoTimer.start();

	/*
	 * String autoSelected = SmartDashboard.getString("Auto Selector",
	 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
	 * = new MyAutoCommand(); break; case "Default Auto": default:
	 * autonomousCommand = new ExampleCommand(); break; }
	 */

	// schedule the autonomous command (example)
	if (autonomousCommand != null)
	    autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
	Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
	// This makes sure that the autonomous stops running when
	// teleop starts running. If you want the autonomous to
	// continue until interrupted by another command, remove
	// this line or comment it out.
	if (autonomousCommand != null)
	    autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
	Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
	LiveWindow.run();
    }
}
