#CALC MEDIAN
import sys
import subprocess

#UNUSED FUNCTION I WAS MEESING AROUND WITH
#def gettemp(station,year):
#    first = subprocess.Popen(["zgrep",station,year], stdout=subprocess.PIPE)
#    second = subprocess.Popen(["zgrep","TMAX"], stdin=first.stdout, stdout=subprocess.PIPE)
#    third = subprocess.Popen(["cut","-d,","-f4"], stdin=second.stdout, stdout=subprocess.PIPE)
#    res = third.communicate()[0]
#
#    #/stat129/2020.csv.gz
#    filename = year[9:13] + "out.txt"
#    with open(filename,"w") as sys.stdout:
#        print(res.decode())   
#    #calcmed(filename)

def temptocelcius(temp):
    celcius = temp/10
    return celcius

def adjustscale(data):
    pass

def calcmed(name):
    med = 0
    count = 0
    total = []

    filename = "out"+name+".txt"
    with open(filename,"r") as file:
        for i in file:
            line = file.readline()
            if line == "":
                break
            if line == "\n":
                break
            else:
                total.append(line.strip())
                count += 1
    
    #IF EVEN
    if(count != 0):
        if((count%2) == 0):
            med = ((int(total[int(count/2)]) + int(total[int(count/2)+1]))/2)
        else:
            med = (int(total[int(count/2)])) 
    else:
        med = 0
    
    #print(temptocelcius(med))

if __name__ == "__main__":
    calcmed(sys.argv[1])

