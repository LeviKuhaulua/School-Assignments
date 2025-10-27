CC     = gcc
CFLAGS = -c -Wall

TARGET = counter

all: $(TARGET)

$(TARGET): $(TARGET).o
	$(CC) -o $(TARGET) $(TARGET).o -lpthread

$(TARGET).o: $(TARGET).c
	$(CC) $(CFLAGS) $(TARGET).c 

clean:
	rm $(TARGET) *.o


