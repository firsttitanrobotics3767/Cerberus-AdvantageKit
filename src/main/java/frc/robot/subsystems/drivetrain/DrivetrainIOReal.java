package frc.robot.subsystems.drivetrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utils.IDMap.CAN;

public class DrivetrainIOReal implements DrivetrainIO{

    public final DifferentialDrive differentialDrive;

    private final CANSparkMax rightFront, leftFront, rightBack, leftBack;
    private final RelativeEncoder rightEncoder, leftEncoder;

    
    public DrivetrainIOReal() {

        leftFront = new CANSparkMax(CAN.leftFront.ID, MotorType.kBrushless);
        leftFront.restoreFactoryDefaults();
        leftFront.setIdleMode(IdleMode.kBrake);
        leftFront.setInverted(false);

        rightFront = new CANSparkMax(CAN.rightFront.ID, MotorType.kBrushless);
        rightFront.restoreFactoryDefaults();
        rightFront.setIdleMode(IdleMode.kBrake);
        rightFront.setInverted(false);

        leftBack = new CANSparkMax(CAN.leftBack.ID, MotorType.kBrushless);
        leftBack.restoreFactoryDefaults();
        leftBack.setIdleMode(IdleMode.kBrake);
        leftBack.follow(leftFront);

        rightBack = new CANSparkMax(CAN.rightBack.ID, MotorType.kBrushless);
        rightBack.restoreFactoryDefaults();
        rightBack.setIdleMode(IdleMode.kBrake);
        rightBack.follow(rightFront);

        leftEncoder = leftFront.getEncoder();
        rightEncoder = rightFront.getEncoder();
        resetEncoders();

        differentialDrive = new DifferentialDrive(leftFront, rightFront);

    }

    public void arcadeDrive(double forwardSpeed, double turningSpeed) {

        differentialDrive.arcadeDrive(forwardSpeed, turningSpeed);

    }

    public void tankDriveVolts(double leftVolts, double rightVolts) {

        leftFront.setVoltage(leftVolts);
        rightFront.setVoltage(rightVolts);
        differentialDrive.feed();

    }

    public void resetEncoders() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }

}
