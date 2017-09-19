package org.usfirst.frc.team1732.robot.commands.drive;

import org.usfirst.frc.team1732.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Trajectory;

/**
 *
 */
public class FollowTrajectory extends Command {

	private final Trajectory leftTraj;
	private final Trajectory rightTraj;

	public FollowTrajectory(Trajectory l, Trajectory r) {
		leftTraj = l;
		rightTraj = r;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drivetrain.setControlMode(TalonControlMode.MotionProfile);

		Robot.drivetrain.startMotionProfile(leftTraj, rightTraj);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drivetrain.executeMotionProfile();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
		// return Robot.drivetrain.leftManage.isFinished() &&
		// Robot.drivetrain.rightManage.isFinished();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.setControlMode(TalonControlMode.PercentVbus);
		Robot.drivetrain.drive(0, 0);
		Robot.drivetrain.endMotionProfile();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
