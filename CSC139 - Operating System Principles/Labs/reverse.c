// CSC139 - Reverse Program Assignment
// Austin Melendez
//
//


#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Linked list node to store lines in input file
typedef struct Node {
	char *line;
	struct Node *next;
} Node;

// Create a new node with given text
Node* create_node(const char *text) {
	Node *node = malloc(sizeof(Node));
	if (!node) {
		fprintf(stderr, "error: malloc failed\n");
		exit(1);
	}
	node->line = strdup(text);
	if (!node->line) {
		fprintf(stderr, "error: malloc failed\n");
		exit(1);
	}
	node->next = NULL;
	return node;
}

// Function to reverse linked list and return new head
Node* reverse_list(Node *head) {
	Node *prev = NULL;
	Node *curr = head;
	while (curr) {
		Node *next = curr->next;
		curr->next = prev;
		prev = curr;
		curr = next;
	}
	return prev;
}

// Main function
int main(int argc, char *argv[]) {
	FILE *in = stdin;
	FILE *out = stdout;
	char *in_name = NULL;
	char *out_name = NULL;

	// Handle args
	// Zero args given: stdin -> stdout
	if (argc == 1) {

	}
	// One arg given: input file
	else if (argc == 2) {
		in_name = argv[1];
		in = fopen(in_name, "r");
		if (!in) {
			fprintf(stderr, "error: cannot open file '%s'\n", in_name);
			exit(1);
		}
	}
	// Two args given: input and output file
	else if (argc == 3) {
		in_name = argv[1];
		out_name = argv[2];
		// If input and output file are exact same
		if (strcmp(in_name, out_name) == 0) {
			fprintf(stderr, "reverse: input and output file must differ\n");
			exit(1);
		}
		in = fopen(in_name, "r");
		// If input file is NULL
		if (!in) {
			fprintf(stderr, "error: cannot open file '%s'\n", in_name);
			exit(1);
		}
		out = fopen(out_name, "w");
		// If output file is NULL
		if (!out) {
			fprintf(stderr, "error: cannot open file '%s'\n", out_name);
			exit(1);
		}
	}
	// Else print help/usage message
	else {
		fprintf(stderr, "usage: reverse <input> <output>\n");
		exit(1);
	}

	// Read all lines in input file into linked list
	Node *head = NULL;
	Node *tail = NULL;
	char *line = NULL;
	size_t len = 0;
	ssize_t nread;

	// While file has lines
	while ((nread = getline(&line, &len, in)) != -1) {
		if (nread > 0 && line[nread - 1] == '\n'){
			// Remove newline
			line[nread - 1] = '\0';
		}
		Node *node = create_node(line);
		if (!head) {
			head = tail = node;
		}
		else {
			tail->next = node;
			tail = node;
		}
	}

	// Release memory and close file
	free(line);
	if (in != stdin) {
		fclose(in);
	}

	// Reverse the linked list
	head = reverse_list(head);

	// Print lines in reversed order
	Node *curr = head;
	while (curr) {
		fprintf(out, "%s\n", curr->line);
		curr = curr->next;
	}

	if (out != stdout) {
		fclose(out);
	}

	// Clear memory
	curr = head;
	while (curr) {
		Node *next = curr->next;
		free(curr->line);
		free(curr);
		curr = next;
	}

	return 0;
}



