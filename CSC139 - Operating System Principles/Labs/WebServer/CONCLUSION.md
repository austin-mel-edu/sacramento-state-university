# CSC 139 - Multithreaded Web Server Simulation
## Austin Melendez
### 11/6/2025

## Project Introduction
This project we practice the use of locks, conditional variables, semaphores and the consumer/producer/shared buffer problem. 

To solve this, we have develop a simulation for a multi-threaded web server in C.

#### Requirements:
* Https requests are produced to a shared resource (server queue). Producer Thread.
* Requests are consumed from the shared resource. Consumer Thread.
* Have a loop that sends requests and a loop that consumes requests with some kind of delay.
* Implement threads synchronization using:
    * Mutex/locks (pthread).
    * Conditional variables.
    * Semaphores.
* Submit the code with comments, results with screenshot of running the code.
* Submit the process to compile and run your code for testing.
* Explain the differences between your three synchronization implementations (describe what you did) and any challenges you encountered, observations, what worked and what did not work. Which synchronization implementation would you use and why?

## Compiling the Project
Once you have extracted the contents of the `webserver.zip`, ensure all 6 files are located.
* `client_server_condvar.c`
* `client_server_mutex.c`
* `client_server_semaphore.c`
* `main.c`
* `server.h`
* `CONCLUSION.md`

Navigate to the directory and run the `gcc` command to complie the projecct.

``gcc -o webserver main.c client_server_mutex.c  client_server_condvar.c  client_server_semaphore.c -lpthread``

To view the help menu, run the command ``./webserver`` in the console:

Multi-threaded Web Server Simulation

Usage: ./webserver [mode]
*  mode = 1 : Mutex Locks
*  mode = 2 : Conditional Variables
*  mode = 3 : Semaphores

Example:
`  ./webserver 3   # Run with semaphore synchronization`

## Mutex Synchronization
To run the project with the mutex synchronization method, run the command:
``./webserver 1``

Running this command will give you the following output:
[IMAGE]

For mutex synchronization, I used `pthread_mutex_init()` to create a lock that I could unlock and lock using the respective commands `pthread_mutex_lock()` and `pthread_mutex_unlock()`. Using the mutex locks ensures mutual exlusivity when accessing shared data/resources.

## Conditional Variable Synchronization
To run the project with the conditional variable synchronization method, run the command:
``./webserver 2``

Running this command will give you the following output:
[IMAGE]

For conditional variable synchronization, I still used `pthread_mutex_init()` to create a lock to ensures mutual exlusivity when accessing shared data/resources. But we also defined two signals using `pthread_cond_init()`. We use these to signal a process to wait if the queue is full or empty using `pthread_cond_wait()` and signal a process to continue if the queue is not full and has at least one element using `pthread_cond_signal()`. Similarly to the mutex solution, we use locks and conditional variables to ensure absolute mutual exlusivity when accessing shared data/resources.

## Semaphore Synchronization
To run the project with the conditional variable synchronization method, run the command:
``./webserver 3``

Running this command will give you the following output:
[IMAGE]

For semaphores synchronization, I still used `pthread_mutex_init()` to create a lock to ensures mutual exlusivity when accessing shared data/resources. But we also defined semaphores using `sem_init()` based on slots available in the queue and how many items are ready to consume. At the start of all of our producers/condumers we run `sem_wait()` to either wait until there is an empty slot or wait until there is an available item.

## Testing


## Conclusion

