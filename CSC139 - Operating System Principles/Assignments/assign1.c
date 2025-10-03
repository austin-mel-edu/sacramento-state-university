// CSC 139 Operating System Principlels
// Austin Melendez

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <fcntl.h>
# include <string.h>

int q1() {
	// Initialize variable before fork
	int x = 100;
	pid_t pid;

	pid = fork();

	// Error creating fork
	if (pid < 0) {
		fprintf(stderr, "Error creating fork");
		return 1;
	} 
	// Child process
	else if (pid == 0){
		printf("Child Process: x = %d\n", x);
		
		// Change the variable x in the child process
		x = 200;
		printf("Child Process (after change): x = %d\n", x);
	}
	// Parent process
	else {
		printf("Parent Process: x = %d\n", x);
		
		// Change the variable x in the parent process
		x = 300;
		printf("Parent Process (after change): x = %d\n", x);	
	}

	return 0;
}

int q2() {
	int fd;
	pid_t pid;

	// Open a file
	fd = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
	if (fd < 0) {
		fprintf(stderr, "Error opening file");
		return(1);
	}
	
	// Create a fork of the process
	pid = fork();
	
	// Error creating fork
	if (pid < 0) {
		fprintf(stderr, "Error creating fork");
		close(fd);
		return 1;
	}
	// Child Process
	if (pid == 0) {
		// Write to file in child process
		const char *child_msg = "Child writing to file. \n";
		write(fd, child_msg, sizeof("Child writing to file. \n") - 1);
		
		// Close the file descriptor in the child process
		close(fd);
		return 0;
	}
	// Parent Process
	else {
		// Wait for child process to finish
		wait(NULL); 

		// Write to file in parent process
		const char *parent_msg = "Parent writing to file. \n";
		write(fd, parent_msg, sizeof("Parent writing to file. \n") - 1);
		
		// Close the file descriptor in the parent process
		close(fd);
		return 0;
	}

	return 0;
}

int q3() {
	int pipefd[2];
	pid_t pid;

	// Create a pipe for synchronization
	if (pipe(pipefd) == -1) {
		fprintf(stderr, "Error creating pipe");
		return 1;
	}

	// Create a fork of the process
	pid = fork();
	
	// Error creating fork
	if (pid < 0) {
		fprintf(stderr, "Error creating fork");
		return 1;
	}
	// Child Process
	if (pid == 0) {
		// Close read end of pipe
		close(pipefd[0]);
		printf("hello\n");

		// Signal the parent by writing a byte
		char dummy = 'x';
		write(pipefd[1], &dummy, 1);

		// Close write end of pipe
		close(pipefd[1]);
		return 0;
	}
	// Parent Process
	else {
		// Close write end of pipe
		close(pipefd[1]);

		// Block until child writes to pipe
		char dummy;
		read(pipefd[0], &dummy, 1);

		printf("goodbye\n");

		// Close read end of pipe
		close(pipefd[0]);
		return 0;
	}

	return 0;
}

int q4() {
	// Create fork of process
	pid_t pid = fork();

	if (pid < 0){
		fprintf(stderr, "Error creating fork");
		return 1;
	}
	// Child Process
	if (pid == 0){
		char *argv[] = {"ls", "-l", NULL};

		// Only needed for execle/execvpe
		char *envp[] = {"PATH=/bin:/usr/bin", NULL};
		
		execl("/bin/ls", "ls", "-l", NULL);
		//execle("/bin/ls", "ls", NULL, envp);
		//execlp("ls", "ls", "-l", NULL);
		//execv("/bin/ls", argv);
		//execvp("ls", argv);
		//execvpe("ls", argv, envp);
		
		// Call one of the variations of the exec() system call
		if (execvp("ls", argv) == -1) {
			fprintf(stderr, "Error running exec\n");
			return 1;
		}
		return 0;
	}
	else {
		wait(NULL);
		printf("Child process finished running /bin/ls\n");
		return 0;
	}

	return 0;
}

int q5() {
	// Create a fork of the process
	pid_t pid = fork();

	// Error creating fork
	if (pid < 0) {
		fprintf(stderr, "Error creating fork");
		return 1;
	}

	// Child Process
	if (pid == 0) {
		printf("Child: Doing some work... \n");
		// Simulate cpu work
		sleep(2);
		printf("Child: Done! \n");
		// Exit child with status 42
		return 42;
	}
	// Parent Process
	else {
		int status;
		// Wait for child to finish
		pid_t child_pid = wait(&status);

		if (child_pid == -1) {
			fprintf(stderr, "Wait");
			return 1;
		}
		
		printf("Parent: Child with PID %d has fniished. \n", child_pid);
	}

	return 0;
}

