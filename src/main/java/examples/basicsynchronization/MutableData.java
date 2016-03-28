package examples.basicsynchronization;

import examples.basicsynchronization.background.MyBackgroundThread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Agustin on 3/28/2016.
 * This abstract class provides simple methods to verify the  stopRequested variable
 * and a standard start method of a background thread
 */
public abstract class MutableData {

    /**
     * This method is the initializer of the background thread, and sleeps for 3 seconds and then
     * requests the stop of the background thread
     * @throws InterruptedException
     */
    protected void start() throws InterruptedException {
        Thread backgroundThread = new Thread(new MyBackgroundThread(this));
        backgroundThread.start();
        System.out.println("1. Main thread on hold for 3 seconds");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("1. Main awake");
        //Warning!!! This change is never seen by the backgroundThread thread
        requestStop();
        System.out.println("1. Stop Requested");
    }


    public abstract boolean isStopRequested();
    public abstract void requestStop();
}
