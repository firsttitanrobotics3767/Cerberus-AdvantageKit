package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public static class ArmIOInputs {
        ////////////////////////////////////////////////
        //pivot
        public double rotationVositionRads = 0.0;
        public double rotationVelocityRadsPerSec = 0.0;
        public double rotationVolts = 0.0;
        public double rotationAmps = 0.0;
        public boolean upperLimitSwitchState = false;
        public boolean lowerLimitSwitchState = false;
        /////////////////////////////////////////
        //extention
        public double extentionVositionInches = 0.0;
        public double extentionVelocityInchesPerSec = 0.0;
        public double extentionVolts = 0.0;
        public double extentionAmps = 0.0;
        public boolean forwardLimitSwitchState = false;
        public boolean reverseLimitSwitchState = false;
    }
    //pivot
    public default void updateInputs(ArmIOInputs inputs) {}

    public default void setRotationVolts(double volts) {}

    public default void setRotationposition(double volasetypositoinRads) {}

    public default void stopRotation() {}

    public default void configureRotationPID() {}

    public default void configureRotatoinPidConstrants(double maxVolosetyRadsPerSec, double maxExelerationRadsPersecPerSec) {} 

    public default void configureRotationalLimits(double upperLimit, double LowerLimit) {}
    // extention


}
