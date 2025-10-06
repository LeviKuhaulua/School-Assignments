
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>


char *const success_msg = "** COMMAND SUCCESSFUL **";
char *const failed_msg = "** COMMAND FAILED **";

/* 
 * A function that executes a command using fork and execv.
 */
void execute_plain(char *cmd, char *const argv[]) {

  // WRITE CODE HERE
  pid_t pid = fork();

  // checks if we can fork
  if (pid == -1) {
    perror("fork()");
    fprintf(stdout, "%s\n", failed_msg);
    exit(1);
  }

  if (!pid) {
    // CHILD
    // put exit status using
    exit(execv(cmd, argv));
  } else {
    // PARENT
    // stores the commands with return value return status here (if I'm reading the man page correctly)
    int returnStatus;
    waitpid(pid, &returnStatus, 0);

    // convert to the exit status of command
    returnStatus = WEXITSTATUS(returnStatus);
    if (!returnStatus) {
      // exit code of command is 0
      fprintf(stdout, "%s\n",  success_msg);
    } else {
      // exit code of command not 0
      fprintf(stdout, "%s\n", failed_msg);
    }
  }

  
}

/* 
 * A function that executes a command using fork and execv, but
 *  that redirects the command's output to a file.
 */
void execute_output_to_file(char *cmd, char *const argv[], char *filename) {

  // WRITE CODE HERE
  FILE *file = fopen(filename, "a+");  
 
  // check if can open file
  if (!file) {
    perror("fopen()");
    fprintf(stdout, "%s\n",  failed_msg);
    exit(1);
  }
 
  pid_t pid = fork();

  // check if can fork
  if (pid == -1) {
    perror("fork()");
    fprintf(stdout, "%s\n",  failed_msg);
    exit(1);
  }

  if (!pid) {
    // CHILD
    // close stdout
    close(1);
    // create stream to file for commands
    dup(file->_fileno);
    exit(execv(cmd, argv));
  } else {
    // PARENT
    int returnStatus;
    waitpid(pid, &returnStatus, 0);

    returnStatus = WEXITSTATUS(returnStatus);
    
    // stdout should work b/c we closed stdout stream in child process not parent
    if (!returnStatus) {
      fprintf(stdout, "%s\n",  success_msg);
    } else {
      fprintf(stdout, "** COMMAND FAILED **\n");
    }
  }
}


/* 
 * A function that executes a command using fork and execv, but
 *  that redirects the command's output to another command.
 */
void execute_output_to_other(char *cmd1, char *const argv1[], char *cmd2_with_argv2) {

  // WRITE CODE HERE
  FILE *pipe = popen(cmd2_with_argv2, "r");

  if (!pipe) {
    perror("popen()");
    fprintf(stdout, "%s\n",  failed_msg);
    exit(1);
  } else {
    // close stdout
    close(1);
    // dup output
    dup(pipe->_fileno);
  }

  if (pclose(pipe) == -1) {
    perror("pclose()");
    fprintf(stdout, "%s\n",  failed_msg);
    exit(1);
  }

}