package examples.basicsynchronization;

/**
 * This example provides no synchronization, for that matter, the background thread is not able
 * to see the changes performed to the variable stopRequested and therefore will run endlessly, also
 * no mutual exclusion is guaranteed since the request stop method is .
 */
public class MutableDataNoSync extends MutableData {

    /**
     * This variable represents the runnable status
     */
    private static boolean STOP_REQUESTED;

    public static void main(String... args) {
        try {
            new MutableDataNoSync().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * No synchronization is provided hence the changes to the variable are only visible to the local thread
     * that performed the change.
     * @return boolean indicating if the stop was requested
     */
    public boolean isStopRequested() {
        return STOP_REQUESTED;
    }

    public void requestStop() {
        STOP_REQUESTED = true;
    }
}
