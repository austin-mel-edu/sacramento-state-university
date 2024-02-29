#AUSTIN MELENDEZ - CSC138 - CLIENT

#Import libraries
import socket
import sys
import time

def create_client(svr_ip, svr_port):
    received = 0
    lost = 0
    minRTT = 100
    maxRTT = 0
    totalRTT = 0
    avgRTT = 0
    for pings in range(10):
        cli_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        cli_socket.settimeout(1.0)
        data = "PING " + str(pings)
        start = time.time()
        #received = 0
        #lost = 0
        #minRTT = 0
        #maxRTT = 0
        #totalRTT = 0


        address = (svr_ip, svr_port)
        cli_socket.sendto(data.encode(), address)
        try:
            message, server = cli_socket.recvfrom(1024)
            end = time.time()
            elapsed = end - start
            elapsed = round(elapsed, 4)*1000
            print("Received from server:",{address},{message.decode()}," - RTT ",elapsed," ms")
            received += 1
            totalRTT += elapsed
            if(elapsed < minRTT):
                minRTT = elapsed
            if(elapsed > maxRTT):
                maxRTT = elapsed
        except socket.timeout:
            print("Request time out for", {data})
            lost += 1  
    avgRTT = totalRTT/10
    losspct = (lost/10)*100
    print("Ping Statistics:")
    print("Packets: Sent = 10, Received = ",received,", Lost = ",lost," (",losspct,"% loss)")
    print("RTT Statistics:")
    print("Minimum RTT: ",minRTT," ms, Maximum RTT: ",maxRTT," ms, Average RTT: ",avgRTT," ms")


#Argument checking
def main():
    if len(sys.argv) != 3:
        print("Usage: python3 pingcli.py [SERVER_IP] [SERVER_PORT]")
        sys.exit(1)
    #Seperate IP and Port from inputs.
    svr_ip = sys.argv[1]
    svr_port = int(sys.argv[2])
    create_client(svr_ip, svr_port)

if __name__ == "__main__":
    main()
