package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain.Drivetrain;
import java.util.function.Supplier;

public class ArcadeDrive extends Command {
  private final Drivetrain drivetrain;
  private final Supplier<Double> forwardSpeed, turnSpeed;

  public ArcadeDrive(
    Supplier<Double> forwardSpeed, Supplier<Double> turnSpeed, Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    this.forwardSpeed = forwardSpeed;
    this.turnSpeed = turnSpeed;
    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    drivetrain.arcadeDrive(forwardSpeed.get(), turnSpeed.get());
  }

  @Override
  public void end(boolean isInterrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
