# MATH 64 HOMEWORK 4
# Austin Melendez

# QUESTION 1

#total = 0
#for n in range(10):
#   total + n

# The previous code block has two errors: 
#       To maintain a running sum you must use += instead of +
#       You must use range(1,11) instead of range(10) since the range function is exclusive. range(start, stop + 1)
#       You must print the total value after the loop is done running
total = 0
for n in range(1,11):
    total += n

print(total)
# 55

# QUESTION 2
modsum = 0
for n in range(1,20):
    if (n % 3 == 0):
        modsum -= n
    else:
        modsum += n

print(modsum)
# 64


# QUESTION 3
def fibonacci(n):
    print(0)
    print(1)
    fn1 = 1
    fn2 = 0
    for x in range(n - 1):
        fn = fn1 + fn2
        fn2 = fn1
        fn1 = fn
        print(fn)

# fibonacci(20) [Last number printed is:]
# 6765

# QUESTION 4
def ncubed(n):
    ncube = 0
    for x in range(1, n + 1):
        ncube += (x ** 3)
    print(ncube)
# ncubed(15)
# 14400

# QUESTION 5
def fizzbuzz(n):
    for x in range(1, n + 1):
        if (x % 3 == 0 and x % 5 == 0):
            print("Fizz Buzz")
        elif (x % 3 == 0):
            print("Fizz")
        elif (x % 5 == 0):
            print("Buzz")
        else:
            print(x)

# fizzbuzz(20)
# 1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, Fizz, 19, Buzz

# QUESTION 6
