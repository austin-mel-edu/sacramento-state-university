.intel_syntax noprefix
.data

name:
   .byte 'A'
   .byte 'u'
   .byte 's'
   .byte 't'
   .byte 'i'
   .byte 'n'
   .byte ' '
   .byte 'M'
   .byte 'e'
   .byte 'l'
   .byte 'e'
   .byte 'n'
   .byte 'd'
   .byte 'e'
   .byte 'z'
   .byte '\n'
   .byte 0

funds:
   .ascii "How much money do you currently have?\n\0"

expenses:
   .ascii "What are your current expenses?\n\0"

total:
   .ascii "You have :$\0"

count:
   .quad 0

.text
.global _start
_start:
   lea rdx, name
   call PrintZString

   lea rdx, funds
   call PrintZString
   call ScanInt
   mov count, rdx

   lea rdx, expenses
   call PrintZString
   call ScanInt
   sub count, rdx

   lea rdx, total
   call PrintZString
   mov rdx, count
   call PrintInt
   
   call Exit
   
