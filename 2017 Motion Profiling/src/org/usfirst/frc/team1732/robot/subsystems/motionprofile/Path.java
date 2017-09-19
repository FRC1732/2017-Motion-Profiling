package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

import org.usfirst.frc.team1732.robot.subsystems.Drivetrain;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class Path {

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

	public static final Trajectory.Config basicConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC,
			Trajectory.Config.SAMPLES_HIGH, 0.01, Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_VELOCITY / 60),
			Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_ACCELERATION / 60),
			Drivetrain.revToInches(Drivetrain.MAX_ALLOWED_JERK / 60));

	private final Waypoint[] points;
	private final Trajectory.Config config;

	public final Trajectory leftTraj;
	public final Trajectory rightTraj;

	public Path(Waypoint[] points, Trajectory.Config config) {
		this.points = points;
		this.config = config;
		Trajectory traj = Pathfinder.generate(points, config);
		TankModifier tank = new TankModifier(traj);
		tank.modify(Drivetrain.inchesToRev(Drivetrain.ROBOT_WIDTH_INCHES));
		leftTraj = tank.getLeftTrajectory();
		rightTraj = tank.getRightTrajectory();
	}

}