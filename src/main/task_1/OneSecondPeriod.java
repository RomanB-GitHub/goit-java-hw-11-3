package main.task_1;

import java.util.Date;

public class OneSecondPeriod implements Runnable{

    @Override
    public void run() {

        Date startTime = new Date();
        Thread myThread = Thread.currentThread();
        while (!myThread.isInterrupted()){
            synchronized(this){
                if(!oneSecondPause()) break;
            }
            System.out.println("Application was started : " +
                    (new Date().getTime() - startTime.getTime()) / 1000 + "sec. ago...");
        }
    }

    private boolean oneSecondPause() {
        try {
            wait(1000);
        } catch(InterruptedException e){
                return false;
        }
        notify();
        return true;
    }
}
