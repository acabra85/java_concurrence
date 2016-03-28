package examples.basicsynchronization.fullsynchronized;

import examples.basicsynchronization.MutableData;

/**
 * Here the communication and mutual exclusion are guaranteed since the modification to the variable STOP_REQUESTED
 * is only performed inside synchronized methods
 */
public class MutableDataFullSync extends MutableData {

    /**
     * This variable represents the runnable status
     */
    private static boolean STOP_REQUESTED;

    public static void main(String... args) {
        try {
            new MutableDataFullSync().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Note the access is synchronized
     */
    public synchronized void requestStop(){
        STOP_REQUESTED = true;
    }

    /**
     * Note the access is synchronized
     */
    public synchronized boolean isStopRequested(){
        return STOP_REQUESTED;
    }
}
