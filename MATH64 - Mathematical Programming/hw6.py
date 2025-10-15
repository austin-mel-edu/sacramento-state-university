# MATH 64 HOMEWORK 6
# Austin Melendez

# QUESTION 1
x = [10, 20, 30 , 40, 50, 60, "hello"]

# Select 2nd element
print(x[1])
# Select 1st element
print(x[0])
# Select last element
print(x[-1])
# Select first 4 elements
print(x[:4])
# Select last 2 elements
print(x[-2:])
# Select elements in positions 2, 3 & 4
print(x[1:4])
# Every 3rd element
print(x[2])

# QUESTION 2
y = ["A", ["B", "C"], "D"]

# What is the value of y[1]?
# ["B", "C"]
print(y[1])

# QUESTION 3

# The length of y would be 3 because there are 3 elements in the list,
# even if one of the lists is nested, it counts as one element in the parent list.
print(len(y))

# QUESTION 4

# The append method adds an element onto the end of the given list.
x.append("there!")
# The string "there!" should now be the last element in x
print(x[-1])
# Lets show the entire list x
print(x)

# QUESTION 5
def not_multiples(nums, n):
    new_nums = list()
    for i in nums:
        if nums[(i-1)] % n != 0:
            new_nums.append(nums[(i-1)])
    return new_nums

print(not_multiples([1, 2, 3, 4, 5], 2))

# QUESTION 5
def primes(n):
    final = list(range(2,n+1))
    temp = list()
    for i in final:
        temp = not_multiples(final, final[(i-1)])
        for n in temp:
            
        
# []      
print(primes(20))
    
    