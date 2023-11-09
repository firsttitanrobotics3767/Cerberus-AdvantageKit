package frc.robot.subsystems.manipulator;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CompressorConfigType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.utils.Constants;
import frc.robot.utils.IDMap;

public class ManipulatorIOReal implements ManipulatorIO {



    private final Compressor compressor;
    private final DoubleSolenoid conicalPincher, wrist;
    private final AddressableLED led;
    private final AddressableLEDBuffer buffer;
    private final int[] LEDPattern;
    private int pos = 1, dir = 1, t = 0;
    
    public ManipulatorIOReal() {

        compressor = new Compressor(PneumaticsModuleType.REVPH);
        compressor.enableAnalog(95, 115);
        
        conicalPincher = new DoubleSolenoid(PneumaticsModuleType.REVPH, IDMap.Pneumatics.openPincher.port, IDMap.Pneumatics.closePincher.port);
        conicalPincher.set(DoubleSolenoid.Value.kReverse);

        wrist = new DoubleSolenoid(PneumaticsModuleType.REVPH, IDMap.Pneumatics.wristUp.port, IDMap.Pneumatics.wristDown.port);
        wrist.set(DoubleSolenoid.Value.kForward);

        led = new AddressableLED(IDMap.DIO.LEDs.port);
        buffer = new AddressableLEDBuffer(Constants.Manipulator.LEDLength);
        led.setLength(buffer.getLength());
        requestCone();
        led.start();
        LEDPattern = new int[buffer.getLength()];

    }

    @Override
    public void updateInputs(ManipulatorIOInputs inputs) {
        inputs.clawState = getState(conicalPincher);
        inputs.wristState = getState(wrist);
    }

    @Override
    public void openPincher() {
        conicalPincher.set(DoubleSolenoid.Value.kForward);
    }

    @Override
    public void closePincher() {
        conicalPincher.set(DoubleSolenoid.Value.kForward);
    }

    @Override
    public void togglePincher() {
        conicalPincher.toggle();
    }

    @Override
    public void wristUp() {
        wrist.set(DoubleSolenoid.Value.kForward);
    }

    @Override
    public void wristDown() {
        wrist.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    public void toggleWrist() {
        wrist.toggle();
    }

    public PistonState getState(DoubleSolenoid solenoidToGetState) {
        if (solenoidToGetState.get() == DoubleSolenoid.Value.kForward) {
            return PistonState.extended;
        }
        else if (solenoidToGetState.get() == DoubleSolenoid.Value.kReverse) {
            return PistonState.retracted;
        }
        else {
            return null;
        }
    }

    // LED Methods
    public void requestCone() {
        for (int i = 0; i < buffer.getLength(); i++) {
            buffer.setRGB(i, 255, 64, 0);
        }
        led.setData(buffer);
    }

}
