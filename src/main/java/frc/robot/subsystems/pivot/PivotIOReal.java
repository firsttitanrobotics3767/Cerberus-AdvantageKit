package frc.robot.subsystems.pivot;

import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.utils.Constants;
import frc.robot.utils.IDMap;

public class PivotIOReal implements PivotIO {

    private final CANSparkMax pivotMotor;
    private final AbsoluteEncoder pivotEncoder;
    public final DigitalInput forwardLimitSwitch, reverseLimitSwitch;

    public PivotIOReal() {

        pivotMotor = new CANSparkMax(IDMap.CAN.pivot.ID, MotorType.kBrushless);
        pivotMotor.restoreFactoryDefaults();
        pivotMotor.setIdleMode(IdleMode.kBrake);
        pivotMotor.setInverted(false);
        pivotMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 20);

        pivotEncoder = pivotMotor.getAbsoluteEncoder(SparkMaxAbsoluteEncoder.Type.kDutyCycle);
        pivotEncoder.setPositionConversionFactor(Constants.Pivot.degreesPerRevolution);
        pivotEncoder.setInverted(true);

        forwardLimitSwitch = new DigitalInput(IDMap.DIO.pivotForwardLimit.port);
        reverseLimitSwitch = new DigitalInput(IDMap.DIO.pivotReverseLimit.port);
    }

}
