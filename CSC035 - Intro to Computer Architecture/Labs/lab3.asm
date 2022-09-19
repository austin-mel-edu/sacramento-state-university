# Austin Melendez Lab 3

.intel_syntax noprefix
.data

Glove:
   .ascii "1. A Rawlings Baseball Glove (99 dollars)\n\0"

Bat:
   .ascii "2. A DeMarini Composite Baseball Bat (650 dollars)\n\0"

WoodenBat:
   .ascii "3. A Louisville Slugger Wooden Baseball Bat (150 dollars)\n\0"

Baseballs:
   .ascii "4. A Bucket of Pearly White Baseballs (110 dollars)\n\0"

Names:
   .quad Glove
   .quad Bat
   .quad WoodenBat
   .quad Baseballs

Costs:
   .quad 99
   .quad 650
   .quad 150
   .quad 110

Question:
   .ascii "Please Enter Your Selection: \0"
   
Selection:
   .ascii "You Have Selected: \0"

Money:
   .ascii "How much money do you have? \0"

Total:
   .ascii " dollars is your change.\0"


.text
.global _start

_start:
#Print Options for the user to select
   lea rdx, Glove
   call PrintZString
   lea rdx, Bat
   call PrintZString
   lea rdx, WoodenBat
   call PrintZString
   lea rdx, Baseballs
   call PrintZString

#Ask for selection
   lea rdx, Question
   call PrintZString
   call ScanInt
   mov rsi, rdx
   sub rsi, 1

#Print Selection
   mov rdx, [Names + rsi * 8]
   call PrintZString
#Ask How much money the user has
   lea rdx, Money
   call PrintZString
   call ScanInt
#Subtract cost of item selected from inputted money
   sub rdx, [Costs + rsi * 8]
   call PrintInt
   lea rdx, Total
   call PrintZString
   

   call Exit 
