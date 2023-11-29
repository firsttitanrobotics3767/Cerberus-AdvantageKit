package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {

  @AutoLog
  public static class ArmIOInputs {
    public double position = 0;
    public double targetPosition = 0;
    public double velocity = 0;
    public double volts = 0;
    public double amps = 0;
    public boolean forwardLimitSwitchState = false;
    public boolean reverseLimitSwitchState = false;
  }

  public void updateInputs(ArmIOInputs inputs);

  public void setPosition(double position);

  public void setVolts(double volts);

  public void resetEncoder();

  public void setEncoder(double position);

  public void stop();

  public void configurePID(double p, double i, double d, double ff, double maxVel, double maxAccel);

}
