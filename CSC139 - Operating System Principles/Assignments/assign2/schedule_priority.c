// CSC 139 Priority Scheduler
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

// Get the task with the highest priority
static Task *get_highest_priority_task() {
    // Return NULL if list is empty
    if (head == NULL) {
        return NULL;
    }

    struct node *current_node = head;

    // Start with first task as highest
    Task *best_task = current_node->task;

    current_node = current_node->next;

    // Loop list to find highest priority
    while (current_node != NULL) {
        if (current_node->task->priority > best_task->priority) {
            best_task = current_node->task;
        } else if (current_node->task->priority == best_task->priority) {
            best_task = best_task;
        }
        current_node = current_node->next;
    }

    // Return highest priority task
    return best_task;
}

// Priority Scheduler
void schedule() {
    // Continue until all tasks are executed
    while (head != NULL) {
        // Pick highest priority task
        Task *t = get_highest_priority_task();

        // Break if no task found
        if (t == NULL) {
            break;
        }

        // Non-preemptive so run full burst
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
