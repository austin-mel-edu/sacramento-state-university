// CSC 139 MULTI-THREADED SERVER ASSIGNMENT
// Austin Melendez
// 11/1/2025


#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <string.h>
#include "server.h"

// Synchronization types
extern void init_queue_mutex(ServerQueue *q);
extern void init_queue_condvar(ServerQueue *q);
extern void init_queue_semaphore(ServerQueue *q);

extern void enqueue_mutex(ServerQueue *q, Request item);
extern Request dequeue_mutex(ServerQueue *q);

extern void enqueue_condvar(ServerQueue *q, Request item);
extern Request dequeue_condvar(ServerQueue *q);

extern void enqueue_semaphore(ServerQueue *q, Request item);
extern Request dequeue_semaphore(ServerQueue *q);

// Global shared queues (shared resource)
ServerQueue requestQueue;
ServerQueue responseQueue;

// (1 = mutex, 2 = condvar, 3 = semaphore)
int sync_mode = 1;

// Print help menu for selecting sync type
void print_usage(char *progname) {
    printf("Usage: %s [mode]\n", progname);
    printf("  mode = 1 : Mutex Locks\n");
    printf("  mode = 2 : Conditional Variables\n");
    printf("  mode = 3 : Semaphores\n");
    printf("\nExample:\n  %s 3   # Run with semaphore synchronization\n\n", progname);
}

// Select correct enqueue function based on entered sync type
void enqueue_item(ServerQueue *q, Request item) {
    if (sync_mode == 1) {
        enqueue_mutex(q, item);
    } else if (sync_mode == 2) {
        enqueue_condvar(q, item);
    } else {
        enqueue_semaphore(q, item);
    }
}

// Select correct dequeue function based on entered sync type
Request dequeue_item(ServerQueue *q) {
    Request r;
    if (sync_mode == 1) {
        r = dequeue_mutex(q);
    } else if (sync_mode == 2) {
        r = dequeue_condvar(q);
    } else {
        r = dequeue_semaphore(q);
    }
    return r;
}

// Multi-threaded Web Server Simulation
// Allows two-way communcation with two seperate shared resources (request & responsed queues) 

// Client thread
void *client_thread(void *arg) {
    int client_id = *(int *)arg;

    // Loop that sends requests
    for (int i = 0; i < 5; i++) {
        Request req;
        req.id = client_id * 100 + i;
        // HTTPS data simulation
        snprintf(req.data, 128, "Client %d -> Request %d", client_id, i);

        // Send request to server
        printf("[Client %d] Sending request: %s\n", client_id, req.data);
        enqueue_item(&requestQueue, req);
        
        // Simulate a processing delay
        usleep(200000);
    }

    //  Loop that consumes responses
    for (int i = 0; i < 5; i++) {

        // Recieve response from server
        Request res = dequeue_item(&responseQueue);
        printf("[Client %d] Received response: %s\n", client_id, res.data);
        
        // Simulate a processing delay
        usleep(100000);
    }

    return NULL;
}

// Server thread
void *server_thread(void *arg) {
    (void)arg;

    //  Loop that consumes requests
    for (int i = 0; i < 15; i++) {
        // Recieve request from client
        Request req = dequeue_item(&requestQueue);
        printf("[Server] Recieved request: %s\n", req.data);
        
        // Simulate a processing delay
        usleep(300000);

        // Send response to client
        Request res;
        res.id = req.id;
        // HTTPS data simulation
        snprintf(res.data, 128, "Processed response for %s", req.data);
        printf("[Server] Sending response: %s\n", res.data);
        enqueue_item(&responseQueue, res);
    }

    return NULL;
}

int main(int argc, char *argv[]) {
    printf("\nMulti-threaded Web Server Simulation \n");

    // If invalid command print help menu
    if (argc != 2) {
        print_usage(argv[0]);
        return 1;
    }

    sync_mode = atoi(argv[1]);
    if (sync_mode < 1 || sync_mode > 3) {
        print_usage(argv[0]);
        return 1;
    }

    // Initialize based on mode
    if (sync_mode == 1) {
        printf("Mutex Locks \n\n");
        init_queue_mutex(&requestQueue);
        init_queue_mutex(&responseQueue);
    } else if (sync_mode == 2) {
        printf("Conditional Variables \n\n");
        init_queue_condvar(&requestQueue);
        init_queue_condvar(&responseQueue);
    } else {
        printf("Semaphores \n\n");
        init_queue_semaphore(&requestQueue);
        init_queue_semaphore(&responseQueue);
    }

    pthread_t server;
    pthread_t clients[3];
    int client_ids[3] = {1, 2, 3};

    pthread_create(&server, NULL, server_thread, NULL);

    for (int i = 0; i < 3; i++) {
        pthread_create(&clients[i], NULL, client_thread, &client_ids[i]);
    }

    for (int i = 0; i < 3; i++) {
        pthread_join(clients[i], NULL);
    }

    pthread_join(server, NULL);

    printf("\n Simluation Completed! \n");
    return 0;
}