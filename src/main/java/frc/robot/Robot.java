/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * This is a demo program showing thu------=-------====================================e use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot = new DifferentialDrive(new SpeedControllerGroup(new WPI_TalonSRX(1), new WPI_TalonSRX(4)), new SpeedControllerGroup(new WPI_TalonSRX(2), new WPI_TalonSRX(3)));
  private Joystick m_leftStick = new Joystick(0);

  @Override
  public void robotInit() {
   
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(m_leftStick.getY(), -m_leftStick.getX());
  }

}
