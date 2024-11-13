program: a18.o getdouble.o
	gcc a18.o getdouble.o stringinput.o -o edit-records -lm
	./edit-records

stringinput.o: stringinput.c stringinput.h
	gcc -c stringinput.c stringinput.h

getdouble.o: getdouble.c getdouble.h
	gcc -c getdouble.c

a18.o: a18.c getdouble.h student.h stringinput.h
	gcc -c a18.c
