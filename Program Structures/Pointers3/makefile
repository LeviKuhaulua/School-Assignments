run: program
	./a14 9 / 3
	./a14 9 . 3
	./a14 9 + 3
	./a14 9 - 3

program: a14.o
	gcc a14.o -o a14

a14.o: a14.c
	gcc -c a14.c