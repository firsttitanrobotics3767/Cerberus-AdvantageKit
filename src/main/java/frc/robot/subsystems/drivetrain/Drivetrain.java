package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{

    private final DrivetrainIO io;

    private final DrivetrainIOInputsAutoLogged inputs = new DrivetrainIOInputsAutoLogged();
    
    public Drivetrain(DrivetrainIO io) {

        this.io = io;

    }

    @Override
    public void periodic() {
        
        io.updateInputs(inputs);
        Logger.processInputs("Drivetrain", inputs);

    }

}
