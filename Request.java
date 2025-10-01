public class Request {
    public int id;
    public int cylinder;
    public double arrivalTime;
    public double deadline; // deadline for OADA
    public double startTime;
    public double finishTime;
    public double age;      // age for OADA scoring

    // Constructor with explicit deadline
    public Request(int id, int cylinder, double arrivalTime, double deadline) {
        this.id = id;
        this.cylinder = cylinder;
        this.arrivalTime = arrivalTime;
        this.deadline = deadline;
        this.age = 0;
        this.startTime = 0;
        this.finishTime = 0;
    }

    // Constructor without explicit deadline, default deadline = arrivalTime + 10
    public Request(int id, int cylinder, double arrivalTime) {
        this(id, cylinder, arrivalTime, arrivalTime + 10);
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Request{id:" + id + ", cylinder:" + cylinder + ", arrivalTime:" + arrivalTime +
               ", deadline:" + deadline + ", age:" + age + "}";
    }
}
