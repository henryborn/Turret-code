package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import frc.robot.LimelightHelpers;
import frc.robot.LimelightHelpers.LimelightResults;
import frc.robot.LimelightHelpers.PoseEstimate;




public class Turret {

    private final SparkMax xTurretMotion;
    private final SparkMax yTurretMotion;
    private final SparkMax flyWheel;

    public Turret() {

        xTurretMotion = new SparkMax(0, MotorType.kBrushless);
        yTurretMotion = new SparkMax(0, MotorType.kBrushless);
        flyWheel = new SparkMax(0, MotorType.kBrushless);

    }
}
