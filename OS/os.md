# 🖥️ Operating System (OS) Fundamentals for Software Engineering Interviews

> A complete beginner-friendly Operating System cheat sheet covering the most frequently asked interview topics.

---

# Table of Contents

1. Process
2. Thread
3. Process vs Thread
4. Mutex
5. Semaphore
6. Deadlock
7. Paging
8. Segmentation
9. Virtual Memory
10. CPU Scheduling
11. Race Condition
12. IPC (Inter Process Communication)
13. Common Interview Questions
14. Quick Revision

---

# 1. Process

A **Process** is an instance of a program that is currently being executed.

A process has its own:

- Program Counter
- CPU Registers
- Memory (Code, Heap, Stack)
- Open Files
- Process ID (PID)

Example

```
Google Chrome
↓

Tab 1 → Process

Tab 2 → Process

VS Code → Process

Spotify → Process
```

Each process has its own separate memory space.

---

## Process Memory Layout

```
+--------------------+
|       Code         |
+--------------------+
|   Global Variables |
+--------------------+
|       Heap         |
|      (grows ↑)     |
+--------------------+
|       Stack        |
|      (grows ↓)     |
+--------------------+
```

---

## Process States

```
New

↓

Ready

↓

Running

↓

Waiting

↓

Ready

↓

Terminated
```

---

## Advantages

- Better isolation
- More secure
- Crash of one process doesn't affect others

---

## Disadvantages

- Expensive to create
- Context switching is slow
- Communication is slower

---

# 2. Thread

A **Thread** is the smallest unit of execution inside a process.

Multiple threads belong to the same process.

Example

```
Chrome Process

├── UI Thread

├── Rendering Thread

├── Network Thread

└── JavaScript Thread
```

---

## Threads Share

- Code
- Heap
- Global Variables

Each thread has its own

- Stack
- Registers
- Program Counter

---

## Advantages

- Lightweight
- Faster execution
- Easy communication
- Better CPU utilization

---

## Disadvantages

- Race conditions
- Shared memory issues
- Less isolated

---

# 3. Process vs Thread

| Feature | Process | Thread |
|----------|----------|---------|
|Memory|Separate|Shared|
|Creation Cost|High|Low|
|Communication|Slow|Fast|
|Crash Isolation|High|Low|
|Context Switch|Slow|Fast|

---

# 4. Mutex

Mutex = **Mutual Exclusion**

A mutex allows **only one thread** to access a shared resource at a time.

Imagine a bathroom with one key.

```
Thread A

↓

Locks Mutex

↓

Uses Resource

↓

Unlocks Mutex

↓

Thread B enters
```

---

## Example

Without Mutex

```
Balance = 100

Thread A withdraws

Thread B withdraws

Final balance becomes incorrect.
```

With Mutex

```
Thread A

↓

Lock

↓

Update Balance

↓

Unlock

↓

Thread B
```

Correct balance is maintained.

---

## Characteristics

- Binary (Locked / Unlocked)
- Ownership exists
- Only owner can unlock

---

# 5. Semaphore

Semaphore is a synchronization mechanism that controls access to resources.

Unlike Mutex, it allows multiple threads.

Example

Parking Lot

```
5 Parking Spaces

Semaphore = 5

Car enters

Semaphore = 4

...

When full

Semaphore = 0

Next car waits
```

---

## Types

### Binary Semaphore

```
Value = 0 or 1

Works similar to Mutex
```

---

### Counting Semaphore

```
Value = N

Allows N threads simultaneously.
```

---

## Mutex vs Semaphore

| Mutex | Semaphore |
|--------|-----------|
|One thread|Multiple threads|
|Ownership exists|No ownership|
|Binary|Binary or Counting|
|Used for Mutual Exclusion|Used for Resource Management|

---

# 6. Deadlock

A Deadlock occurs when two or more processes wait forever for resources held by each other.

Example

```
Thread A

Locks Resource 1

↓

Needs Resource 2

------------------------

Thread B

Locks Resource 2

↓

Needs Resource 1
```

Neither thread can continue.

---

## Four Necessary Conditions

1. Mutual Exclusion
2. Hold and Wait
3. No Preemption
4. Circular Wait

All four must exist.

---

## Prevention

- Avoid circular wait
- Acquire resources in order
- Timeout locks
- Use one global lock

---

# 7. Paging

Paging divides memory into fixed-size blocks.

Logical Memory

```
Page 1

Page 2

Page 3
```

Physical Memory

```
Frame 5

Frame 2

Frame 8
```

A page can be stored in any frame.

---

## Advantages

- No external fragmentation
- Efficient memory allocation

---

## Disadvantages

- Internal fragmentation
- Requires page tables

---

# 8. Segmentation

Segmentation divides memory based on logical sections.

Example

```
Program

↓

Code Segment

↓

Data Segment

↓

Stack Segment

↓

Heap Segment
```

Each segment has different size.

---

## Advantages

- Matches program structure
- Easy sharing
- Better protection

---

## Disadvantages

- External fragmentation
- Complex memory management

---

# Paging vs Segmentation

