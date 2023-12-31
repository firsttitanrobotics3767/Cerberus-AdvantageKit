package frc.robot.subsystems.manipulator;

import org.littletonrobotics.junction.AutoLog;

public interface ManipulatorIO {

  public enum PistonState {
    extended,
    retracted
  }

  @AutoLog
  public static class ManipulatorIOInputs {
    public PistonState wristState;
    public PistonState clawState;
  }

    public default void updateInputs(ManipulatorIOInputs inputs) {}

    public default void openPincher() {}

    public default void closePincher() {}

    public default void togglePincher() {}

    public default void wristUp() {}

    public default void wristDown() {}

    public default void toggleWrist() {}

}
