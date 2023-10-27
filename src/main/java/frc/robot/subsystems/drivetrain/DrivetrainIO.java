package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.AutoLog;

public interface DrivetrainIO {

    @AutoLog
    public static class DrivetrainIOInputs {
        
        

    }

    public default void updateInputs(DrivetrainIOInputs inputs) {}

    public default void setVolts(double leftVolts, double rightVolts) {}
    
}
