// CSC 139 RR Scheduler
// Austin Melendez

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "task.h"
#include "list.h"
#include "schedulers.h"
#include "cpu.h"

static struct node *head = NULL;
static int next_tid = 1;

// Add a new task to the linked list
void add(char *name, int priority, int burst) {
    Task *t = malloc(sizeof(Task));
    if (t == NULL) {
        return;
    }

    t->name = strdup(name);
    t->tid = next_tid++;
    t->priority = priority;
    t->burst = burst;

    insert(&head, t);
}

// Get the tail task to preserve arrival order
static Task *get_tail_task() {
    // Return NULL if list is empty
    if (head == NULL) {
        return NULL;
    }

    struct node *current_node = head;
    struct node *previous_node = NULL;
    struct node *last_node = NULL;

    // Find the last node in the list
    while (current_node != NULL) {
        if (current_node->next == NULL) {
            last_node = current_node;
        }
        previous_node = current_node;
        current_node = current_node->next;
    }

    // Return the task in the last node
    if (last_node != NULL) {
        return last_node->task;
    } else {
        return NULL;
    }
}

// Round Robin Scheduler
void schedule() {
    // Continue until all tasks are executed
    while (head != NULL) {
        // Pick the oldest task (tail)
        Task *t = get_tail_task();

        // Break if no task found
        if (t == NULL) {
            break;
        }

        // Determine time slice: quantum or remaining burst
        int slice;
        if (t->burst <= QUANTUM) {
            slice = t->burst;
        } else {
            slice = QUANTUM;
        }

        // Run the task
        run(t, slice);

        // Print task info
        printf(" -> ran %s (priority %d) for %d ms\n", t->name, t->priority, slice);

        // Reduce task burst by slice
        t->burst -= slice;

        // Task finished remove from list
        if (t->burst <= 0) {
	    printf("%s completed!\n", t->name);
            delete(&head, t);
            free(t->name);
            free(t);
        } else {
            // Task not finished move to head for RR
            delete(&head, t);
            insert(&head, t);
        }
    }
}
