package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;

public interface DrivetrainIO {

    @AutoLog
    public static class DrivetrainIOInputs {
        public double leftPositionRads = 0.0;
        public double leftVelocityRadsPerSec = 0.0;
        public double leftVolts = 0.0;
        public double[] leftAmps = new double[] {};

        public double rightPositionRads = 0.0;
        public double rightVelocityRadsPerSec = 0.0;
        public double rightVolts = 0.0;
        public double[] rightAmps = new double[] {};

        public Rotation2d gyroYaw = new Rotation2d();
    }

    public default void updateInputs(DrivetrainIOInputs inputs) {}

    public default void setVolts(double leftVolts, double rightVolts) {}
    
    
}
