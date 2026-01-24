package frc.robot.subsystems;

import frc.robot.LimelightHelpers;




public class Turret {
    //move robot to horizontal and vertical position

    public static double[] aimAndRange() {
        double tx = LimelightHelpers.getTX("limelight");
        double kP = 0.035; //subject to change

        double angularVel = tx * kP;

        double rawForwardSpeeds = LimelightHelpers.getTY("limelight");

        double error = 3.0 - rawForwardSpeeds;

        if (Math.abs(error) < 0.05) {
            error = 0;
        }

        double forwardSpeeds = error *  kP;


        return new double[] {forwardSpeeds, angularVel};


    }
    
}
