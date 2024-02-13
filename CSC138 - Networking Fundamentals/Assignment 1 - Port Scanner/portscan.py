#AUSTIN MELENDEZ - CSC138 - PORT SCANNER

#Import libraries
import socket
import sys

def port_scanner(hostname, protocol, portL, portH):
    if protocol.upper() == "UDP":
        print("Scanning host=" + hostname + ", protocol=" + protocol + ", ports: " + str(portL) + " -> " + str(portH))
        try:
            #SCAN EACH PORT IN RANGE
            for port in range(portL, portH+1):
                udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
                udp_socket.settimeout(1.0)
                address = (hostname, port)
                data = "HELLO!"
                #ATTEMPT TO SEND DATA
                if int(port) == 53:
                    result = dns_query(hostname).decode()
                    if result:
                        print("Port {} is open".format(port) + "     : domain")
                    else:
                        print("Port {} is closed".format(port))
                else:
                    udp_socket.sendto(data.encode(), address)
                    try:
                        #IF VALID RESPONSE
                        message = udp_socket.recvfrom(1024)
                        if (socket.getservbyport(port, protocol.lower()) == "mcreport"):
                            print("Port {} is open".format(port) + "     : svc name unavailable")
                        else:
                            print("Port {} is open".format(port) + "     : " + socket.getservbyport(port, protocol.lower()))
                    #IF TIMEOUT ASSUME PORT IS CLOSED
                    except socket.timeout:
                        print("Port {} is closed".format(port))
                    udp_socket.close()
        except socket.gaierror:
            print("Invalid Hostname! Host: " + hostname + " does not exist!")
        except socket.error:
            print("Socket Error!")
    elif protocol.upper() == "TCP":
        print("Scanning host=" + hostname + ", protocol=" + protocol + ", ports: " +  str(portL) + " -> " + str(portH))
        try:
            #SCAN EACH PROT IN RANGE
            for port in range(portL, portH+1):
                tcp_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                result = tcp_socket.connect_ex((hostname,port))
                #IF 0 NO ERROR FLAG, PORT IS OPEN
                if result == 0:
                    if (socket.getservbyport(port, protocol.lower()) == "mcreport"):
                        print("Port {} is open".format(port) + "     : svc name unavailable")
                    else:
                        print("Port {} is open".format(port) + "      : " + socket.getservbyport(port, protocol.lower()))
                #ELSE PORT IS CLOSED
                else:
                    print("Port {} is closed".format(port))
                tcp_socket.close()
        #INVALID HOSTNAME ENTERED
        except socket.gaierror:
            print("Invalid Hostname! Host: " + hostname + " does not exist!")
        except socket.error:
            print("Socket Error!")
    elif protocol.upper() != "TCP" or protocol.upper() != "UDP":
         print("Invalid protocol: " + protocol + " Specify TCP or UDP")

def dns_query(hostname):
    header = b'\x00\x00\x01\x00\x00\x01\x00\x00\x00\x00\x00\x00'
    question = b''
    for label in hostname.split('.'):
        question += bytes([len(label)]) + label.encode()
    question += b'\x00' #Null terminator for domain name
    question += b'\x00\x01\x00\x01' #Type (A record), Class (IN)
    return header + question


#ARGUMENT VALIDATION
def main():
    if len(sys.argv) != 5:
        print("Usage: python3 portscan.py [hostname] [protocol] [portlow] [porthigh]")
        sys.exit[1]

    hostname = str(sys.argv[1])
    protocol = str(sys.argv[2])
    portL = int(sys.argv[3])
    portH = int(sys.argv[4])
    port_scanner(hostname, protocol, portL, portH)

if __name__ == "__main__":
    main()
