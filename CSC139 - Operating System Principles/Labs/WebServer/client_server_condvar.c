// CSC 139 MULTI-THREADED SERVER -- CONDITIONAL VARIABLE SYNCHRONIZATION
// Austin Melendez
// 11/1/2025


#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include "server.h"

// Init queue for conditional variable version
void init_queue_condvar(ServerQueue *q) {
    // Indexes and counters to 0
    q->in = 0;
    q->out = 0;
    q->count = 0;

    // init mutex and condition variables
    pthread_mutex_init(&q->mutex, NULL);
    pthread_cond_init(&q->not_full, NULL);
    pthread_cond_init(&q->not_empty, NULL);
}

// Enqueue with condition variables
void enqueue_condvar(ServerQueue *q, Request item) {
    pthread_mutex_lock(&q->mutex);

    // Wait until there is space in the queue
    while (q->count == BUFFER_SIZE) {
        pthread_cond_wait(&q->not_full, &q->mutex);
    }

    // Add item to queue
    q->buffer[q->in] = item;

    /* Debug print
    printf("[CONDVAR] Enqueued: index=%d data=\"%s\" | count=%d\n", q->in, item.data, q->count);
    */

    // Move index forward
    q->in = q->in + 1;
    if (q->in >= BUFFER_SIZE) {
        q->in = 0;
    }

    // Increase item count
    q->count = q->count + 1;

    // Signal the queue is not empty
    pthread_cond_signal(&q->not_empty);
    pthread_mutex_unlock(&q->mutex);
}

// Dequeue with condition variables
Request dequeue_condvar(ServerQueue *q) {
    Request item;
    pthread_mutex_lock(&q->mutex);

    // Wait until something in queue
    while (q->count == 0) {
        pthread_cond_wait(&q->not_empty, &q->mutex);
    }

    // Remove item from queue
    item = q->buffer[q->out];

    /* Debug print
    printf("[CONDVAR] Dequeued: index=%d data=\"%s\" | count=%d\n", q->out, item.data, q->count); 
    */

    // Move index forward
    q->out = q->out + 1;
    if (q->out >= BUFFER_SIZE) {
        q->out = 0;
    }

    // Decrease item count
    q->count = q->count - 1;

    // Signal there is space in queue
    pthread_cond_signal(&q->not_full);
    pthread_mutex_unlock(&q->mutex);

    return item;
}
