package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

import org.usfirst.frc.team1732.robot.subsystems.Drivetrain;

import jaci.pathfinder.Trajectory;

public class ProfileConfigs {

	// Create the Trajectory Configuration
	//
	// Arguments:
	// Fit Method: HERMITE_CUBIC or HERMITE_QUINTIC
	// Sample Count: SAMPLES_HIGH (100 000)
	// SAMPLES_LOW (10 000)
	// SAMPLES_FAST (1 000)
	// Time Step: 0.01 Seconds
	// Max Velocity: 1.7 m/s
	// Max Acceleration: 2.0 m/s/s
	// Max Jerk: 60.0 m/s/s/s

	// divide by 60 because the velocity/acceleration/jerk start out in terms of
	// RPM, divide by 60 so that they become revolutions per second
	// then convert from revolutions to inches

	public static final double TIME_STEP = 0.01;

	public static final Trajectory.Config BASIC = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC,
			Trajectory.Config.SAMPLES_HIGH, TIME_STEP, Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_VELOCITY / 60 / 2),
			Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_ACCELERATION / 60 / 4),
			Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_JERK / 60));

	public static final Trajectory.Config SLOW = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC,
			Trajectory.Config.SAMPLES_HIGH, TIME_STEP, Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_VELOCITY / 60 / 5),
			Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_ACCELERATION / 60 / 5),
			Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_JERK / 60));

}