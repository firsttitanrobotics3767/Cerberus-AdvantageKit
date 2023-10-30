package frc.robot.subsystems.manipulator;

import org.littletonrobotics.junction.AutoLog;

public interface ManipulatorIO {

    @AutoLog
    public static class ManipulatorIOInputs {
        
    }

    public default void updateInputs(ManipulatorIOInputs inputs) {}
    
}
