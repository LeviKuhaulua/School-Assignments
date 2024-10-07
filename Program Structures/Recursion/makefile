run: compile
	./program.exe

compile: a10.o getdouble.o
	gcc a10.o getdouble.o -o program -lm

getdouble.o: getdouble.c getdouble.h
	gcc -c getdouble.c

a10.o: a10.c
	gcc -c a10.c