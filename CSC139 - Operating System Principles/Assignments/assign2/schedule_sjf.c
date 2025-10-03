// CSC 139 SJF Scheduler
// Austin Melendez


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "task.h"
#include "list.h"
#include "schedulers.h"
#include "CPU.h"

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

// Get the task with the shortest CPU burst
static Task *get_shortest_task() {
    // Return NULL if list is empty
    if (head == NULL) {
        return NULL;
    }

    struct node *current_node = head;

    // Start with first task as shortest
    Task *shortest_task = current_node->task;

    current_node = current_node->next;

    // Traverse list to find shortest burst task
    while (current_node != NULL) {
        if (current_node->task->burst < shortest_task->burst) {
            shortest_task = current_node->task;
        } else if (current_node->task->burst == shortest_task->burst) {
            shortest_task = shortest_task;
        }
        current_node = current_node->next;
    }

    // Return the shortest task
    return shortest_task;
}

// SJF Scheduler
void schedule() {
    // Continue until all tasks are executed
    while (head != NULL) {
        // Pick the shortest burst task
        Task *t = get_shortest_task();

        // Break if no task found
        if (t == NULL) {
            break;
        }

        // Non-preemptive so run entire burst
        int slice = t->burst;

        // Run the task
        run(t, slice);

        // Print task info
        printf(" -> ran %s (priority %d) for %d ms\n", t->name, t->priority, slice);

        // Reduce task burst by slice
        t->burst -= slice;

        // Task finished remove from list
        if (t->burst <= 0) {
            delete(&head, t);
            free(t->name);
            free(t);
        }
    }
}
