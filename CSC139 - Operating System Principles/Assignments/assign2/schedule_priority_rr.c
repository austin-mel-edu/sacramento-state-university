//  CSC 139 Priority RR Scheduler
//  Austin Melendez

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

// Find the maximum priority in the list
static int find_max_priority() {
    if (head == NULL) {
        return -1;
    }

    struct node *current_node = head;

    // Start with first task
    int max_priority = current_node->task->priority;

    current_node = current_node->next;

    // Loop list to find max priority
    while (current_node != NULL) {
        if (current_node->task->priority > max_priority) {
            max_priority = current_node->task->priority;
        }
        current_node = current_node->next;
    }

    // Return max priority
    return max_priority;
}

// Pick the highest priority task (oldest if tie)
static Task *get_highest_oldest_task() {
    int max_priority = find_max_priority();

    // Return NULL if no task exists
    if (max_priority < 0) {
        return NULL;
    }

    struct node *current_node = head;

    // Save best task
    Task *best_task = NULL;

    // Traverse list to find task with max priority
    while (current_node != NULL) {
        if (current_node->task->priority == max_priority) {
            best_task = current_node->task;
        }
        current_node = current_node->next;
    }

    // Return highest priority task
    return best_task;
}

// Priority with Round Robin Scheduler
void schedule() {
    // Continue until all tasks are executed
    while (head != NULL) {
        // Pick highest priority task
        Task *t = get_highest_oldest_task();

        // Break if no task found
        if (t == NULL) {
            break;
        }

	// Determine time slice: quantum or burst
	int slice;
	if (t->burst <= QUANTUM) {
		slice = t->burst;
	} else {
		slice = QUANTUM;
	}

	// Run the task
	run(t, slice);

	// Print task info
	printf(" -> Run %s (priority %d) for %d ms\n", t->name, t->priority, slice);

	// Reduce task burst by slice
	t->burst -= slice;

	// If task finished remove
	if (t->burst <= 0){
		printf("%s finished!\n", t->name);
		delete(&head, t);
		free(t->name);
		free(t);
	} else {
	// Task not finished rotate to head for fairness
		delete(&head, t);
		insert(&head, t);
	}
    }
}

