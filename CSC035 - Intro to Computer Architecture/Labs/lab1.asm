.intel_syntax noprefix
.data
Greeting:
    .ascii "Hello, world!\n\0"
Name:
    .ascii "My name is, Austin!\n\0"
Quote:
    .ascii "I cant think of a quote, so I wrote my own quote\n\0"
Year:
    .ascii "I was born in the year 2003.\n\0"

.text
.global _start

_start: 
    lea rdx, Greeting
    call PrintZString

    lea rdx, Name
    call PrintZString

    lea rdx, Quote
    call PrintZString

    lea rdx, Year
    call PrintZString

    call Exit
