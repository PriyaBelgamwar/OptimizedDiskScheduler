import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create sample requests (id, cylinder, arrivalTime, deadline)
       List<Request> requests = Arrays.asList(
    new Request(1, 5, 0, 15),
    new Request(2, 95, 1, 25),
    new Request(3, 50, 3, 20),
    new Request(4, 20, 5, 18),
    new Request(5, 85, 7, 30),
    new Request(6, 10, 9, 22),
    new Request(7, 60, 11, 28),
    new Request(8, 35, 13, 25),
    new Request(9, 75, 15, 32),
    new Request(10, 15, 17, 23),
    new Request(11, 40, 2, 20),
    new Request(12, 90, 4, 30),
    new Request(13, 55, 6, 25),
    new Request(14, 25, 8, 18),
    new Request(15, 70, 10, 28),
    new Request(16, 5, 12, 20),
    new Request(17, 80, 14, 30),
    new Request(18, 30, 16, 22),
    new Request(19, 65, 18, 28),
    new Request(20, 50, 20, 26),
    new Request(21, 10, 5, 20),
    new Request(22, 85, 7, 30),
    new Request(23, 35, 9, 22),
    new Request(24, 60, 11, 28),
    new Request(25, 15, 13, 23),
    new Request(26, 90, 15, 32),
    new Request(27, 40, 17, 25),
    new Request(28, 55, 19, 27),
    new Request(29, 20, 21, 22),
    new Request(30, 75, 23, 30)
);


        // Run FCFS
        runScheduler(new FCFS(), requests);

        // Run SSTF
        runScheduler(new SSTF(), requests);

        // Run OADA
        runScheduler(new OADA(), requests);
    }

    // Helper method to run any scheduler
    private static void runScheduler(Scheduler scheduler, List<Request> originalRequests) {
        List<Request> requestsCopy = new ArrayList<>();
        for (Request r : originalRequests) {
            // Pass the deadline to copy as well
            requestsCopy.add(new Request(r.id, r.cylinder, r.arrivalTime, r.deadline));
        }

        Simulator sim = new Simulator(scheduler, requestsCopy);
        sim.run();
        sim.printStats();
        System.out.println(); // blank line
    }
}
