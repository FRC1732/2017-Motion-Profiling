package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

// i just wanted this for testing temporarily, this is probably a bad way to organize the paths

public class MotionPaths {

	/*
	 * X+ is forward from where your robot starts.
	 * 
	 * X- is backward from where your robot starts.
	 * 
	 * Y- is to the right of your robot where it starts.
	 * 
	 * Y+ is to the left of your robot where it starts.
	 * 
	 * Positive headings are going from X+ towards Y+, Negative Headings from X+ to
	 * Y-. As for the actual following of the heading, that depends on where your
	 * gyroscope is zero'd to.
	 */

	// PATH1(new Waypoint[] { new Waypoint(-4, -1, Pathfinder.d2r(-45)), new
	// Waypoint(-2, -2, 0), new Waypoint(0, 0, 0) },
	// Path.basicConfig),

	// this is like this (uses addWaypoint and create instead of passing it to
	// constructor all at once) because in the future I think we won't want to
	// define all
	// our paths at once - instead only create the ones that are necessary

	public static final Path STRAIGHT = new Path(ProfileConfigs.BASIC);
	static {
		STRAIGHT.addWaypoint(0, 0, 0);
		STRAIGHT.addWaypoint(30, 0, 0);
		STRAIGHT.create();
	}

	public static final Path STRAIGHTFAR = new Path(ProfileConfigs.BASIC);
	static {
		STRAIGHTFAR.addWaypoint(0, 0, 0);
		STRAIGHTFAR.addWaypoint(80, 0, 0);
		STRAIGHTFAR.create();
	}

	public static final Path ARC = new Path(ProfileConfigs.BASIC);
	static {
		ARC.addWaypoint(0, 0, 0);
		ARC.addWaypoint(25, 6.699, Math.PI / 6);
		ARC.addWaypoint(35.355, 14.645, Math.PI / 4);
		ARC.addWaypoint(43.301, 25, Math.PI / 3);
		ARC.addWaypoint(50, 50, Math.PI / 2);
		ARC.create();
	}

	public static final Path CURVEY = new Path(ProfileConfigs.SLOW);
	static {
		CURVEY.addWaypoint(0, 0, 0);
		CURVEY.addWaypoint(40, 20, Math.PI / 4);
		CURVEY.addWaypoint(80, 20, -Math.PI / 4);
		CURVEY.create();
	}

	public static final Path YOU = new Path(ProfileConfigs.BASIC);
	static {
		YOU.addWaypoint(0, 0, 0);
		YOU.addWaypoint(40, 40, Math.PI / 2);
		YOU.addWaypoint(0, 80, -Math.PI);
		YOU.create();
	}

	// "invalid trajectory"
	// public static final Path TURN = new Path(ProfileConfigs.SLOW);
	// static {
	// TURN.addWaypoint(0, 0, 0);
	// TURN.addWaypoint(0, 0, -Math.PI);
	// TURN.create();
	// }

}