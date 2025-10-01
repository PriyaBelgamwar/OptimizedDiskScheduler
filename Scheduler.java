public interface Scheduler {
    // Add a new request to the scheduler
    void addRequest(Request r);

    // Return the next request to serve based on the scheduling algorithm
    Request next(int head, double time);

    // Check if there are pending requests in the scheduler
    boolean hasPending();

    // Return the name of the scheduling algorithm
    String name();
}
