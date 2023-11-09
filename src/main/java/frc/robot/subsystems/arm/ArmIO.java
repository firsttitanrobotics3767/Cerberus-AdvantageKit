package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public static class ArmIOInputs {
        public double positionInches = 0.0;
        public double velocityInchesPerSec = 0.0;
        public double appliedVolts = 0.0;
        public double currentAmps = 0.0;
        public boolean forwardLimitSwitchState = false;
        public boolean reverseLimitSwitchState = false;
    }

    public default void updateInputs(ArmIOInputs inputs) {}

    public default void setVolts(double volts) {}

    public default void setPosition(double positionInches) {}

    public default void stop() {}

    public default void configurePID(double p, double i, double d) {}

    public default void configureRotatoinPidConstraints(double maxVolosetyRadsPerSec, double maxExelerationRadsPersecPerSec) {} 

    public default void configureRotationalLimits(double upperLimit, double LowerLimit) {}

}
