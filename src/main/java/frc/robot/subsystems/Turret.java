package frc.robot.subsystems;

import frc.robot.LimelightHelpers;
import frc.robot.subsystems.Shooter;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import java.nio.DoubleBuffer;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;




public class Turret {
    //move robot to horizontal and vertical position

    public static double[] aimAndRange() {
        double tx = LimelightHelpers.getTX("limelight");
        double kP = .18; //subject to change

        double angularVel = tx * kP;

        double[] limelightSpeeds = NetworkTableInstance.getDefault().getTable("limelight").getEntry("targetpose_cameraspace").getDoubleArray(new double[6]);

        double horizontalSpeeds = limelightSpeeds[0] * kP;
        double forwardSpeeds = limelightSpeeds[2] * kP;

        double[] speeds = {horizontalSpeeds, forwardSpeeds, -angularVel};

        return speeds;


    }
    
}
