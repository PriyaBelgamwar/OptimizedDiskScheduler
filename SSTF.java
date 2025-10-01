import java.util.*;

public class SSTF implements Scheduler {
    private List<Request> queue = new ArrayList<>();

    @Override
    public void addRequest(Request r) {
        queue.add(r);
    }

    @Override
    public Request next(int head, double time) {
        if (queue.isEmpty()) return null;

        Request closest = null;
        int minDist = Integer.MAX_VALUE;

        // Find the request with the shortest seek time (closest to current head)
        for (Request r : queue) {
            int dist = Math.abs(r.cylinder - head);
            if (dist < minDist) {
                minDist = dist;
                closest = r;
            }
        }

        if (closest != null) {
            queue.remove(closest);
        }

        return closest;
    }

    @Override
    public boolean hasPending() {
        return !queue.isEmpty();
    }

    @Override
    public String name() {
        return "SSTF (Shortest Seek Time First)";
    }
}
