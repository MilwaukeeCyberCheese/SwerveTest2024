package frc.robot.utils;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;


public class FilteredJoystick {
    Joystick joystick;

    public FilteredJoystick(int port) {
        this.joystick = new Joystick(port);
    }

    public double getX(double deadzone) {
        return MathUtil.applyDeadband(joystick.getX(), deadzone);
    }

    public double getY(double deadzone) {
        return MathUtil.applyDeadband(joystick.getY(), deadzone);
    }

    public double getZ(double deadzone) {
        return MathUtil.applyDeadband(joystick.getZ(), deadzone);
    }

    public double getThrottle(double deadzone) {
        return MathUtil.applyDeadband(joystick.getThrottle(), deadzone);
    }

    public double getTwist(double deadzone) {
        return MathUtil.applyDeadband(joystick.getTwist(), deadzone);
    }

    public double getX() {
        return MathUtil.applyDeadband(joystick.getX(), Constants.OIConstants.kDriveDeadband);
    }

    public double getY() {
        return MathUtil.applyDeadband(joystick.getY(), Constants.OIConstants.kDriveDeadband);
    }

    public double getZ(){
        return MathUtil.applyDeadband(joystick.getZ(), Constants.OIConstants.kDriveDeadband);
    }

    public double getThrottle() {
        return MathUtil.applyDeadband(joystick.getThrottle(), Constants.OIConstants.kDriveDeadband);
    }

    public double getTwist(){
        return MathUtil.applyDeadband(joystick.getTwist(), Constants.OIConstants.kDriveDeadband);
    }

     

    /**
     * Returns whether or not the trigger is pressed or not
     * 
     * @return boolean
     */
    public boolean getTriggerActive() {
        return joystick.getTrigger();
    }

     /**
     * Returns if any POVButton is pressed or not
     * 
     * @return boolean
     */
    public boolean getHatressed() {
        return joystick.getPOV() != -1;
    }

}