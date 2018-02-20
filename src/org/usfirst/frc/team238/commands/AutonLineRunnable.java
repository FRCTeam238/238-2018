package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.robot.Drivetrain;
import org.usfirst.frc.team238.robot.Navigation;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonLineRunnable implements Runnable{
    
    double angle, topSpeed, distance;
    double rotateOutput;
    
    final double acceleration = 100; //  in/sec^2
    final double ANGLE_KP = 3;
    
    boolean stop = false;
    
    Navigation navigation;
    Drivetrain driveTrain;
    
    
    //EVERHING IS IN INCHESSSSSSS
    public AutonLineRunnable(Drivetrain driveTrain, Navigation navigation, double distance,double topSpeed,double angle){

        
    
        this.angle=angle;
        this.topSpeed=topSpeed;
        this.distance=distance;
        
        this.driveTrain = driveTrain;
        this.navigation = navigation;
        
/*        if(Math.abs(distance)<70){
            double delD = 70-Math.abs(distance);
            double factor = 25 * (delD/70);
            this.distance = distance>0? distance+factor:distance-factor;
        }*/
    }

    double delT = 50;
    public void run(){

        double timeToStop = Math.abs(topSpeed/acceleration);
        
        
        boolean deAccelerate = false;   
        double initialPosL = driveTrain.leftDistanceTravelled();
        double initialPosR = driveTrain.rightDistanceTravelled();
        double distanceTravelled =0;
        System.out.println("INITIAL POSL:" + initialPosL + "  INITIALPOSR:" + initialPosR + "DISTANCE" + distance);
        
        boolean backwards = distance<0;
        
        double currentVelocity = 0;
        double lastVelocity =0;
        while(!stop && DriverStation.getInstance().isAutonomous() && DriverStation.getInstance().isEnabled()){
  
            double distanceNeededToStop = (Math.abs(currentVelocity)/2) * timeToStop;
            
            distanceTravelled=Math.abs(driveTrain.leftDistanceTravelled() - initialPosL + 
                    driveTrain.rightDistanceTravelled() - initialPosR) / 2;
            System.out.println("DISTANCETRAVELLED:" + distanceTravelled);
            //remainingdistance
            if(Math.abs(distance) - distanceTravelled<=distanceNeededToStop){
                deAccelerate=true;
            }

            if(deAccelerate? !backwards:backwards){
                currentVelocity-= (delT/1000) * acceleration;
            }else{
                currentVelocity += (delT/1000) * acceleration;
            }
            currentVelocity = Math.max(Math.min(topSpeed, currentVelocity), -topSpeed);
           // System.out.println("currentV:" + currentVelocity);
            System.out.println(deAccelerate);
            //System.out.println(backwards);

            double angleError = angle - navigation.getYaw() ;
            if(Math.abs(angleError) > (360.0 - 0.0)/2.0D) {
                angleError = angleError>0.0D ? angleError- 360.0+ 0.0 : angleError + 360.0 -0.0; 
            }
 
            double angleVelocityAddend = angleError * ANGLE_KP;
            angleVelocityAddend = Math.min(50, Math.max(angleVelocityAddend, -50));

            System.out.println("ANGLEADDEND:" + angleVelocityAddend);
            driveTrain.driveSpeed(currentVelocity + angleVelocityAddend, currentVelocity - angleVelocityAddend);
            if(backwards){
                if(currentVelocity>=0 && lastVelocity<0){
                    stop=true;
                }
            }else{
                if(currentVelocity<=0 && lastVelocity>0){
                    stop=true;
                }
            }
            lastVelocity = currentVelocity;
            try
            {
                Thread.sleep((long) delT);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        driveTrain.drive(0, 0);


    }
    
    public boolean done() {
        return stop;
    }
    
   

    
    
}