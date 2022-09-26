.intel_syntax noprefix
.data

Student: 
   .ascii "Are you currently a student? (1=yes 2=no)\0\n"

Test:
   .ascii "Do you have a test coming up? (1=yes 2=no)\0\n"

Finals:
   .ascii "Is it finals week? (1=yes 2=no)\0\n"

Job:
   .ascii "Do you currently have a job? (1=yes 2=no)\0\n"

Stress:
   .ascii "You total stress level is at: \0"

Okay:
   .ascii "\nYou're doing good! Keep grinding!\n\0"

Crap:
   .ascii "\nOh wow you really are stressed out! Lets get you some magical herbs to calm you down...\n\0"

.text
.global _start

_start:
   lea rdx, Student
   call PrintZString
   call ScanInt
   cmp rdx, 2
   je Question2  #Jump to Q2 if no
   add rcx, 25   #Add 25 stress points if they are a student

Question2:
   lea rdx, Test
   call PrintZString
   call ScanInt
   cmp rdx, 2
   je Question3  #Jump to Q3 if no
   add rcx, 30   #Add 30 stress points if they have a test

Question3:
   lea rdx, Finals
   call PrintZString
   call ScanInt
   cmp rdx, 2
   je Question4   #Jump to Q4 if no
   add rcx, 25       #Add 25 stress points if its finals week

Question4:
   lea rdx, Job
   call PrintZString
   call ScanInt
   cmp rdx, 2
   je End         #Jump to end if no
   add rcx, 15    #Add 15 stress points if they have a job


End:
   lea rdx, Stress
   call PrintZString
   mov rdx, rcx
   call PrintInt
   
   cmp rdx, 65        #compare total to 65
   jge Stressed       #if greater or equal to 65 jump to Stressed
   lea rdx, Okay      #else load Okay message instead
   call PrintZString
   call Exit

Stressed:
   lea rdx, Crap
   call PrintZString
   call Exit
