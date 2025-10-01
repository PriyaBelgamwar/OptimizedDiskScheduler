## Optimized Adaptive Disk Scheduling Algorithm ##
# Overview
This project implements an Optimized Adaptive Disk Scheduling Algorithm in Java, built as part of my exploration into operating system storage systems.

Traditional disk scheduling algorithms (like FCFS, SSTF, SCAN) work well under specific conditions, but they often fail when workloads contain:
1. Real-time requests (with deadlines)
2. Old requests (starvation risk)
3. Nearby requests (efficiency trade-offs)

👉 This project introduces an Adaptive Scheduler that prioritizes requests dynamically based on:
1. Deadline (time-sensitive I/O requests)
2. Age (to avoid starvation)
3. Proximity (to reduce head movement & seek time)

The goal is to minimize average waiting time, seek time, and latency, while ensuring deadlines are respected.

⚙️ Features

# Implementation of classic disk scheduling algorithms:
1. FCFS (First Come First Serve)
2. SSTF (Shortest Seek Time First)

# Optimized Adaptive Scheduler (proposed approach)
# Tracks performance metrics:
1. Average waiting time
2. Total head movement
3. Deadline misses

# Modular design with a clean Scheduler interface → easy to extend with new policies

# Automated simulation of request queues with custom workloads

🛠️ Tech Stack

Language: Java
Environment: VS Code
Domain: Operating System, Storage Systems

## OptimizedDiskScheduler/
 └── src/
      ├── Main.java            # Entry point
      ├── Request.java         # Request model
      ├── Scheduler.java       # Scheduler interface
      ├── FCFS.java            # FCFS implementation
      ├── SSTF.java            # SSTF implementation
      ├── AdaptiveScheduler.java # Optimized adaptive scheduler
      └── Simulator.java       # Core simulator

▶️ How to Run

1. Clone the repo:
git clone https://github.com/<your-username>/OptimizedDiskScheduler.git
cd OptimizedDiskScheduler/src


2. Compile all Java files:
javac *.java


3. Run the project:
java Main

📊 Sample Output
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

  🚀 Future Improvements

# Add SCAN & C-SCAN for more comparisons
# Improve deadline-aware scheduling for real-time workloads
# Add visualization (graphs/charts) of head movement

📖 Learning Outcomes

# Hands-on understanding of disk scheduling algorithms
# Practical experience with simulation design in Java
# Knowledge of system performance metrics in OS

 👩‍💻 Author
Priya Belgamwar
Final-Year Engineering Student | AI + Systems Enthusiast