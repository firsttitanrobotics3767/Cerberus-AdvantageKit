package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.AutoLog;

public interface DrivetrainIO {

    @AutoLog
    public static class DrivetrainIOInputs {
        
        public double leftPositionRadians = 0.0;
        public double leftRadiansPerSecond = 0.0;
        public double leftVolts = 0.0;
        public double[] leftAmps = new double[] {};

        public double rightPositionRadians = 0.0;
        public double rightRadiansPerSecond = 0.0;
        public double rightVolts = 0.0;
        public double[] rightAmps = new double[] {};

    }

    public default void updateInputs(DrivetrainIOInputs inputs) {}

    public default void setVolts(double leftVolts, double rightVolts) {}
    
}
