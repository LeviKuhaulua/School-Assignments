/* C HelloWorld program */
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

int main(int argc, char **argv) {
  time_t current_time;
  char* c_time_string;
 
  current_time = time(NULL);
  c_time_string = ctime(&current_time);
	
  printf("Hello, World! It is %s\n", c_time_string);
  return 0;
}
