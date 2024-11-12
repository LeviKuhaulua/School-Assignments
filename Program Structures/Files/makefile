program: a18.o getdouble.o
	gcc a18.o getdouble.o -o edit-records -lm
	./edit-records

getdouble.o: getdouble.c getdouble.h
	gcc -c getdouble.c

a18.o: a18.c getdouble.h student.h
	gcc -c a18.c