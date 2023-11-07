package frc.robot.subsystems.drivetrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.util.Units;
import frc.robot.utils.IDMap.CAN;

public class DrivetrainIOReal implements DrivetrainIO {

  private final CANSparkMax frontRight, frontLeft, backRight, backLeft;
  private final RelativeEncoder rightEncoder, leftEncoder;

  public DrivetrainIOReal() {

    frontLeft = new CANSparkMax(CAN.frontLeft.ID, MotorType.kBrushless);
    frontLeft.restoreFactoryDefaults();
    frontLeft.setIdleMode(IdleMode.kBrake);
    frontLeft.setInverted(false);
    frontLeft.enableVoltageCompensation(12.0);
    frontLeft.burnFlash();

    frontRight = new CANSparkMax(CAN.backLeft.ID, MotorType.kBrushless);
    frontRight.restoreFactoryDefaults();
    frontRight.setIdleMode(IdleMode.kBrake);
    frontRight.setInverted(true);
    frontRight.enableVoltageCompensation(12.0);
    frontRight.burnFlash();

    backLeft = new CANSparkMax(CAN.frontRight.ID, MotorType.kBrushless);
    backLeft.restoreFactoryDefaults();
    backLeft.setIdleMode(IdleMode.kBrake);
    backLeft.follow(frontLeft);
    backLeft.enableVoltageCompensation(12.0);
    backLeft.burnFlash();

    backRight = new CANSparkMax(CAN.backRight.ID, MotorType.kBrushless);
    backRight.restoreFactoryDefaults();
    backRight.setIdleMode(IdleMode.kBrake);
    backRight.follow(frontRight);
    backRight.enableVoltageCompensation(12.0);
    backRight.burnFlash();

    leftEncoder = frontLeft.getEncoder();
    leftEncoder.setPositionConversionFactor(0.09398496240601);
    leftEncoder.setVelocityConversionFactor(0.09398496240601);
    rightEncoder = frontRight.getEncoder();
    rightEncoder.setPositionConversionFactor(0.09398496240601);
    rightEncoder.setVelocityConversionFactor(0.09398496240601);
    resetEncoders();
  }

  @Override
  public void updateInputs(DrivetrainIOInputs inputs) {
    inputs.leftPositionRads = Units.rotationsToRadians(leftEncoder.getPosition());
    inputs.leftVelocityRadsPerSec =
        Units.rotationsPerMinuteToRadiansPerSecond(leftEncoder.getVelocity());
    inputs.leftVolts = frontLeft.getAppliedOutput() * frontLeft.getBusVoltage();
    inputs.leftAmps = new double[] {frontLeft.getOutputCurrent(), backLeft.getOutputCurrent()};

    inputs.rightPositionRads = Units.rotationsToRadians(rightEncoder.getPosition());
    inputs.rightVelocityRadsPerSec =
        Units.rotationsPerMinuteToRadiansPerSecond(leftEncoder.getVelocity());
    inputs.rightVolts = frontRight.getAppliedOutput() * frontRight.getBusVoltage();
    inputs.rightAmps = new double[] {frontRight.getOutputCurrent(), backRight.getOutputCurrent()};
  }

  @Override
  public void setVolts(double leftVolts, double rightVolts) {
    frontLeft.setVoltage(leftVolts);
    frontRight.setVoltage(rightVolts);
  }

  public void resetEncoders() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
  }
}
