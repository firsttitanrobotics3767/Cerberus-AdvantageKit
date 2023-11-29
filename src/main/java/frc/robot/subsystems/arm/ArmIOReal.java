package frc.robot.subsystems.arm;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArmIOReal implements ArmIO {
    CANSparkMax motor = new CANSparkMax(0, MotorType.kBrushless);

    public ArmIOReal() {
        var controller = motor.getPIDController();
        motor.
    }
}
