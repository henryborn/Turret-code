package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants.RobotConstants;

public class Shooter {
    /**
     * Gets the angle of the shooter to shoot
     * @param x Limelight ranging
     * @return the angle needed
     */

    //finds distance from limelight to camera
    public static double x(double cameraAngle, double aprilTagHeight, double cameraHeight) {

        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry ty = table.getEntry("ty");
        double verticalAngleOffset = ty.getDouble(0.0);
        double angleToGoal = cameraAngle + verticalAngleOffset;
        double angleToGoalRadians = angleToGoal * (3.14159 / 180);

        return (aprilTagHeight - cameraHeight) / Math.tan(angleToGoalRadians);

    }
    
    public double calebFormula(double x) {
        //set some varaibles to make my life easier
        Double g = RobotConstants.Gravity;
        Double v = 30.5;
        Double y = RobotConstants.distanceFromShooterToHubHeight;
        return Math.atan((x + Math.sqrt(x*x - (2*g*x) * ((y/(v*v)) + ((g*x*x)/(2*Math.pow(v, 4))))))/((g*x*x)/(v*v)));
    }
    //if there is no offset, then turn motors on 
    public static void shoot(double calebFormula, double currentAngle) {
        if (calebFormula == currentAngle) {
            //get motor to turn on  
        }
    }
}
