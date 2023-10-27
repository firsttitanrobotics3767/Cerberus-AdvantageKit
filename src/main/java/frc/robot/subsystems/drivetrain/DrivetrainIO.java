package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.AutoLog;

public interface DrivetrainIO {

    @AutoLog
    public static class DrivetrainIOInputs {
        
        //add inputs here later

    }

    public default void updateInputs(DrivetrainIOInputs inputs) {}

    public default void setVolts(double leftVolts, double rightVolts) {}
    
}
