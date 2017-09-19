package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

import jaci.pathfinder.Pathfinder;
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
	 */

	PATH1(new Waypoint[] { new Waypoint(-4, -1, Pathfinder.d2r(-45)), new Waypoint(-2, -2, 0), new Waypoint(0, 0, 0) },
			Path.basicConfig),
	STRAIGHT(new Waypoint[] { new Waypoint(0, 0, 0), new Waypoint(30, 0, 0) }, Path.basicConfig),
	STRAIGHTFAR(new Waypoint[] { new Waypoint(0, 0, 0), new Waypoint(80, 0, 0) }, Path.basicConfig);

	public final Trajectory leftTraj;
	public final Trajectory rightTraj;

	private MotionPath(Waypoint[] points, Trajectory.Config config) {
		Path path = new Path(points, config);
		leftTraj = path.leftTraj;
		rightTraj = path.rightTraj;
	}
}