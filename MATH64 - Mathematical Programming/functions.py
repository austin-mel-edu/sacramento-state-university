# MATH 64 Functions Exercise
# Austin Melendez

from time import sleep

# QUESTION 1
print("\nQUESTION 1:")
def greet(name):
    message = "Hello, " + name + "!"
    return message

print(greet("Austin"))
# Hello, Austin!

# QUESTION 2
print("\nQUESTION 2:")
def add_numbers(a, b):
    total = int(a) + int(b)
    return total

print(add_numbers(10, 20))
# 30

# QUESTION 3
print("\nQUESTION 3:")
def cel_to_far(cel):
    fahrenheit = (cel * 9/5) + 32
    return fahrenheit

print(cel_to_far(20))
# 68.0

#QUESTION 4
print("\nQUESTION 4:")
def countdown(start):
    while start > 0:
        print(start)
        start = start - 1
        sleep(1)
    return "BLASTOFF!"

print(countdown(3))
# 3
# 2
# 1
# BLASTOFF!
    
# QUESTION 5
print("\nQUESTION 5:")
def factorial(n):
    result = 1
    for i in range(1, n + 1):
        result = result * i
    return result

print(factorial(5))
# 120

# LOOPS
print("\nLOOPS:")

for a in range(5):
    print("Python")
# Print "Python" 5 times
# Python
# Python
# Python
# Python
# Python

print("\n")

for b in range(1, 6):
    print(b ** 2)
# Print square for each number 1-5
# 1
# 4
# 9
# 16
# 25

print("\n")

total = 0
for c in range(1, 101):
    total = total + c
print(total)
# 5050