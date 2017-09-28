package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

import java.util.ArrayList;
import java.util.Arrays;

import org.usfirst.frc.team1732.robot.subsystems.Drivetrain;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class Path {

	private final ArrayList<Waypoint> points;
	private final Trajectory.Config config;

	private Trajectory leftTraj;
	private Trajectory rightTraj;

	public Path(Trajectory.Config config) {
		this.config = config;
		this.points = new ArrayList<Waypoint>();
	}

	public Path(Trajectory.Config config, Waypoint[] w) {
		this(config);
		points.addAll(Arrays.asList(w));
	}

	public Trajectory getLeft() {
		return leftTraj;
	}

	public Trajectory getRight() {
		return rightTraj;
	}

	public void addWaypoint(double x, double y, double heading) {
		points.add(new Waypoint(x, y, heading));
	}

	public void addWaypoint(Waypoint w) {
		points.add(w);
	}

	public void addWaypoints(Waypoint[] w) {
		points.addAll(Arrays.asList(w));
	}

	void create() {
		System.out.println("Making Path");
		long start = System.currentTimeMillis();

		Trajectory traj = Pathfinder.generate(points.toArray(new Waypoint[] {}), config);
		TankModifier tank = new TankModifier(traj);
		tank.modify(Drivetrain.ROBOT_WIDTH_INCHES);

		leftTraj = tank.getLeftTrajectory();
		rightTraj = tank.getRightTrajectory();

		System.out.println("Time to make path: " + (System.currentTimeMillis() - start));
	}

}