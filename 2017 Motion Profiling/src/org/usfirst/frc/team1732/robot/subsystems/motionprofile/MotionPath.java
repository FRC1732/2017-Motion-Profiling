package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

// i just wanted this for testing temporarily, this is probably a bad way to organize the paths

public enum MotionPath {

	/*
	 * X+ is forward from where your robot starts.
	 * 
	 * X- is backward from where your robot starts.
	 * 
	 * Y+ is to the right of your robot where it starts.
	 * 
	 * Y- is to the left of your robot where it starts.
	 * 
	 * Positive headings are going from X+ towards Y+, Negative Headings from X+ to
	 * Y-. As for the actual following of the heading, that depends on where your
	 * gyroscope is zero'd to.
	 */

	// PATH1(new Waypoint[] { new Waypoint(-4, -1, Pathfinder.d2r(-45)), new
	// Waypoint(-2, -2, 0), new Waypoint(0, 0, 0) },
	// Path.basicConfig),
	STRAIGHT(new Waypoint[] { new Waypoint(0, 0, 0), new Waypoint(30, 0, 0) }, Path.basicConfig),
	STRAIGHTFAR(new Waypoint[] { new Waypoint(0, 0, 0), new Waypoint(80, 0, 0) }, Path.basicConfig),
	ARC(new Waypoint[] { new Waypoint(0, 0, 0), new Waypoint(5, 21.794, (Math.PI / 2 - 0.771)),
			new Waypoint(14.644, 35.355, Math.PI / 4), new Waypoint(45, 49.749, Math.PI / 2 - 0.100),
			new Waypoint(50, 50, Math.PI / 2), }, Path.basicConfig);

	public final Trajectory leftTraj;
	public final Trajectory rightTraj;

	private MotionPath(Waypoint[] points, Trajectory.Config config) {
		Path path = new Path(points, config);
		leftTraj = path.leftTraj;
		rightTraj = path.rightTraj;
	}
}