// CSC 139 MULTI-THREADED SERVER -- SERVER VARIABLES
// Austin Melendez
// 11/1/2025

#ifndef SERVER_H
#define SERVER_H

#include <pthread.h>
#include <semaphore.h>

// Defining our MAX buffer size as 10 so we can easily test synchonization later
#define BUFFER_SIZE 10

// Define a REQUEST to the server
typedef struct {
    int id;
    char data[128];
} Request;

// Define the QUEUE for the server (shared resource)
typedef struct {
    Request buffer[BUFFER_SIZE];
    int in, out, count;

    // Synchronization prims
    pthread_mutex_t mutex;
    pthread_cond_t not_full;
    pthread_cond_t not_empty;

    sem_t full;
    sem_t empty;
} ServerQueue;

// Queue functions

// Initialize queue
void init_queue(ServerQueue *q);

// Mutex version
void enqueue_mutex(ServerQueue *q, Request item);
Request dequeue_mutex(ServerQueue *q);

// Conditional variable version
void enqueue_condvar(ServerQueue *q, Request item);
Request dequeue_condvar(ServerQueue *q);

// Semaphore version
void enqueue_semaphore(ServerQueue *q, Request item);
Request dequeue_semaphore(ServerQueue *q);

#endif
