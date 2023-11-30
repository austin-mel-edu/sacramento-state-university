// Austin Melendez

/* ----------------------------------------------------------------- */
/*                  Redirection, part of a child process                */
/* ----------------------------------------------------------------- */

#include "lab9_10.h"

void Redirection(int argc, char *argv[])
{
    int i;	     // loop counter
    int locout = 0;  // track position of location Out redirection, >
    int locin = 0;   // track position of location In redirection, <
    int fd;          // File descriptor
    
    for(i = 0; i < argc; i++)
    {
        if(strcmp(argv[i], ">") == 0) 
        {
            if(locout != 0) 
            {
		        fprintf(stderr, "Cannot output to more than one file.\n");
	        	_exit(EXIT_FAILURE);
            }
            else if (i == 0) 
            {
                fprintf(stderr, "No command entered.\n");
                _exit(EXIT_FAILURE);
            }
            locout = i;
        }
        else if(strcmp(argv[i], "<") == 0){
            if(locin != 0){
                fprintf(stderr, "Cannot input from more than one file!\n");
                _exit(EXIT_FAILURE);
            }
            else if(i == 0){
                fprintf(stderr, "No command entered. \n");
                _exit(EXIT_FAILURE);
            }
            locin = i;
        }
    }

    if(locout != 0){
        if(argv[locout+1] == NULL){
            fprintf(stderr, "There is no file! \n");
            _exit(EXIT_FAILURE);
        }
        fd = open(argv[locout+1], O_RDWR | O_TRUNC | O_CREAT, S_IRUSR | S_IWUSR);
        if(fd == -1){
            perror("Error opening file.\n");
            _exit(EXIT_FAILURE);
        }
        dup2(fd,STDOUT_FILENO);
        if(close(fd) == -1){
            perror("Close file error. \n");
            _exit(EXIT_FAILURE);
        }
        argv[locout] = NULL;
    }

    if(locin != 0){
        if(argv[locin+1] == NULL){
            fprintf(stderr, "There is no file!\n");
            _exit(EXIT_FAILURE);
        }
        fd = open(argv[locin+1], O_RDONLY);
        if(fd == -1){
            perror("Error opening file.\n");
            _exit(EXIT_FAILURE);
        }
        dup2(fd,STDIN_FILENO);
        if(close(fd) == -1){
            perror("Close file error. \n");
            _exit(EXIT_FAILURE);
        }
        argv[locin] = NULL;
    }

}  /*end of function*/

