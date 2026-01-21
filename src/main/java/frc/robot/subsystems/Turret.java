package frc.robot.subsystems;

import frc.robot.subsystems.Shooter;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;




public class Turret {
    //move to horizontal and vertical position, also we probably need PID lol

    public static void xPosition(double x) {
         NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        double horizontalOffset = tx.getDouble(0.0);

        if (horizontalOffset != 0) {
            //move motor to where it should be, use PID
        }
        
    }

    public static void yPosition(double calebFormula, double verticalAngleOffset) { 
        if (verticalAngleOffset != 0) {
            //move motor to where it should be, use PID???
        }


    }
    
}
