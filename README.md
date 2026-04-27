**Optimized Adaptive Disk Scheduling Algorithm**

📌 **Overview**

This project implements an Optimized Adaptive Disk Scheduling Algorithm in Java, designed to improve performance over traditional disk scheduling techniques.

Conventional algorithms like FCFS and SSTF perform well under specific conditions but struggle with:

Time-sensitive (real-time) requests
Starvation of older requests
Trade-offs between efficiency and fairness

This project introduces an Adaptive Scheduler that dynamically prioritizes disk requests based on:

Deadline (time-critical operations)
Age (prevents starvation)
Proximity (reduces seek time and head movement)

The objective is to minimize average waiting time, seek time, and latency, while ensuring fair and efficient scheduling.

**Features**
Implementation of classic disk scheduling algorithms:
FCFS (First Come First Serve)
SSTF (Shortest Seek Time First)
Proposed Adaptive Scheduling Algorithm with dynamic prioritization
Performance tracking metrics:
Average Waiting Time
Total Head Movement
Deadline Misses
Modular and extensible design using a Scheduler interface
Simulation of disk request queues with customizable workloads

** Tech Stack**
Language: Java
Environment: VS Code
Domain: Operating Systems, Storage Systems

**Project Structure**
OptimizedDiskScheduler/
 └── src/
      ├── Main.java
      ├── Request.java
      ├── Scheduler.java
      ├── FCFS.java
      ├── SSTF.java
      ├── AdaptiveScheduler.java
      └── Simulator.java
      
**How to Run**
1. Clone the repository:
   git clone https://github.com/<your-username>/OptimizedDiskScheduler.git
cd OptimizedDiskScheduler/src
2. Compile the project:
   javac *.java
3. Run the application:
   java Main

  ** Sample Output**
FCFS Results:
  Served: 5
  Avg Wait: 3.2
  Total Head Movement: 176

SSTF Results:
  Served: 5
  Avg Wait: 2.0
  Total Head Movement: 140

Adaptive Scheduler Results:
  Served: 5
  Avg Wait: 1.6
  Total Head Movement: 125
  Missed Deadlines: 0

**Future Improvements**
Implement additional algorithms (SCAN, C-SCAN)
Enhance deadline-aware scheduling for real-time systems
Add visualization for head movement and performance metrics


**Learning Outcomes**
In-depth understanding of disk scheduling algorithms
Experience in designing system-level simulations
Practical knowledge of performance metrics in operating systems
