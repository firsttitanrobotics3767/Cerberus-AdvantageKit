package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;

public class Drivetrain extends SubsystemBase{

    private final DrivetrainIO io;
    private final DrivetrainIOInputsAutoLogged inputs = new DrivetrainIOInputsAutoLogged();

    private final DifferentialDriveOdometry odometry = 
        new DifferentialDriveOdometry(new Rotation2d(), 0.0, 0.0);
    
    public Drivetrain(DrivetrainIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Drivetrain", inputs);

        odometry.update(inputs.gyroYaw, getLeftPositionMeters(), getRightPositionMeters());
        Logger.recordOutput("Odometry", odometry);
    }

    public void ArcadeDrive(double forwardSpeed, double turnSpeed) {
        var speeds = DifferentialDrive.arcadeDriveIK(forwardSpeed, turnSpeed, true);
        io.setVolts(speeds.left * 12.0, speeds.right * 12.0);
    }

    public double getLeftPositionMeters() {
        return inputs.leftPositionRads * Constants.Drivetrain.wheelDiameter;
    }

    public double getRightPositionMeters() {
        return inputs.rightPositionRads * Constants.Drivetrain.wheelDiameter;
    }

    public double getLeftVelocityMetersPerSec() {
        return inputs.leftVelocityRadsPerSec * Constants.Drivetrain.wheelDiameter;
    }

    public double getRightVelocityMetersPerSec() {
        return inputs.rightVelocityRadsPerSec * Constants.Drivetrain.wheelDiameter;
    }

    public Pose2d getPose() {
        return odometry.getPoseMeters();
    }

    public void SetPose(Pose2d newPose) {
        // odometry.resetPosition(inputs.gyroYaw, getLeftPositionMeters(), getRightPositionMeters(), newPose);
    }

    

}
