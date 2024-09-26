run: 
	./dice_game.exe

compile: a08.o getdouble.o
	gcc a08.o getdouble.o -o dice_game -lm

getdouble.o: getdouble.c getdouble.h
	gcc -c getdouble.c

a08.o: a08.c
	gcc -c a08.c
