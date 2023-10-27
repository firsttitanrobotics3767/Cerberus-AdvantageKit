package frc.robot.subsystems.drivetrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{

    private final DrivetrainIO io;

    private final CANSparkMax rightFront, leftFront, rightBack, leftBack;
    private final RelativeEncoder rightEncoder, leftEncoder;
    
    public Drivetrain(DrivetrainIO io) {

        this.io = io;

        leftFront = new CANSparkMax(, null)

    }

}
