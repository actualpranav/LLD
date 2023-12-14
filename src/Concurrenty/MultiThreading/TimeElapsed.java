package Concurrenty.MultiThreading;

public class TimeElapsed implements Runnable {
    public void run(){
        int timeSlept = 0;
        while(true){
            System.out.println("Time Elapsed : " + timeSlept);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            timeSlept++;
            if(timeSlept > 10){
                System.out.println("Time Elapsed thread has timeout out");
                break;
            }
        }
    }
}
