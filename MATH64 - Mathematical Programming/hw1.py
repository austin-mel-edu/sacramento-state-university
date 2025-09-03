#MATH 64 - HW 1
#Austin Melendez

#imports
import math


#1
#The following code block will print 2
x = 2
2*x
print(x)

#2
#The following code block will print 6
x = 5
y = 10
print (x + 2 / 2)

#3
#The following code block will print 3
print(1 + 2 ** 3 / 4)

#4
#The following code block will throw an error, you cant start variable names with a number!
x = 5
#2x = 2*2
#print(2x)
print("Error! Invalid variable name. Cannot start with a number.")

#5
#The following code block will throw an error, if is a reserved keyword in python.
#if = 5
#print(5*if)
print("Error! Invalid variable name. Cannot use reserved keywords.")

#6
a = 2
b = 4
c = -4
z = -b + math.sqrt((b ** 2) - (4*a*c))
x = z / 2 * a
print(x)

#7
p = 0.4
k = 3
pxk = ((1 - p) ** (k - 1)) * p
print(pxk)

#8
n = 5
p = 0.25
binom_std = math.sqrt(n * p * (1 - p))
print(binom_std)

#9
i = 2
pmf = 1 / (2 ** i)
print(pmf)

#10
x = 5
sigma = 2
mu = 3
z = -((x - mu) ** 2 / 2 * (sigma ** 2))
pdf = (1 / math.sqrt(2 * math.pi * (sigma ** 2))) * math.exp(z)
print(pdf)
