# Levi Kuhaulua
# Homework 3 

Part 1

Important Info
Zombies - they only stick around until (a) parent dies or (b) parent has acknowledged death

Code Fragment: 
if (!fork()) {
   if (!fork()) {
     char* const arguments[] = {"cp", "./img.jpg", "/tmp/", NULL};
     execv("/bin/cp", arguments);
   }
   exit(0);
} else {
   wait(NULL);
}

# 1: Explain why the main process is not blocked while the cp process is running 

1st Line: if (!fork()) 
Now we have 2 processes, Main and the Child. Since Main will return a number, the if statement is evaluated to false, 
therefore we move onto the else block and from there Main will be blocked until any processes finish. At this point we have
Main, waiting and Child moving onto the second line of the if block

2nd Line: if (!fork())
Child now creates a process and since it returns the pid of it's child, the if statement evaluates to false
therefore we now move onto the next line / execution for Child which is exit(0), and from there because Child has just 
completed, Main has also completed due to having it's child process be completed. 

# 2: Explain why no zombie is left over by this program

There is no zombie because of the following: the first child process is Child (from Main). 
Because the Child then goes to exit(0) (2nd Line in # 1), Main will acknowledge that the child
has terminated, therefore Child is not a Zombie. 

Then there's Child's child, but Child has terminated from exit(0), therefore since the parent process
died, Child's child is not a zombie. 

Part 2

Going to refer to processes by it's pid. Processes will take at least
x amount of seconds depending on order of processes finished. 

Process 42 (Main Process) takes at least 20 seconds to complete

1. pid_t pid = fork();      creates process 11, time = 0
2. if pid > 0               evaluates to true b/c pid = 11, time = 0
3. pid_t pid2 = fork();     creates process 25, time = 0 
4. if pid2 > 0              evaluates to true b/c pid = 25, time = 0
5. sleep(20);               time = 20
6. exit(0);                 terminates 42, time = 20


Process 25 takes 0 seconds to complete

1. pid_t pid2 = fork();     25 is created from parent 42, time = 0
2. if pid2 > 0              evaluates to false b/c pid2 (for 25) is 0, time = 0
3. exit(0);                 terminates 25, time = 0


Process 11 takes at least 50 seconds to complete

1. if pid > 0               evaluates to false b/c pid for 11 is 0, time = 0
2. pid_t pid3 = fork();     creates process 90, time = 0
3. if pid3 == 0             evaluates to false b/c pid3 is 90, time = 0
4. pid_t pid4 = fork();     creates process 123, time = 0
5. if pid4 == 0             evaluates to false b/c pid4 is 123
6. waitpid(pid4, NULL, 0);  have to wait for process 123 to finish which is at least 30 seconds, time = 30 
7. sleep(20);               time = 50
8. printf("** TWO **\n");   prints, time = 50
9. exit(0);                 terminates 11, time = 50


Process 90 takes at least 40 seconds to complete

1. if pid3 == 0             evaluates to true b/c pid3 for 90 is 0, time = 0
2. sleep(40);               time = 40
3. printf("** ONE **\n");   print statement, time = 40
4. exit(0);                 terminates 90, time = 40


Process 123 takes at least 30 seconds to complete

1. if pid4 == 0             evaluates to true b/c pid4 for 123 is 0, time = 0
2. sleep(30);               time = 30
3. exit(0);                 terminates 123, time = 30

#1: ** ONE ** is printed to the terminal in at least 40 seconds
#2: ** TWO ** is printed to the terminal in at least 50 seconds
#3: The pid of the process that prints ** TWO ** is 11
#4: The ppid of Process 90 is 11
#5: Process 123 terminates at 30 second
#6: If line 25 is terminated then it would take 20 seconds
#7: Process that is zombie at the time ** TWO ** is printed is 90
#8: Orphan process is 11
#9: Processes that are alive: 123, 90, 11