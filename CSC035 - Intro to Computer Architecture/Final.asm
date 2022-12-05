#COMPLETE FINAL PROJECT WITHOUT EXTRA CREDIT OPTIONS
.intel_syntax noprefix
.data

Welcome:
   .ascii "Welcome to the Ultimate Fighter Showdown!\n"
   .ascii "Programmed by Austin Melendez\n\0"
Players:
   .ascii "How many players would you like in the game?\n\0"
Target:
   .ascii "\nPlease choose a target for your attack: \0"
Damage:
   .ascii "You just did \0"
Damage2:
   .ascii " damage to your target!\n\0"
GameOver:
   .ascii "Game Over!\n\0"
PlayerList:
   .quad Fedsmoker
   .quad MikeTyson
   .quad BruceLee
   .quad StevenSeagal
PlayerTotal:
   .quad 0
PlayersLeft:
   .quad 0
CurrentPlayer:
   .quad 0
PlayerHealth:
   .quad 100
   .quad 100
   .quad 100
   .quad 100
Fedsmoker:
   .ascii "Player 1: FEDSMOKER\n"
   .ascii "You got any smokes?\n"
   .ascii "Health: \0"
MikeTyson:
   .ascii "Player 2: MIKE TYSON\n"
   .ascii "I'll bite ya ear off\n"
   .ascii "Health: \0"
BruceLee:
   .ascii "Player 3: BRUCE LEE\n"
   .ascii "It's Bruce Lee he doesn't need a catchphrase\n"
   .ascii "Health: \0"
StevenSeagal:
   .ascii "Player 4: STEVEN SEAGAL\n"
   .ascii "I've been knowing karate for like... 27 years\n"
   .ascii "Health: \0"

.text
.global _start
_start:
   lea rdx, Welcome
   call PrintZString
   lea rdx, Players
   call PrintZString
   call ScanInt
   mov PlayerTotal, rdx         #Store total num of players
   mov PlayersLeft, rdx
   mov rsi, 0                   #Set current player to 0
   jmp StartGame

StartGame:
   mov rax, PlayersLeft
   cmp rax, 2
   jle EndGame

   movq rax, [PlayerHealth + rsi * 8]
   cmp rax, 1
   jge Turn
   jmp Skip   
   
Skip:
   add rsi, 1
   jmp StartGame

Turn:
 #PRINT PLAYER INFO
   movq rdx, [PlayerList + rsi * 8]
   call PrintZString
   movq rdx, [PlayerHealth + rsi * 8]
   call PrintInt
 #ASK TARGET
   lea rdx, Target
   call PrintZString
   call ScanInt
   mov rcx, rdx
#GET RANDOM VALUE 1-30
   mov rdx, 30
   call Random
   add rdx, 1
   mov rax, rdx
#DISPLAY DAMAGE DONE
   lea rdx, Damage
   call PrintZString
   mov rdx, rax
   call PrintInt
   lea rdx, Damage2
   call PrintZString
#UPDATE HEALTH
   mov CurrentPlayer, rsi
   mov rsi, rcx
   sub rsi, 1
   sub [PlayerHealth + rsi * 8], rax
   mov rsi, CurrentPlayer
#CHECK REMAINING ALIVE PLAYERS
   mov rdi, 0            #loop counter
   mov rbx, 0            #temp player count
   mov rax, PlayerTotal
   mov rsi, 0
   call CountLoop
   mov PlayersLeft, rbx
#CHECK IF LAST PLAYER
   mov rax, PlayerTotal
   add rsi, 1
   cmp rax, rsi
   je FixLoop
   jmp StartGame

FixLoop:
   mov rsi, 0
   jmp StartGame

CountLoop:
   cmp rdi, rax
   jg EndLoop
   
   movq rcx, [PlayerHealth + rsi * 8]
   cmp rcx, 0
   jg AddCount
   add rdi, 1
   add rsi, 1
   jmp CountLoop

AddCount:
   add rbx, 1
   add rdi, 1
   add rsi, 1
   jmp CountLoop

EndLoop:
   mov rsi, CurrentPlayer
   ret

EndGame:
   lea rdx, GameOver
   call PrintZString
   call Exit
