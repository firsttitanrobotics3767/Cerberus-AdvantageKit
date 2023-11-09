package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public static class ArmIOInputs {
        public double position = 0.0;
        public double velocity = 0.0;
        public double appliedVolts = 0.0;
        public double currentAmps = 0.0;
        public boolean forwardLimitSwitchState = false;
        public boolean reverseLimitSwitchState = false;
    }

    public default void updateInputs(ArmIOInputs inputs) {}

    public default void setVolts(double volts) {}

    public default void setPosition(double position) {}

    public default void stop() {}

    public default void configurePID(double p, double i, double d) {}

    /**
     * 
     * @param maxVelocity in inches per second
     * @param maxAcceleration in inches per second per second
     */
    public default void configureMotionConstraints(double maxVelocity, double maxAcceleration) {} 

    public default void configureLimits(double forwardLimit, double reverseLimit) {}

}
