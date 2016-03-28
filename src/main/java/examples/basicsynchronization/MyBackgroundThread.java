package examples.basicsynchronization;

import examples.basicsynchronization.MutableData;

/**
 * Created by Agustin on 3/28/2016.
 */
public class MyBackgroundThread implements Runnable {

    private final MutableData mutableData;

    public MyBackgroundThread(MutableData mutableData) {
        this.mutableData = mutableData;
    }

    /**
     * The termination on this method is constrained by the implementation of the method isStopRequested
     * if no synchronization is provided this method may run endlessly.
     */
    public void run() {
        System.out.println("2. Background Thread started");
        int i = 0;
        while(!mutableData.isStopRequested()) i++;
        System.out.println(String.format("2. Background Thread finished: Achieved %d iterations!", i));
    }
}