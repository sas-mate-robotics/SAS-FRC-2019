/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.*;

import java.util.concurrent.TimeUnit;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 * This is a demo program showing thu------=-------====================================e use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot = new DifferentialDrive(new SpeedControllerGroup(new WPI_TalonSRX(1), new WPI_TalonSRX(2)), new SpeedControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(4)));
  private WPI_TalonSRX claww = new WPI_TalonSRX(0);
  private Solenoid shooter = new Solenoid(0);
  private WPI_TalonSRX armm = new WPI_TalonSRX(5);
  private WPI_TalonSRX armm2 = new WPI_TalonSRX(9);
  private Joystick m_leftStick = new Joystick(0);
  private JoystickButton button6 = new JoystickButton(m_leftStick, 6);
  private JoystickButton button4 = new JoystickButton(m_leftStick, 4);
  private AnalogPotentiometer spin = new AnalogPotentiometer(0, 7200.0, -3600.0);

  @Override
  public void robotInit() {
   armm.setNeutralMode(NeutralMode.Brake);
   armm2.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void teleopPeriodic() {
    
    if(m_leftStick.getPOV(0) == 0) {
      armm.set(0.5);
      armm2.set(-0.5);
    } else if(m_leftStick.getPOV(0) == 180) {
      armm.set(-0.25);
      armm2.set(0.25);
    } else {
      armm.neutralOutput();
      armm2.neutralOutput();
    }
    
    if (m_leftStick.getTrigger()) {
      shooter.set(true);
    } else {
      shooter.set(false);
    }

    if (button6.get()) {
      claww.set(0.5);
    } else if (button4.get()) {
      claww.set(-0.5);
    } else {
      claww.set(0);
    }
  }

}
