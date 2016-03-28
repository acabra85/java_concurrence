package examples.basicsynchronization.background;

import examples.basicsynchronization.MutableData;

/**
 * Created by Agustin on 3/28/2016.
 */
public class MyBackgroundThread implements Runnable {

    private final MutableData mutableData;

    public MyBackgroundThread(MutableData mutableData) {
        this.mutableData = mutableData;
    }

    public void run() {
        System.out.println("2. Background Thread started");
        int i = 0;
        while(!mutableData.isStopRequested()) i++;
        System.out.println(String.format("2. Background Thread finished: Achieved %d iterations!", i));
    }
}