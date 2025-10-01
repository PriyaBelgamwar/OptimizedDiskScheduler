import java.util.*;

public class OADA implements Scheduler {
    private List<Request> queue = new ArrayList<>();

    // Tunable weights
    private double wDeadline = 1.5;
    private double wAge = 2.0;
    private double wProximity = 1.0;

    @Override
    public void addRequest(Request r) {
        queue.add(r);
        r.age = 0; // Initialize age for scoring
    }

    @Override
    public Request next(int head, double currentTime) {
        if (queue.isEmpty()) return null;

        // Increment age for all requests that have arrived
        for (Request r : queue) {
            if (r.arrivalTime <= currentTime) {
                r.age += 1;
            }
        }

        Request best = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        for (Request r : queue) {
            if (r.arrivalTime > currentTime) continue; // Skip requests not yet arrived

            // Avoid division by zero
            double proximityScore = 1.0 / (Math.abs(r.cylinder - head) + 1);
            double timeToDeadline = Math.max(1.0, r.deadline - currentTime);
            double deadlineScore = 1.0 / timeToDeadline;

            // Final score using tunable weights
            double score = (wAge * r.age) + (wProximity * proximityScore) + (wDeadline * deadlineScore);

            if (score > bestScore) {
                bestScore = score;
                best = r;
            }
        }

        if (best != null) {
            queue.remove(best);
        }

        return best;
    }

    @Override
    public boolean hasPending() {
        return !queue.isEmpty();
    }

    @Override
    public String name() {
        return "OADA (Optimized Adaptive)";
    }
}
