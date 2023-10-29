package frc.robot.subsystems.drivetrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.utils.IDMap.CAN;

public class DrivetrainIOReal implements DrivetrainIO{

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

    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {

        inputs.leftPositionRadians = Units.rotationsToRadians(leftEncoder.getPosition());
        inputs.leftRadiansPerSecond = Units.rotationsPerMinuteToRadiansPerSecond(leftEncoder.getVelocity());
        inputs.leftVolts = leftFront.getAppliedOutput() * leftFront.getBusVoltage();
        inputs.leftAmps = new double[] {leftFront.getOutputCurrent(), leftBack.getOutputCurrent()};

        inputs.rightPositionRadians = Units.rotationsToRadians(rightEncoder.getPosition());
        inputs.rightRadiansPerSecond = Units.rotationsPerMinuteToRadiansPerSecond(leftEncoder.getVelocity());
        inputs.rightVolts = rightFront.getAppliedOutput() * rightFront.getBusVoltage();
        inputs.rightAmps = new double[] {rightFront.getOutputCurrent(), rightBack.getOutputCurrent()};

    }

    @Override
    public void setVolts(double leftVolts, double rightVolts) {

        leftFront.setVoltage(leftVolts);
        rightFront.setVoltage(rightVolts);

    }

    public void resetEncoders() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }

}
