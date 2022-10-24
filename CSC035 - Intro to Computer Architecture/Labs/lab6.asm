#Austin Melendez Lab 6

.intel_syntax noprefix
.data

Answer:
   .quad 0

Greeting:
   .ascii "Welcome to the Ravenclaw tower!\nUse your smarts to guess the number I have created from 1 to 100!\n\0"
Guess:
   .ascii "Guess: \0"
LowNum:
   .ascii "Hmm.. that number is too small!\n\0"
HighNum:
   .ascii "Woah! That numbers is too large!\n\0"
Correct: 
   .ascii "Your brain power really shows! You got it correct! You may now enter.\n\0"

.text
.global _start

_start:
   mov rdx, 100
   call Random            #Generate random number 0-99
   add rdx, 1             #Add one to random number to make it 1-100
   mov Answer, rdx        #Store random number into Answer
   lea rdx, Greeting
   call PrintZString

While:
   lea rdx, Guess
   call PrintZString
   call ScanInt
   cmp rdx, Answer
   jl Low                 #If guess is < answer, jump to Low
   cmp rdx, Answer
   jg High                #If guess is > answer, jump to High
   lea rdx, Correct       #Only runs if answer is correct
   call PrintZString
   call Exit

Low:
   lea rdx, LowNum
   call PrintZString
   jmp While              #Continue running loop

High:
   lea rdx, HighNum
   call PrintZString
   jmp While              #Continue running loop
