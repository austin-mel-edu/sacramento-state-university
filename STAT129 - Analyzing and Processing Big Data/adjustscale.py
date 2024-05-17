import sys

def adjustscale(name):
    year = 1750
    first = 0
    active = True

    filename2 = "median"+name+str(year)+".txt"
    with open(filename2,"r") as file2:
        for i in file2:
            line = file2.readline()
            if line == "":
                break
            if line == "\n":
                break
            else:
                if(line.strip() != -10 and active == True):
                    first = line.strip()
                    active = False
                newvalue = line - first
    year += 1
    if(year < 2025):
        adjustscale(sys.argv[1])
    
    print(newvalue)

if __name__ == "__main__":
    adjustscale(sys.argv[1])
