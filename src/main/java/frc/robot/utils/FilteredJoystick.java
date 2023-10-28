package frc.robot.utils;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;


public class FilteredJoystick {
    static Joystick joystick;

    public FilteredJoystick(int port) {
        joystick = new Joystick(port);
    }

    public double getX(double deadzone) {
        return MathUtil.applyDeadband(joystick.getX(), deadzone);
    }

    public double getY(double deadzone) {
        return MathUtil.applyDeadband(joystick.getY(), deadzone) * -1;
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
        return MathUtil.applyDeadband(joystick.getY(), Constants.OIConstants.kDriveDeadband) * -1;
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
        return joystick.getRawButton(1);
    }

    /**
     * Returns if any POVButton is pressed or not
     * 
     * @return boolean
     */
    public boolean getPOVPressed() {
        return joystick.getPOV() != -1;
    }

    /**
     * Returns depending on which POVButton is pressed
     * 
     * @return int
     */
    public int getPOVButton() {
        int POVButton;
        if (joystick.getPOV() != -1) {
            switch (joystick.getPOV()) {
                case 0:
                    POVButton = 8;
                    break;

                case 45:
                    POVButton = 9;
                    break;

                case 90:
                    POVButton = 6;
                    break;

                case 135:
                    POVButton = 3;
                    break;

                case 180:
                    POVButton = 2;
                    break;

                case 225:
                    POVButton = 1;
                    break;

                case 270:
                    POVButton = 4;
                    break;

                case 315:
                    POVButton = 7;
                    break;

                case 360:
                    POVButton = 8;
                    break;
                default:
                    POVButton = 0;
            }
            return POVButton;
        } else {
            return 0;
        }
    }

    public static boolean getButtonTwo(){
        return joystick.getRawButton(2);
    }

    public static boolean getButtonThree(){
        return joystick.getRawButton(3);
    }

    public static boolean getButtonFour(){
        return joystick.getRawButton(4);
    }

    
    public static boolean getButtonFive(){
        return joystick.getRawButton(5);
    }

    public static boolean getButtonSix(){
        return joystick.getRawButton(6);
    }

    public static boolean getButtonSeven(){
        return joystick.getRawButton(7);
    }

    
    public static boolean getButtonEight(){
        return joystick.getRawButton(8);
    }

    public static boolean getButtonNine(){
        return joystick.getRawButton(9);
    }

    public static boolean getButtonTen(){
        return joystick.getRawButton(10);
    }

    
    public static boolean getButtonEleven(){
        return joystick.getRawButton(11);
    }

    public static boolean getButtonTwelve(){
        return joystick.getRawButton(12);
    }
}