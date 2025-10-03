// CSC 139 - Meausre System Calls
// Austin Melendez


#define _GNU_SOURCE


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>
#include <sys/wait.h>
#include <sched.h>

#define ITER_SYS 1000000
#define ITER_CTX 100000

int main() {
    struct timeval t1, t2;
    long long start, end;
    double avg;
    int i;

    printf("Measuring System Call and Context Switch Costs\n\n");

    // SYSTEM CALL MEASUREMENT
    gettimeofday(&t1, NULL);
    for (i = 0; i < ITER_SYS; i++) {
	// Here is our system call
        read(0, NULL, 0);
    }
    gettimeofday(&t2, NULL);
    
    // Convert timevals to microseconds
    start = (long long)t1.tv_sec * 1000000LL + t1.tv_usec;
    end   = (long long)t2.tv_sec * 1000000LL + t2.tv_usec;

    // Average cost per system call, convert to nanoseconds
    avg = (double)(end - start) * 1000.0 / ITER_SYS;
    printf("System call cost: %.2f ns (avg over %d calls)\n", avg, ITER_SYS);

    // CONTEXT SWITCH MEASUREMENT
    int p1[2], p2[2];
    if (pipe(p1) < 0 || pipe(p2) < 0) {
    	fprintf(stderr, "pipe failed\n");
        exit(1);
    }

    pid_t pid = fork();
    if (pid < 0) {
        fprintf(stderr, "fork failed\n");
        exit(1);
    }

    // Child Process
    if (pid == 0) {
	// Bind CPU to zero to ensure both parent and child run on same core
        cpu_set_t set;
        CPU_ZERO(&set);
        CPU_SET(0, &set);
        sched_setaffinity(0, sizeof(set), &set);

        char c;
        for (i = 0; i < ITER_CTX; i++) {
	    // Wait to read a token from parent
            if (read(p1[0], &c, 1) != 1) {    
                fprintf(stderr, "child read failed\n");
                exit(1);
            }
	    // Send token back to parent
            if (write(p2[1], &c, 1) != 1) {
                fprintf(stderr, "child write failed\n");
                exit(1);
            }
        }
        exit(0);
    // Parent process
    } else {
	// Bind CPU to zero to ensure both parent and child run on same core
        cpu_set_t set;
        CPU_ZERO(&set);
        CPU_SET(0, &set);
        sched_setaffinity(0, sizeof(set), &set);

        char c = 'x';
        gettimeofday(&t1, NULL);
        for (i = 0; i < ITER_CTX; i++) {
            	// Send token to the chilf
		if (write(p1[1], &c, 1) != 1) {
                fprintf(stderr, "parent write failed\n");
                exit(1);
            }
		// Wait for token back from child 
            	if (read(p2[0], &c, 1) != 1) {
                fprintf(stderr, "parent read failed\n");
                exit(1);
            }
        }
        gettimeofday(&t2, NULL);

	// Wait for child to finish
        wait(NULL);

	// Convert elapsed time to microseconds
        start = (long long)t1.tv_sec * 1000000LL + t1.tv_usec;
        end   = (long long)t2.tv_sec * 1000000LL + t2.tv_usec;

	// Each round trip includes two context switches
        avg = (double)(end - start) * 1000.0 / (ITER_CTX * 2);
        printf("Context switch cost: %.2f ns (avg over %d switches)\n",
               avg, ITER_CTX * 2);
    }

    return 0;
}


