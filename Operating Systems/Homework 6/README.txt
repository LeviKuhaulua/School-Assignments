Levi Kuhaulua
ICS 332
Homework #6

Useful Info: 

T_turnaround = T_completion - T_arrival


Exercise 1

Plot execution for at least 34 seconds

Job Mix: 
        Arrival   CPU IO  IO Source
Job A:  0         4   3   Disk 
Job B:  1         5   2   NIC
Job C:  1         3   5   NIC
Job D:  2         2   2   Disk

#1.1: FCFS 

CPU : AAAABBBBBCCCDDAAAABBBBBCCCDDAAAABBBBB
NIC : IIIIIIIIIBBICCCCCIIIIIIBBICCCCCIIIIIIBB
Disk: IIIIAAAIIIIIIIDDIIAAAIIIIIIIDDIIAAAII

#1.2: SJF

CPU : AAAADDCCCBBBBBDDCCCAAAABBBBBDDCCCAAAA
NIC : IIIIIIIIICCCCCBBIIICCCCCIIIIBBIIICCCCC
Disk: IIIAAADDIIIIIIIDDIIIIIAAAIIIIDDIIIIIAAA

#1.3: RR (q=4)

CPU : AAAABBBBCCCDAAAABCCCDDAABBBBCCCDAA
NIC : IIIIIIIIIIICCCCCIBBICCCCCIIIIIICCCCC
Disk: IIIIAAAIIIIIIIIIAAAIIIDDIIIIIIIIDDIIAAAII




Exercise 2:
        Arrival   CPU IO  IO Source
Job A:  0         4   3   Disk 
Job B:  0         1   2   NIC
Job C:  0         2   7   NIC
Job D:  0         10  2   Disk

Lq = 10ms
Hq = 5ms


#2.1:

CPU : AAAABCCDDDAAAABCCDDDAAAABCCDDDAAAABCCDDD
NIC : IIIIIBBCCCCCCCIBBCCCCCCCIBBCCCCCCCIBBCCCCCCC
Disk: IIIIAAAIIIIIIIAAAIIIIIIIAAAAIIIIIIAAAIIIDD


Exercise 3: 
Job mix:

        Arrival   CPU IO  IO Source
Job A:  0         4   4   NIC
Job B:  2         1   2   Disk
Job C:  0         8   1   NIC
Output:

CPU : AAAABCCCBAAAA
NIC : IIIIAAAAIIIII
Disk: IIIIIBBIIBBII

#3.1:
t = 3;  Because Job B arrives with a shorter completion time then it should kick off Job A and run Job B, however that doesn't happen.
t = 5;  After completion of Job B, it should then cycle back to Job A because it has less completion time than Job C.
t = 6+; After (and including) t = 6, these should be Job C running because Job B and Job A should have been completed, therefore focus on completing Job C.