| Paging | Segmentation |
|----------|--------------|
|Fixed Size|Variable Size|
|No External Fragmentation|External Fragmentation|
|Hardware View|Programmer View|

---

# 9. Virtual Memory

Virtual Memory allows programs to use more memory than physically available.

It uses

```
RAM

+

Disk
```

When RAM is full

```
Unused pages

↓

Stored in Disk

↓

Loaded back when needed
```

This process is called

```
Swapping
```

or

```
Paging
```

---

## Advantages

- Run large programs
- Better memory utilization
- Process isolation

---

## Disadvantages

- Page Faults
- Disk is slower than RAM

---

## Page Fault

```
CPU requests page

↓

Page not in RAM

↓

OS loads page from Disk

↓

Execution resumes
```

---

# 10. CPU Scheduling

Scheduling decides which process gets CPU next.

---

## FCFS (First Come First Serve)

```
P1

↓

P2

↓

P3
```

Simple but may cause long waiting times.

---

## SJF (Shortest Job First)

Smallest execution time first.

Best average waiting time.

Problem

Need to know execution time in advance.

---

## Round Robin

Each process gets fixed time.

```
P1

↓

P2

↓

P3

↓

P1

↓

P2
```

Used in modern operating systems.

---

## Priority Scheduling

Higher priority executes first.

Problem

Starvation.

Solution

```
Aging
```

Increase waiting process priority over time.

---

## Comparison

| Algorithm | Fair | Fast | Starvation |
|------------|------|------|------------|
|FCFS|Medium|Low|No|
|SJF|Best|High|Yes|
|Round Robin|Best|Medium|No|
|Priority|High|High|Yes|

---

# 11. Race Condition

Race Condition occurs when multiple threads access shared data simultaneously and the final result depends on execution order.

Example

```
Counter = 0

Thread A

Counter++

Thread B

Counter++
```

Expected

```
2
```

Actual

```
1
```

because both read the same value before updating.

---

## Solution

- Mutex
- Semaphore
- Atomic Operations

---

# 12. IPC (Inter Process Communication)

Processes cannot directly access each other's memory.

IPC allows processes to communicate.

---

## Common IPC Mechanisms

### Pipe

```
Process A

↓

Pipe

↓

Process B
```

Simple communication.

---

### Message Queue

Messages stored in queue.

```
Producer

↓

Queue

↓

Consumer
```

---

### Shared Memory

Fastest IPC.

```
Process A

↓

Shared Memory

↓

Process B
```

Requires synchronization.

---

### Socket

Communication over network.

```
Client

↓

Socket

↓

Server
```

---

### Signal

Used for notifications.

Example

```
Ctrl + C

↓

SIGINT
```

---

## IPC Comparison

| IPC | Speed | Network |
|------|--------|----------|
|Pipe|Fast|No|
|Message Queue|Medium|No|
|Shared Memory|Fastest|No|
|Socket|Medium|Yes|
|Signal|Very Fast|No|

---

# Synchronization Flow

```
Thread 1

↓

Lock Mutex

↓

Critical Section

↓

Unlock

↓

Thread 2
```

---

# Deadlock Example

```
Resource A

↑        ↓

Thread 1

↓

Needs Resource B

--------------------

Resource B

↑        ↓

Thread 2

↓

Needs Resource A
```

Both wait forever.

---

# Common Interview Questions

## Process

- What is a process?
- What are process states?
- Explain process memory layout.
- What is context switching?

---

## Thread

- What is a thread?
- Process vs Thread?
- Why are threads faster?

---

## Mutex & Semaphore

- Difference between Mutex and Semaphore?
- Binary vs Counting Semaphore?
- Can a semaphore replace a mutex?

---

## Deadlock

- What is deadlock?
- Four conditions for deadlock?
- Deadlock prevention vs avoidance?

---

## Paging

- What is paging?
- What is a page table?
- What is internal fragmentation?

---

## Segmentation

- Paging vs Segmentation?
- External fragmentation?

---

## Virtual Memory

- What is virtual memory?
- What is a page fault?
- Why is virtual memory needed?

---

## Scheduling

- FCFS vs SJF?
- Why Round Robin?
- What is starvation?
- What is aging?

---

## Race Condition

- What causes race conditions?
- How can race conditions be prevented?
- Critical section vs race condition?

---

## IPC

- What is IPC?
- Pipe vs Socket?
- Shared Memory advantages?
- Why does shared memory need synchronization?

---

# Quick Revision

✅ Process → Independent running program

✅ Thread → Smallest execution unit inside a process

✅ Process → Separate memory

✅ Thread → Shared memory

✅ Mutex → One thread at a time

✅ Semaphore → Controls multiple accesses

✅ Deadlock → Processes wait forever

✅ Paging → Fixed-size memory blocks

✅ Segmentation → Variable-size logical blocks

✅ Virtual Memory → Uses Disk as extra memory

✅ Page Fault → Page not found in RAM

✅ FCFS → First Come First Serve

✅ SJF → Shortest Job First

✅ Round Robin → Time Slice Scheduling

✅ Priority → Higher Priority First

✅ Race Condition → Concurrent access causes incorrect results

✅ IPC → Communication between processes