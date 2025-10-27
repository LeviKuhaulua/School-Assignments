#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

// Defines the myarg_t structure with vars counter and interations
typedef struct {
  int counter;
  int iterations;
} myarg_t;


// function to create a thread and increment that thread's counter
void * thread(void * arg) {
  // Creates the myarg_t thread from arg (type cast arg into myarg_t)
  myarg_t * my_args = (myarg_t *) arg;
  
  // Increment counter based on iterations
  for(int i=0; i<my_args->iterations; i++) {
    my_args->counter++;
  }
  
  // Function is pau
  return NULL;
}


int main(int argc, char ** argv) {

  // Defines # of threads to use
  int num_threads;
  // Creates a myarg_t struct called my_args
  myarg_t my_args;

  
  // Check to see if there are 3 arguments when running ./counter, if not, throw error (1)
  if( argc != 3 ) {
    fprintf(stderr, "Usage: ./counter <number of threads> <number of iterations>\n");
    return 1;
  }
  
  // Gets # of myarg_t threads to use
  num_threads = atoi(argv[1]);
  // Get the # of iterations to go thru
  my_args.iterations = atoi(argv[2]);

  // Array of thread identifiers with length based on # of threads
  pthread_t threads[num_threads];
  // Set counter to my_args thread to 0
  my_args.counter = 0;
  
  // Go thru each thread
  for (int i=0; i<num_threads; i++) {
    // create thread at the address of threads[i] with default attributes
    // Execute the void * thread function with argument myarg_t my_args
    pthread_create(&threads[i], NULL, thread, &my_args);
    // Wait for thread[i] to finish so next thread can take over
    pthread_join(threads[i], NULL);
  }

  // Defines what value the counter should be
  printf("expected counter value: %d\n", my_args.iterations * num_threads);
  // Defines the value of the counter
  printf("counter value: %d\n", my_args.counter);

  // Function done
  return 0;
}
