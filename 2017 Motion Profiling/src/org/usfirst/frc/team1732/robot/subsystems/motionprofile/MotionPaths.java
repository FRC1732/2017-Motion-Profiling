package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

import java.util.ArrayList;

import jaci.pathfinder.Waypoint;

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

	/*
	 * this is like this (uses addWaypoint and create instead of passing it to
	 * constructor all at once) because in the future I think we won't want to
	 * define all our paths at once - instead only create the ones that are
	 * necessary, and create them locally.
	 * 
	 */

	public static final Path STRAIGHT;
	static {
		ArrayList<Waypoint> points = new ArrayList<Waypoint>();
		points.add(new Waypoint(0, 0, 0));
		points.add(new Waypoint(30, 0, 0));
		STRAIGHT = new Path(ProfileConfigs.BASIC, points);
	}

	public static final Path STRAIGHTFAR;
	static {
		ArrayList<Waypoint> points = new ArrayList<Waypoint>();
		points.add(new Waypoint(0, 0, 0));
		points.add(new Waypoint(80, 0, 0));
		STRAIGHTFAR = new Path(ProfileConfigs.SLOW, points);
	}

	public static final Path ARC;
	static {
		ArrayList<Waypoint> points = new ArrayList<Waypoint>();
		points.add(new Waypoint(0, 0, 0));
		points.add(new Waypoint(25, 6.699, Math.PI / 6));
		points.add(new Waypoint(35.355, 14.645, Math.PI / 4));
		points.add(new Waypoint(43.301, 25, Math.PI / 3));
		points.add(new Waypoint(50, 50, Math.PI / 2));
		ARC = new Path(ProfileConfigs.BASIC, points);
	}

	public static final Path SIMPLE_ARC;
	static {
		ArrayList<Waypoint> points = new ArrayList<Waypoint>();
		points.add(new Waypoint(0, 0, 0));
		points.add(new Waypoint(50, 50, Math.PI / 2));
		SIMPLE_ARC = new Path(ProfileConfigs.BASIC, points);
	}

	public static final Path CURVEY;
	static {
		ArrayList<Waypoint> points = new ArrayList<Waypoint>();
		points.add(new Waypoint(0, 0, 0));
		points.add(new Waypoint(40, 20, Math.PI / 4));
		points.add(new Waypoint(80, 20, -Math.PI / 4));
		CURVEY = new Path(ProfileConfigs.SLOW, points);
	}

	public static final Path YOU;
	static {
		ArrayList<Waypoint> points = new ArrayList<Waypoint>();
		points.add(new Waypoint(0, 0, 0));
		points.add(new Waypoint(60, 40, Math.PI / 2));
		points.add(new Waypoint(0, 80, Math.PI));
		points.add(new Waypoint(-20, 80, Math.PI));
		YOU = new Path(ProfileConfigs.SLOW, points);
	}

	public static final Path YOU2;
	static {
		ArrayList<Waypoint> points = new ArrayList<Waypoint>();
		points.add(new Waypoint(0, 0, 0));
		points.add(new Waypoint(65, 40, Math.PI / 2));
		points.add(new Waypoint(15, 70, Math.PI + 0.401));
		YOU2 = new Path(ProfileConfigs.SLOW, points);
	}

	// "invalid trajectory"
	// public static final Path TURN = new Path(ProfileConfigs.SLOW);
	// static {
	// TURN.add(new Waypoint(0, 0, 0);
	// TURN.add(new Waypoint(0, 0, -Math.PI);
	// TURN.create();
	// }

}