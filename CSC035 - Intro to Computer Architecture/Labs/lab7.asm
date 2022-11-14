#Austin Melendez Lab7
.intel_syntax noprefix
.data

Bill:
   .ascii "How much, in dollars, was your bill as a group?\n\0"
Split:
   .ascii "How many people will be splitting the bill between?\n\0"
Final:
   .ascii "Okay everyone, each person needs to pay \0"
Final2:
   .ascii " dollars each please.\n\0"

.text
.global _start

_start:
   lea rdx, Bill
   call PrintZString
   call ScanInt
   mov rbx, rdx             #Store the total bill $ into rbx

Question:
   lea rdx, Split
   call PrintZString
   call ScanInt
   mov rcx, rdx             #Store the number of poeple splitting in rcx
   cmp rcx, 1
   jge Continue
   jmp Question

Continue:
   mov rax, rbx             #Move stored bill total into RAX for Divide (Dividend)   
   cqo
   idiv rcx                 #RCX already stores the divisor (Num of total people splitting)
   lea rdx, Final
   call PrintZString
   mov rdx, rax             #RAX stores the answer to division
   call PrintInt
   lea rdx, Final2
   call PrintZString

   call Exit
