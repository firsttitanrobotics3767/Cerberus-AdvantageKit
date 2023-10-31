package frc.robot.subsystems.manipulator;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.manipulator.ManipulatorIO.PistonState;

public class Manipulator extends SubsystemBase{
    
    private final ManipulatorIO io;
    private final ManipulatorIOInputsAutoLogged inputs = new ManipulatorIOInputsAutoLogged();
    
    public Manipulator(ManipulatorIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Manipulator", inputs);
    }

    public PistonState getClawState() {
        return inputs.clawState;
    }

    public PistonState getWristState() {
        return inputs.wristState;
    }

}
