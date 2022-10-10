#Austin Melendez CSC35-03

.intel_syntax noprefix
.data

Begin:
   .ascii "Ahh welcome to the Great Hall. Which house will you be placed into by the sorting hat?\n\0"

Q1:
   .ascii "Are you a person that seeks glory and power? (y or n)\n\0"

Q2:
   .ascii "Will you do anything to ensure you are the one that rises to power? (y or n)\n\0"

Q3:
   .ascii "Do you believe that knowledge and intelect is above all in importance? (y or n)\n\0"

H:
   .ascii "You would do very well in Hufflepuff. Hurry up and get to the gym lad!\n\0"

R:
   .ascii "You would do very well in Ravenclaw. Go grab your books from the library.\n\0"

G:
   .ascii "You would do very well in Gryffindorr you couragous soul. Go make some friends, they will help you grow!\n\0"

S:
   .ascii "You would do very well in Slytherin. Just remember, no one will help you more than you will help yourself. Trust no one in your climb.\n\0"

.text
.global _start

_start:
   mov rdx, 7
   call SetForeColor
   lea rdx, Begin
   call PrintZString
   lea rdx, Q1           #Ask Power Question
   call PrintZString
   call ScanChar

   cmp dl, 121
   je Q1True              #If 'y' jump to ask Selfish Question (Q2)
   lea rdx, Q3            #If 'n' ask Intellectual Qeustion (Q3)
   call PrintZString      #Ask Intellectual Question
   call ScanChar

   cmp dl, 121
   je Q3True              #If 'y' jump to Q3 Result (Ravenclaw)
   mov rdx, 5
   call SetForeColor
   lea rdx, H             #If 'n' print Q3 False Result (Hufflepuff)
   call PrintZString
   jmp End

Q1True:
   lea rdx, Q2            #Ask Selfish Question
   call PrintZString
   call ScanChar

   cmp dl, 121            
   je Q2True             #If 'y' jump to Q2 Result (Slytherin)
   mov rdx, 1
   call SetForeColor
   lea rdx, G            #If 'n' print Q2 False Result (Gryffindorr)
   call PrintZString
   jmp End

Q2True:
   mov rdx, 2
   call SetForeColor
   lea rdx, S
   call PrintZString
   jmp End

Q3True:
   mov rdx, 4
   call SetForeColor
   lea rdx, R
   call PrintZString
   jmp End

End:
   call Exit
