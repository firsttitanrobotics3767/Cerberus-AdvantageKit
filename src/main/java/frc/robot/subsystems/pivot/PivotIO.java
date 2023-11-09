<<<<<<< HEAD
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
}
=======
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

    public default void setPivotVolts(double volts) {}


    
}
>>>>>>> 21f92135d9110f0faa859f36c68fbe00df97ff04
