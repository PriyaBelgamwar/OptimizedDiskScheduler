import java.util.LinkedList;
import java.util.Queue;

public class FCFS implements Scheduler {
    private Queue<Request> queue = new LinkedList<>();

    @Override
    public void addRequest(Request r) {
        queue.add(r);
    }

    @Override
    public Request next(int head, double time) {
        // Return the first request in queue (FIFO)
        return queue.poll();
    }

    @Override
    public boolean hasPending() {
        return !queue.isEmpty();
    }

    @Override
    public String name() {
        return "FCFS (First Come First Serve)";
    }
}
