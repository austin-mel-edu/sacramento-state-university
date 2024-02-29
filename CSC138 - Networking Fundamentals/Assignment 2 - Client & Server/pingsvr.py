#AUSTIN MELENDEZ - CSC138 - Server

#Import libraries
import socket
import sys
import random
import time



def create_server(port):
    svr_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    #Binds entered port to the IP address, LOCALHOST (0.0.0.0)
    svr_socket.bind(("0.0.0.0", port))

    #Print server details to screen
    print("Server listening on port :", port)


    message = "PONG"
    #Infitite loop searching for client connection
    while True:

        rand = random.randint(0,10)
        data, address = svr_socket.recvfrom(1024)
        data = data.upper()
        if rand >= 4:
            print("Received from client:",{address}, {data.decode()})
            svr_socket.sendto(message.encode(), address)
        else:
            print("Packet loss! Message dropped.")

#Argument checking
def main():
    if len(sys.argv) != 2:
        print("Usage: python3 pingsvr.py [port]")
        sys.exit(1)

    #Get inputted port value
    port = int(sys.argv[1])
    #Start server
    create_server(port)

if __name__ == "__main__":
    main()


            
