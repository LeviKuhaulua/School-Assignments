FROM gcc:15.1-bookworm
WORKDIR /homework
RUN apt update
RUN apt-get install -y telnet
RUN apt-get install -y net-tools
COPY . .
RUN make server
CMD [ "./server.exe", "14000" ]