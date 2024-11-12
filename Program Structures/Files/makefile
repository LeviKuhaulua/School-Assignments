program: a18.o getdouble.o
	gcc a18.o getdouble.o -o a18 -lm
	./a18

getdouble.o: getdouble.c getdouble.h
	gcc -c getdouble.c

a18.o: a18.c getdouble.h student.h
	gcc -c a18.c