import java.util.*;

public class Simulator {
    private Scheduler scheduler;
    private int headPos = 0;
    private double currentTime = 0.0;
    private List<Request> allRequests;
    private List<Request> completed = new ArrayList<>();

    public Simulator(Scheduler scheduler, List<Request> requests) {
        this.scheduler = scheduler;
        // Make a copy and sort by arrival time
        this.allRequests = new ArrayList<>(requests);
        this.allRequests.sort(Comparator.comparingDouble(r -> r.arrivalTime));
    }

    public void run() {
        Queue<Request> arrivals = new LinkedList<>(allRequests);

        while (!arrivals.isEmpty() || scheduler.hasPending()) {

            // Enqueue requests that have arrived by currentTime
            while (!arrivals.isEmpty() && arrivals.peek().arrivalTime <= currentTime) {
                scheduler.addRequest(arrivals.poll());
            }

            // Pick the next request based on scheduler
            Request serving = scheduler.next(headPos, currentTime);

            if (serving != null) {
                // Travel time = distance
                int dist = Math.abs(serving.cylinder - headPos);

                // Ensure head waits for arrival if needed
                if (serving.arrivalTime > currentTime) {
                    currentTime = serving.arrivalTime;
                }

                // Update start and finish times
                serving.startTime = currentTime;
                currentTime += dist;
                serving.finishTime = currentTime;
                headPos = serving.cylinder;

                completed.add(serving);
            } else {
                // No request available, increment time
                currentTime++;
            }
        }
    }

    public void printStats() {
        double totalWait = 0;
        double totalMovement = 0;
        int lastPos = 0;

        for (Request r : completed) {
            totalWait += (r.startTime - r.arrivalTime);
            totalMovement += Math.abs(r.cylinder - lastPos);
            lastPos = r.cylinder;
        }

        double avgWait = completed.isEmpty() ? 0 : totalWait / completed.size();

        System.out.println(scheduler.name() + " Results:");
        System.out.println("  Served: " + completed.size());
        System.out.println("  Avg Wait: " + String.format("%.2f", avgWait));
        System.out.println("  Total Head Movement: " + totalMovement);

        
    }
}
