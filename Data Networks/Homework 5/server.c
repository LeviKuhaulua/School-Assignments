#include <stdio.h>
#include <stdlib.h>
#include <err.h>
#include <errno.h>
#include <unistd.h>
#include <netinet/in.h>
#include <sys/socket.h>

int main(int argc, char *argv[]) {
   if (argc != 2) {
      perror("Must have exactly 1 command-line argument!");
      exit(EXIT_FAILURE);
   }

   char* message = "Connection established. Server Creator: Levi Kuhaulua";

   // Create file descriptor for socket. NOTE: NOT BOUND TO PORT OR IP
   int server_fd = socket(AF_INET, SOCK_STREAM, 0);

   // Create server props: port # and IP Address
   int server_port = atoi(argv[1]);
   struct sockaddr_in server_struct;
   server_struct.sin_family = AF_INET;
   server_struct.sin_port = htons(server_port);
   server_struct.sin_addr.s_addr = htonl(INADDR_LOOPBACK);
   socklen_t addr_length;

   // Actually connects the server props to the socket
   if (bind(server_fd, (struct sockaddr *) &server_struct, sizeof(server_struct)) == -1) {
      perror("Failed to bind socket");
      exit(EXIT_FAILURE);
   }

   printf("Server created at %d\n", server_port);
   
   if (listen(server_fd, 1) == -1) {
      perror("Failed to listen");
      exit(EXIT_FAILURE);
   }

   printf("Server listening at %d\n", server_port);
   
   // Define what to do in client socket
   int client_fd;
   while (1) {
      client_fd = accept(server_fd, NULL, NULL);

      if (client_fd == -1) {
         perror("Unable to accept");
         exit(EXIT_FAILURE);
      }
      printf("Sending %s to client", message);
      send(client_fd, &message, sizeof(message), 0);
      printf("Message Sent! Closing client connection");
      close(client_fd);

   }

   close(server_fd);
   return 0; 
}