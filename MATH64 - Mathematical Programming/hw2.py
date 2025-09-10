#MATH 64 - HW 2
#Austin Melendez


def welcome():
    print("Enter your name: ");
    n = input();
    print("Welcome " + n + "!\n");

def convert_weight():
    print("Enter your weight in lbs: ");
    w = input();
    kg = w / 2.205
    print("Weight in lbs: " + w + " lbs");
    print("Weight in kg: " + kg + " kg");

def gross_pay():
    print("Enter your hours worked: ");
    hrs = float(input());
    print("Enter your pay rate: ");
    pay = float(input());
    gross = hrs * pay
    print("Your gross pay is $" + gross);

def gross_pay2():
    print("Enter your horus worked: ");
    hrs2 = float(input());
    print("Enter your pay rate: ");
    pay2 = float(input());
    if (hrs2 <= 40):
        gross2 = hrs2 * pay2            
    elif (hrs2 > 40):
        gross2 = hrs2 * (pay2 * 1.5)
    print("Your gross pay is $" + gross2);

def grade():
    print("Enter your score: ");
    score = float(input());
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