int q6() {
	// Create a fork of the process
	pid_t pid = fork();

	if (pid < 0) {
		fprintf(stderr, "Error creating fork");
		return 1;
	}
	// Child Process
	if (pid == 0) {
		printf("Child: Doing some work... \n");
		// Simulate cpu work 
		sleep(2);
		printf("Child: Done! \n");
		// Exit child with status 42
		return 42;
	}
	// Parent Process
	else {
		int status;
		// Wait specifically for the child we forked
		pid_t waited_pid = waitpid(pid, &status, 0);

		if (waited_pid == -1) {
			fprintf(stderr, "waitpid");
			return 1;
		}

		printf("Parent: Child with PID %d has finished. \n", waited_pid);

		if (WIFEXITED(status)) {
			printf("Parent: Child exited with status %d. \n", WEXITSTATUS(status));
		}
		else {
			printf("Parnet: Child did not exit normally. \n");
		}
	}

	return 0;
}

int q7() {
	// Create a fork of the process
	pid_t pid = fork();	

	if (pid < 0) {
		fprintf(stderr, "Error creating fork");
		return 1;
	}

	// Child Process
	if (pid == 0){
		// Close standard output
		close(STDOUT_FILENO);

		// Attempt to print
		printf("Child: this won't be printed to the terminal. \n");
		
		// Attempt to flush the output
		fflush(stdout);

		return 0;
	}
	// Parent Process
	else {
		// Wait for child process to finish
		wait(NULL);
		printf("Parent: Child process has finished. \n");
	}

	return 0;
}

int q8() {
	// pipefd[0] = read end
	// pipefd[1] = write end
	int pipefd[2];

	// Create a pipe
	if (pipe(pipefd) == -1) {
		fprintf(stderr, "Error creating pipe");
		return 1;
	}

	// Fork first child (writer)
	pid_t child1 = fork();

	if (child1 < 0) {
		fprintf(stderr, "Pipe error");
		return 1;
	}

	// Child One writes to the pipe
	if (child1 == 0) {
		// Redirect stdout to write to pipe
		dup2(pipefd[1], STDOUT_FILENO);
		// Close read end
		close(pipefd[0]);
		close(pipefd[1]);

		// Write to stdout (connected to pipe)
		printf("This message is from the child! \n");

		return 0;
	}

	// Fork second child (reader)
	pid_t child2 = fork();

	if (child2 < 0){
		fprintf(stderr, "Pipe error");
		return 1;
	}

	// Child Two reads from the pipe
	if (child2 == 0) {
		// Redirect stdin to read to pipe
		dup2(pipefd[0], STDIN_FILENO);
		// Close write end
		close(pipefd[1]);
		close(pipefd[0]);

		// Read from stdin (connected to pipe)
		char buffer[128];
		while (fgets(buffer, sizeof(buffer), stdin)) {
			printf("Child 2 recieved: %s", buffer);
		}

		return 0;
	}

	// Close both ends of the pipe
	close(pipefd[0]);
	close(pipefd[1]);

	// Wait for both children so pipe is connected
	waitpid(child1, NULL, 0);
	waitpid(child2, NULL, 0);

	printf("Parent: Both children have finished. \n");

	return 0;
}

int help() {
	printf("Available commands: \n");
	printf("   q1   - Question 1 \n");
	printf("   q2   - Question 2 \n");
	printf("   q3   - Question 3 \n");
	printf("   q4   - Question 4 \n");
	printf("   q5   - Question 5 \n");
	printf("   q6   - Question 6 \n");
	printf("   q7   - Quesiton 7 \n");
	printf("   q8   - Question 8 \n");
	printf("   help - Show available commands \n");

}

int main(int argc, char *argv[]) {
	if (argc < 2) {
		printf("Usage: %s <function_name>\n", argv[0]);
		printf("For available commands, use ./a.out help OR ./assign1 help \n");
		return 1;
	}

	if (strcmp(argv[1], "q1") == 0) {
		q1();
	}
	else if (strcmp(argv[1], "q2") == 0) {
		q2();	
	}
	else if (strcmp(argv[1], "q3") == 0) {
                q3();
        }
	else if (strcmp(argv[1], "q4") == 0) {
                q4();
        }
 	else if (strcmp(argv[1], "q5") == 0) {
                q5();
        }
	else if (strcmp(argv[1], "q6") == 0) {
                q6();
        }
	else if (strcmp(argv[1], "q7") == 0) {
                q7();
        }
	else if (strcmp(argv[1], "q8") == 0) {
                q8();
        }
	else if (strcmp(argv[1], "help") == 0) {
		help();		
	}
	else {
		printf("Unknown command, use ./assign1 help \n");
		return 1;
	}

	return 0;
}
