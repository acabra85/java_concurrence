package examples.basicsynchronization;

/**
 * Here only communication is synchronized since reading variable value provides
 * the latest modification performed by all threads but change is not controlling mutual
 * exclusion.
 */
public class MutableDataCommunicationSync extends MutableData {

    /**
     * This variable represents the runnable status, and is declared as
     * volatile so is guaranteed all threads will see the latest changed performed to the variable.
     */
    private volatile static boolean STOP_REQUESTED;

    public static void main(String... args) {
        try {
            new MutableDataCommunicationSync().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isStopRequested() {
        return STOP_REQUESTED;
    }

    public void requestStop() {
        STOP_REQUESTED = true;
    }
}
