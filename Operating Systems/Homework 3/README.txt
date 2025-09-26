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