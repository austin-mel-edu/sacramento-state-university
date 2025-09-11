#MATH 64 - HW 2
#Austin Melendez

import math

def welcome():
    print("Enter your name: ");
    n = input();
    print("Welcome " + str(n) + "!\n");

def convert_weight():
    print("Enter your weight in lbs: ");
    w = float(input());
    kg = w / 2.205
    print("Weight in lbs: " + str(w) + " lbs");
    print("Weight in kg: " + str(kg) + " kg");

def gross_pay():
    print("Enter your hours worked: ");
    hrs = float(input());
    print("Enter your pay rate: ");
    pay = float(input());
    gross = hrs * pay
    print("Your gross pay is $" + str(gross));

def gross_pay2():
    print("Enter your hours worked: ")
    hrs2 = float(input())
    print("Enter your pay rate: ")
    pay2 = float(input())
    if (hrs2 <= 40):
        gross2 = hrs2 * pay2            
    elif (hrs2 > 40):
        gross_temp = 40 * pay2
        gross2 = ((hrs2 - 40) * (1.5 * pay2)) + gross_temp
    print("Your gross pay is $" + str(gross2))

def grade():
    print("Enter your score: ");
    score = float(input())
    if (0 > score or score > 1.0):
        print("Error! Enter a valid score from 0.0 to 1.0!\n");
    else:
        if (score >= 0.9):
            print("Score: " + str(score) + "\nGrade: A");
        elif (score >= 0.8):
            print("Score: " + str(score) + "\nGrade: B");
        elif (score >= 0.7):
            print("Score: " + str(score) + "\nGrade: C");
        elif (score >= 0.6):
            print("Score: " + str(score) + "\nGrade: D");
        else:
            print("Score: " + str(score) + "\nGrade: F");

def quadratic_roots():
    print("Enter the coeffecients a, b, c to find the quadratic roots.")
    print("Set: a = ")
    a = float(input())
    print("Set: b = ")
    b = float(input())
    print("Set: c = ")
    c = float(input())
    dis = b ** 2 - 4*a*c

    if dis < 0:
        print("No real roots!")
    else:
        posroot = (-b + math.sqrt(dis)) / (2 * a)
        negroot = (-b - math.sqrt(dis)) / (2 * a)

        print("The roots are:")
        print("Root 1: " + str(posroot))
        print("Root 2: " + str(negroot))
