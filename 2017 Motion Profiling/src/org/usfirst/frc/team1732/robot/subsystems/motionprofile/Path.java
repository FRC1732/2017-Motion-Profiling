package org.usfirst.frc.team1732.robot.subsystems.motionprofile;

import java.util.ArrayList;

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
	private volatile boolean created = false;

	public Path(Trajectory.Config config, ArrayList<Waypoint> points) {
		this.config = config;
		this.points = points;
	}

	/**
	 * Return left traj.
	 * 
	 * @return return the left trajectory, null if create() hasn't been called.
	 */
	public Trajectory getLeft() {
		return leftTraj;
	}

	public Trajectory getRight() {
		return rightTraj;
	}

	public boolean isCreated() {
		return created;
	}

	// private static final String leftPath = "LeftPath";
	// private static final String rightPath = "RightPath";

	// if (save) {
	// File l = new File(leftPath);
	// File r = new File(rightPath);
	// Pathfinder.writeToFile(l, getLeft());
	// Pathfinder.writeToFile(r, getRight());
	// }

	// } else if (!created && read) {
	// System.out.println("Reading Path");
	// long start = System.currentTimeMillis();
	//
	// File l = new File(leftPath);
	// File r = new File(rightPath);
	// leftTraj = Pathfinder.readFromFile(l);
	// rightTraj = Pathfinder.readFromFile(r);
	// System.out.println("Time to read path: " + (System.currentTimeMillis() -
	// start));
	//
	// created = true;

	public void create() {
		if (!created) {// && !read) {
			System.out.println("Making Path");
			long start = System.currentTimeMillis();

			Trajectory traj = Pathfinder.generate(points.toArray(new Waypoint[] {}), config);
			TankModifier tank = new TankModifier(traj);
			tank.modify(Drivetrain.EFFECTIVE_ROBOT_WIDTH);

			leftTraj = tank.getLeftTrajectory();
			rightTraj = tank.getRightTrajectory();

			System.out.println("Time to make path: " + (System.currentTimeMillis() - start));
			created = true;

			return;
		} else
			return;
	}

}