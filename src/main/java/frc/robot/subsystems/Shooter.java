package frc.robot.subsystems;

import frc.robot.Constants.RobotConstants;

public class Shooter {
    /**
     * Gets the angle of the shooter to shoot
     * @param x Limelight ranging
     * @return the angle needed
     */
    public double calebFormula(double x) {
        //set some varaibles to make my life easier
        Double g = RobotConstants.Gravity;
        Double y = RobotConstants.distanceFromShooterToHubHeight;
        Double v = 30.5;
        return Math.atan((x + Math.sqrt(x*x - (2*g*x) * ((y/(v*v)) + ((g*x*x)/(2*Math.pow(v, 4))))))/((g*x*x)/(v*v)));
    }
}
