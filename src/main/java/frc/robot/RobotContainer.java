package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.DrivetrainIOReal;
import frc.robot.utils.Constants;

public class RobotContainer {
    
    public final Drivetrain drivetrain = new Drivetrain(new DrivetrainIOReal());

    public final Joystick driver = new Joystick(0);

    public RobotContainer() {}

    private void configureBindings() {}

}
