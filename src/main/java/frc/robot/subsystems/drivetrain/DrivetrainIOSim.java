package frc.robot.subsystems.drivetrain;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import frc.robot.utils.Constants.Drivetrain;

public class DrivetrainIOSim implements DrivetrainIO{
            
    private DifferentialDrivetrainSim sim = DifferentialDrivetrainSim.createKitbotSim(
                KitbotMotor.kDoubleNEOPerSide, KitbotGearing.k10p71, KitbotWheelSize.kSixInch, null);


    private double leftVolts = 0.0;
    private double rightVolts = 0.0;

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        sim.update(0.02);
        inputs.leftVolts = leftVolts;
        inputs.leftPositionRads = sim.getLeftPositionMeters() / Drivetrain.wheelRadius;
        inputs.leftVelocityRadsPerSec = sim.getLeftVelocityMetersPerSecond() / Drivetrain.wheelRadius;
        inputs.leftAmps = new double[] {sim.getLeftCurrentDrawAmps()};

        inputs.rightVolts = rightVolts;
        inputs.rightPositionRads = sim.getRightPositionMeters() / Drivetrain.wheelRadius;
        inputs.rightVelocityRadsPerSec = sim.getRightVelocityMetersPerSecond() / Drivetrain.wheelRadius;
        inputs.rightAmps = new double[] {sim.getRightCurrentDrawAmps()};

        inputs.gyroYaw = sim.getHeading();
    }

    @Override
    public void setVolts(double leftVoltsToApply, double rightVoltsToApply) {
        leftVolts = MathUtil.clamp(leftVoltsToApply, -12.0, 12.0);
        rightVolts = MathUtil.clamp(rightVoltsToApply, -12.0, 12.0);

        sim.setInputs(leftVolts, rightVolts);
    }

}
