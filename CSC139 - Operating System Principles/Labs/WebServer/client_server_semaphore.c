// CSC 139 MULTI-THREADED SERVER -- SEMAPHORE SYNCHRONIZATION
// Austin Melendez
// 11/1/2025


#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <string.h>
#include "server.h"

// Init queue for semaphore version
void init_queue_semaphore(ServerQueue *q) {
    // Indexes and counter s to 0
    q->in = 0;
    q->out = 0;
    q->count = 0;

    // Initialize mutex
    pthread_mutex_init(&q->mutex, NULL);

    // Initialize semaphores
    // Counts how many slots are available
    sem_init(&q->empty, 0, BUFFER_SIZE);

    // Counts how many items are ready to consume
    sem_init(&q->full, 0, 0);
}

// Enqueue using semaphores
void enqueue_semaphore(ServerQueue *q, Request item) {
    // Wait for an empty slot
    sem_wait(&q->empty);

    // Lock queue for writing
    pthread_mutex_lock(&q->mutex);

    // Add the request
    q->buffer[q->in] = item;

    /* Debug print
    printf("[SEMAPHORE] Enqueued: index=%d data=\"%s\" | count=%d\n", q->in, item.data, q->count);
    */

    // Move the index
    q->in = q->in + 1;
    if (q->in >= BUFFER_SIZE) {
        q->in = 0;
    }

    // Increase count
    q->count = q->count + 1;

    // Unlock queue
    pthread_mutex_unlock(&q->mutex);

    // Signal a new item added
    sem_post(&q->full);
}

// Dequeue using semaphores
Request dequeue_semaphore(ServerQueue *q) {
    Request item;

    // Wait for an available item
    sem_wait(&q->full);

    // Lock queue for reading
    pthread_mutex_lock(&q->mutex);

    // Remove the item
    item = q->buffer[q->out];

    /* Debug print
    printf("[SEMAPHORE] Dequeued: index=%d data=\"%s\" | count=%d\n", q->out, item.data, q->count);
    */

    // Move the index
    q->out = q->out + 1;
    if (q->out >= BUFFER_SIZE) {
        q->out = 0;
    }

    // Decrease count
    q->count = q->count - 1;

    // Unlock mutex
    pthread_mutex_unlock(&q->mutex);

    // Signal a slot is empty
    sem_post(&q->empty);

    return item;
}
