package RealBot;

import RealBot.Moment;
import RealBot.Trajectory;

import java.util.ArrayList;
import java.util.HashMap;

import org.usfirst.frc.team238.robot.Drivetrain;

/**
 * Created by raque on 9/7/2017.
 * formed to be a liason between a FRC robot project and the RealBot Trajectories.
 * implements pid loops.
 *
 *
 */
public class TrajectoryIntepreter implements Runnable{

    private ArrayList<Trajectory> trajectories;
  //  private Supplier<Double> leftVelocitySupplier, rightVelocitySupplier;
    private double leftVelocity, rightVelocity, angle;
    private Runnable loop;
    private Drivetrain driveTrain;
    private HashMap<String, Runnable> markerPoints;

    /*private double P,I,D;
    private RPID leftPID, rightPID, anglePID;
*/
    private boolean playing = false;

    public TrajectoryIntepreter(Drivetrain driveTrain, ArrayList<Trajectory> trajectories, HashMap<String, Runnable> markerPoints) {
        this.trajectories = trajectories;
/*        this.leftVelocitySupplier=leftVelocitySupplier;
        this.rightVelocitySupplier=rightVelocitySupplier;*/
        this.driveTrain=driveTrain;
        this.markerPoints=markerPoints;
        createLoop();
    }


    public void run(){
        loop.run();
        /*if(!playing){
            playing=true;
            new Thread(loop).start();
        }*/
    }

    public boolean isDone(){
        return !playing;
    }



    private void createLoop(){
        loop = () ->{
            playing=true;
            double wholeStartTime = System.currentTimeMillis();

            //will throw error if there is not atleast 2 moments in trajcetory, but there should always be more than 2
            
            double pastLeftVelocity = 0;
            double pastRightVelocity = 0;
            
            
            for(Trajectory t:trajectories){
                int index=0;
                //delT is in millis
                double dt = ( trajectories.get(0).getMoments().get(1).timeStamp-
                        trajectories.get(0).getMoments().get(0).timeStamp);
                long delT = (long) (1000*( trajectories.get(0).getMoments().get(1).timeStamp-
                        trajectories.get(0).getMoments().get(0).timeStamp));
                double trajectoryStartTime = System.currentTimeMillis();
                double pausedTime = 0;
                for(Moment m:t.getMoments()){
                    //check if you are in a marker that has an action, if so, compute the action -
                    // it could mess things up if your velocity is not 0, and
                    // your marker action runs for more than around 10-50 milliseconds
                    if(markerPoints.containsKey(m.marker)){
                        double markerStartTime = System.currentTimeMillis();
                        markerPoints.get(m.marker).run();
                        double marketStopTime = System.currentTimeMillis();
                        pausedTime+= marketStopTime-markerStartTime;
                    }
                    System.out.println(m.lVel);
                    leftVelocity = m.lVel;
                    rightVelocity = m.rVel;
                    System.out.println("RIGHT TARGET IS ="+rightVelocity);
                    angle = m.angle;
                    double leftAcceleration = (leftVelocity - pastLeftVelocity) / dt;
                    double rightAcceleration = (rightVelocity - pastRightVelocity) / dt;
                    pastLeftVelocity = leftVelocity;
                    pastRightVelocity = rightVelocity;
                    double leftAddIn = leftAcceleration * 0.05;
                    double rightAddIn = rightAcceleration * 0.05;
                    System.out.println("Right Accleration" +rightAcceleration);
                    driveTrain.driveSpeed(leftVelocity + leftAddIn,rightVelocity + rightAddIn);

                    //delay is (elapsedTime-pausedtime) - timeStamp
                    long delay = (long) ((System.currentTimeMillis() - trajectoryStartTime - pausedTime) - m.timeStamp*1000);
                    try {
                        Thread.sleep(Math.max(1,delT - delay));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    index++;
                }


            }
            playing = false;
        };
    }


    public double getWantedLeftVelocity(){
        if(playing){
            return leftVelocity;
        }
        return 0;
    }

    public double getWantedRightVelocity(){
        if(playing){
            return rightVelocity;
        }
        return 0;
    }

    public double getWantedAngle(){
        if(playing){
            return angle;
        }
        return 0;
    }


}
