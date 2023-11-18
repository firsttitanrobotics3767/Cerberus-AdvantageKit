package frc.robot.subsystems.pivot;

import org.littletonrobotics.junction.AutoLog;

public interface PivotIO {
    @AutoLog
    public static class PivotIOInputs {
        public double positionRads = 0.0;
        public double velocityRadsPerSec = 0.0;
        public double appliedVolts;
        public double currentAmps = 0.0;
    }

    public default void updateInputs(PivotIOInputs inputs) {}

    public default void setVolts(double volts) {}

    public default void setPosition(double position) {}

    public default void stop () {}

    public default void configurePID(double p, double i, double d) {}

    /**
     * 
     * @param maxVelocity in inches per second
     * @param maxAcceleration in inches per second per second
     */
    public default void configureMotionConstraints(double maxVelocity, double maxAcceleration) {} 

    public default void configureLimits(double forwardLimit, double reverseLimit) {}

    
}
