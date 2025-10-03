// CSC 139 FCFS Scheduler
// Austin Melenedz

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

	// Make sure task is not NULL
	if (t == NULL) {
		return;
	}

	// Set task name
	t->name = strdup(name);

	// Set unique task ID
	t->tid = next_tid++;

	// Set priority
	t->priority = priority;

	// Set CPU burst
	t->burst = burst;

	// Insert task at the head of the linked list
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

	// Find the last node in list
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

// FCFS Scheduler
void schedule() {
	// Continue until all tasks are executed
	while (head != NULL) {
		Task *t = pick_tail_task();

		if (t == NULL) {
			break;
		}

		// FCFS is non-preemptive run full burst
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
