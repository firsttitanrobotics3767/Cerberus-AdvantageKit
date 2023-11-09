package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.DrivetrainIO;
import frc.robot.subsystems.drivetrain.DrivetrainIOReal;
import frc.robot.subsystems.drivetrain.DrivetrainIOSim;
import frc.robot.subsystems.manipulator.Manipulator;
import frc.robot.subsystems.manipulator.ManipulatorIO;
import frc.robot.subsystems.manipulator.ManipulatorIOReal;
import frc.robot.subsystems.manipulator.ManipulatorIOSim;
import frc.robot.utils.Constants;

public class RobotContainer {
    
    public final Drivetrain drivetrain;
    public final Manipulator manipulator;

    public final Joystick driver = new Joystick(0);
    private final Joystick operator = new Joystick(1);

    public RobotContainer() {

        switch (Constants.currentMode) {
            case REAL:
                drivetrain = new Drivetrain(new DrivetrainIOReal());
                manipulator = new Manipulator(new ManipulatorIOReal());
                break;
      
            case SIM:
              drivetrain = new Drivetrain(new DrivetrainIOSim());
              manipulator = new Manipulator(new ManipulatorIOSim());
              break;
      
            default:
              drivetrain = new Drivetrain(new DrivetrainIO() {});
              manipulator = new Manipulator(new ManipulatorIO() {});
              break;
        }

        configureBindings();

    }

    private void configureBindings() {

        JoystickButton openPincher = new JoystickButton(operator, 7);
        JoystickButton closePincher = new JoystickButton(operator, 5);
        JoystickButton wristUp = new JoystickButton(operator, 6);
        JoystickButton wristDown = new JoystickButton(operator, 8);


        openPincher.onTrue(new InstantCommand(() -> manipulator.openPincher()));
        closePincher.onTrue(new InstantCommand(() -> manipulator.closePincher()));
        wristUp.onTrue(new InstantCommand(() -> manipulator.wristUp()));
        wristDown.onTrue(new InstantCommand(() -> manipulator.wristDown()));

    }

}
