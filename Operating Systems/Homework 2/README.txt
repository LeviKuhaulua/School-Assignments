# Homework 2
# Levi Kuhaulua


Part 1

#1: 

Java Program: 3238
C Program: 41

For both programs I used this command: grep -Evc "resume(d)?|exit(ed)?" [TRACEFILE NAME]

I think that the reason why there are so many system calls for Java vs C is that Java has 
more processes that handle different things. For example, Java has its own garbage collection (automatic)
and other specifications for Java like it's strong type safety. C is more barebones and doesn't have as 
much programs or processes for type checking and for garbage collection. 

#2: 

Amount of unique system calls in C program: 15
Amount of unique system calls in Java program: 72

C command: sed -E 's/\(.*\).*//g' out_c | sort -u | wc -l. 

Java command: sed -E 's/^[0-9]+//g' out_java | sed -E 's/[(>].*//g' | sort -u | wc -l

#3: 

Process Management: futex & arch_prctl
Memory Management: mmap & munmap
File System and I/O: read & write
Protection and Security: mprotect & access

Part 2

#1: 4542
#2: 10 system calls
#3: Depends on the read call, but it's usually 8192 bytes for the buffer size. read(3, "The Project Gutenberg EBook of T"..., 8192) = 8192 
#4: 1109
#5: 723 times wget does not get the bytes it wants
#6: wget does not typically fill its buffer
#7: connect(3, {sa_family=AF_INET, sin_port=htons(80), sin_addr=inet_addr("158.106.138.13")}, 16) = 0;  Therefore, IP Address is 158.106.138.13 and port is 80.


#8: 801
#9: 31
#10: wget typically fills it's buffer.
