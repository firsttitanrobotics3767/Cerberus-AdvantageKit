package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final ArmIO io;
  private final ArmIOInputsAutoLogged inputs;

  public Arm(ArmIO io) {
    this.io = io;
    
    inputs = new ArmIOInputsAutoLogged();
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.processInputs("Arm", inputs);
  }

  public void setPosition(double position) {}

  public void setVelocity(double velocity) {

  }

  public void resetEncoder() {
    io.resetEncoder();
  }

  public void setEncoder(double position) {
    io.setEncoder(position);
  }

  public double getPosition() {
    return inputs.position;
  }

  public boolean 
}
