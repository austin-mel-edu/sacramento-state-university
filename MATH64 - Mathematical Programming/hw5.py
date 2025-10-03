# MATH 64 HOMEWORK 5
# Austin Melendez

from fractions import Fraction

# QUESTION 1
print("QUESTION 1:")
x = "college is the BEST :)"

# First 10 elements in x
print(x[:11])
# college is

# Elements from 8 to 12 in x
print(x[8:13])
# is the

# Explain methods: count(), zfill(), find()
print(x.count("l"))
# This method counts the number of time the letter "l" appears in the string
# 2

print("25".zfill(4))
# This method adds 2 zeros to the left of the number string "25" making it "0025"
# 0025

print(x.find("s"))
# this method prints the index of the first appearance of the letter "s" in the string
# 9

# QUESTION 2
print("\nQUESTION 2:")
num1 = 2 ** 2000
num1 = str(num1)
total = 0
for i in range(len(num1)):
    total += int(num1[i:i+1])
print(total)
# 2704

# QUESTION 3
print("\nQUESTION 3:")
final_sum = 0
for i in range(1000000):
    if i == sum(int(d) ** 5 for d in str(i)):
        final_sum += i
print(final_sum)
# 443840

# QUESTION 4
# I had no clue the logic behind finding the fractions requested, so I used AI to help me understand the logical steps behind finding what I needed.
print("\nQUESTION 4:")
curious_fractions = []

for numerator in range(10, 100):
    for denominator in range(numerator + 1, 100):  # less than 1 in value
        num_str = str(numerator)
        den_str = str(denominator)

        # Skip trivial examples ending with 0 like 30/50
        if num_str[1] == '0' and den_str[1] == '0':
            continue

        # Try cancelling a common non-zero digit
        for digit in num_str:
            if digit != '0' and digit in den_str:
                new_num_str = num_str.replace(digit, '', 1)
                new_den_str = den_str.replace(digit, '', 1)

                if new_num_str and new_den_str:
                    new_num = int(new_num_str)
                    new_den = int(new_den_str)
                    if new_den != 0:
                        # Check if the "fake cancellation" produces the same fraction
                        if Fraction(numerator, denominator) == Fraction(new_num, new_den):
                            curious_fractions.append((numerator, denominator))

for frac in curious_fractions:
    print(f"{frac[0]}/{frac[1]}")
# 16/64
# 19/95
# 26/65
# 49/98