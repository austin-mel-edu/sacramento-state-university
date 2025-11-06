// CSC 139 MULTI-THREADED SERVER -- MUTEX SYNCHRONIZATION
// Austin Melendez
// 11/1/2025


#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include "server.h"

// Init queue for mutex version
void init_queue_mutex(ServerQueue *q) {
    // Indexes and counters to zero
    q->in = 0;
    q->out = 0;
    q->count = 0;

    // Initialize the mutex
    pthread_mutex_init(&q->mutex, NULL);
}

// Enqeue using mutex
void enqueue_mutex(ServerQueue *q, Request item) {
    int inserted = 0;

    // Continue to attempt to insert into queue until successful
    while (inserted == 0) {
        // Lock the queue mutex (mutual exclusivity)
        pthread_mutex_lock(&q->mutex);

        // Check if queue is full
        if (q->count < BUFFER_SIZE) {
            // Insert item at q->in index
            q->buffer[q->in] = item;

            // Increment q->in
            int next_in = q->in + 1;
            if (next_in >= BUFFER_SIZE) {
                next_in = 0;
            }
            q->in = next_in;

            // Add to count of items in queue
            int new_count = q->count + 1;
            q->count = new_count;

            // exit loop with successful insert
            inserted = 1;

            /* Debug print
            printf("[MUTEX] Enqueued: index=%d data=\"%s\" | count=%d\n", q->in, item.data, q->count);
            */
        }

        // Unlock the queue mutex
        pthread_mutex_unlock(&q->mutex);

        // If not inserted, wait a bit and try again
        if (inserted == 0) {
            usleep(50000);
        }
    }
}

// Dequeue using mutex
Request dequeue_mutex(ServerQueue *q) {
    Request item;
    int removed = 0;

    // Continue to attempt to remove from queue until successful
    while (removed == 0) {

        // Lock the queue mutex (mutual exclusivity)
        pthread_mutex_lock(&q->mutex);

        // Check if queue has at least one item
        if (q->count > 0) {

            // Read item at q->out index
            item = q->buffer[q->out];

            // increment q->out
            int next_out = q->out + 1;
            if (next_out >= BUFFER_SIZE) {
                next_out = 0;
            }
            q->out = next_out;

            // Lower item count
            int new_count = q->count - 1;
            q->count = new_count;

            // Exit loop with successful remove
            removed = 1;

            /* Debug print
            printf("[MUTEX] Dequeued: index=%d data=\"%s\" | count=%d\n", q->out, item.data, q->count);
            */
        }

        // Unlock the queue mutex
        pthread_mutex_unlock(&q->mutex);

        // If not remove, wait and retry
        if (removed == 0) {
            usleep(50000);
        }
    }

    return item;
}