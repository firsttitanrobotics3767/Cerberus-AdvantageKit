package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.AutoLog;

public interface DrivetrainIO {

    @AutoLog
    public static class DrivetrainIOInputs {
        
        public double leftPositionRadians = 0.0;
        public double leftRadiansPerSecond = 0.0;
        public double leftVolts = 0.0;
        public double[] leftAps = new double[] {};

    }

    public default void updateInputs(DrivetrainIOInputs inputs) {}

    public default void setVolts(double leftVolts, double rightVolts) {}
    
}
