#COMPLETE FINAL PROJECT WITH ALL EXTRA CREDIT OPTIONS
#AUSTIN MELENDEZ
#CSC35-01
#12/9/22

.intel_syntax noprefix
.data

Welcome:
   .ascii "Welcome to the Ultimate Fighter Showdown!\n"
   .ascii "Programmed by Austin Melendez\n\0"
Players:
   .ascii "How many players would you like in the game? (MAX 10 PLAYERS)\n\0"
Target:
   .ascii "\nPlease choose a target for your attack: \0"
Damage:
   .ascii "You just did \0"
Damage2:
   .ascii " damage to your target!\n\n\0"
Wins:
   .ascii "\n\nWins the battle!\n\n\n\n\0"
AttackPrompt:
   .ascii "Which attack do you use against your target? \0"
AttackList:
   .ascii "1.  DOUBLE EYE POKE\n"
   .ascii "2.  FLYING KARATE KICK\n"
   .ascii "3.  SUPERMAN PUNCH\n\0"
AttackFailed:
   .ascii "Oh no! Your attack against the target missed!\n\0"
Whoops:
   .ascii "Looks like your input was INVALID. Try using your brain before answering this time!\n\0"
Art1:
   .ascii "                         __..--.._ \n"
   .ascii "  .....              .--~   .....  `. \n"
   .ascii ".\":    \"`-..  .    .' ..-'\"    :\". ` \n"
   .ascii "` `._ ` _.'`\"(     `-\"'`._ ' _.' ' \n"
   .ascii "     ~~~      `.          ~~~ \n"
   .ascii "              .' \n"
   .ascii "             / \n"
   .ascii "            ( \n"
   .ascii "             ^---' \n\0"
Art2:
   .ascii "                  .=== \n"
   .ascii "                 / __)        _ \n"
   .ascii "                 (  ||_.''.  {_} \n"
   .ascii "       ----       | =/ \\   /' : \n"
   .ascii "                 /\\_~/() \\__.'     ____ \n"
   .ascii "      ----      |_   \\   //  |''''`    |-'8, \n"
   .ascii "         --   _ :  |_ '-[]___/   '.....\\--.O \n"
   .ascii "             {_}'' .'\\ //  |':```` \n"
   .ascii "              '..'   /\\\\_/    `' \n"
   .ascii "                     //|\\ '.._.' \n"
   .ascii "                    // // \n\0"
Art3:
   .ascii "                __________                  __,___/  \", \n"
   .ascii "         ___.--\"          \"\\'.         ____/  1   \\    \", \n"
   .ascii "  ------f\"               // \\\\\\        \\  (1\\ \\    \\     \\ \n"
   .ascii "        |                    |||       /   u       |      \\ \n"
   .ascii "        |                    |||     _ )          /       | \n"
   .ascii "    ----L_-XXX-.             .|'    / U          <        | \n"
   .ascii "               \"\\   -<_____///     \\           6 )       | \n"
   .ascii "                  \\___)     -\"       '.       -.<\"       / \n"
   .ascii "                                      |'.___  |       _. \n"
   .ascii "                                      |     ./     _.\" \n"
   .ascii "                                     /      |\"----\" \n"
   .ascii "                                            \\ \n\0"
Art4:
   .ascii "\n\n\n"
   .ascii " ,adPPYb,d* ,adPPYYba, 88,dPYba,,adPYba,   ,adPPYba, \n"
   .ascii "a8\"    `Y88 \"\"     `Y8 88P'   \"88\"    \"8a a8P_____88 \n"
   .ascii "8b       88 ,adPPPPP88 88      88      88 8PP\"\"\"\"\"\"\"\" \n"
   .ascii "\"8a,   ,d88 88,    ,88 88      88      88 \"8b,   ,aa \n"
   .ascii " `\"YbbdP\"Y8 `\"8bbdP\"Y8 88      88      88  `\"Ybbd8\"' \n"
   .ascii " aa,    ,88 \n"
   .ascii "  \"Y8bbdP\" \n\n"
   .ascii "     ,adPPYba,  8b       d8  ,adPPYba, 8b,dPPYba, \n"
   .ascii "    a8\"     \"8a `8b     d8' a8P_____88 88p'   \"Y8 \n"
   .ascii "    8b       d8  `8b   d8'  8PP\"\"\"\"\"\"\" 88 \n"
   .ascii "    \"8a,   ,a8\"   `8b,d8'   \"8b,   ,aa 88 \n"
   .ascii "     `\"YbbdP\"'      \"8\"      `\"Ybbd8\"' 88 \n\n\n\0"
PlayerList:
   .quad Fedsmoker
   .quad MikeTyson
   .quad BruceLee
   .quad StevenSeagal
   .quad JoeyKeller
   .quad MikeySkeen
   .quad AntTony
   .quad RFarbi
   .quad Spongebob
   .quad SandyCheeks
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
   .quad 100
   .quad 100
   .quad 100
   .quad 100
   .quad 100
   .quad 100
Fedsmoker:
   .ascii "Player 1: FEDSMOKER\n"
   .ascii "\"Hey man, you got any smokes?\"\n"
   .ascii "Health: \0"
MikeTyson:
   .ascii "Player 2: MIKE TYSON\n"
   .ascii "\"I'll bite ya ear off!\"\n"
   .ascii "Health: \0"
BruceLee:
   .ascii "Player 3: BRUCE LEE\n"
   .ascii "\"Be formless, shapeless... like water.\"\n"
   .ascii "Health: \0"
StevenSeagal:
   .ascii "Player 4: STEVEN SEAGAL\n"
   .ascii "\"I've been knowing karate for like... 27 years\"\n"
   .ascii "Health: \0"
JoeyKeller:
   .ascii "Player 5: JOEY KELLER\n"
   .ascii "\"Woah bro! Square up bro! Square up!\"\n"
   .ascii "Health: \0"
MikeySkeen:
   .ascii "Player 6: MIKEY SKEEN\n"
   .ascii "\"I'll rip you apart buddy.\"\n"
   .ascii "Health: \0"
AntTony:
   .ascii "Player 7: ANT TONY\n"
   .ascii "\"Hmmmmmmmmmm\"\n"
   .ascii "Health: \0"
RFarbi:
   .ascii "Player 8: R FARBI\n"
   .ascii "\"I'm a pretty cool guy...\"\n"
   .ascii "Health: \0"
Spongebob:
   .ascii "Player 9: SPONGEBOB\n"
   .ascii "I've run out of character ideas... But at least he knows karate(ish), right?\n"
   .ascii "Health: \0"
SandyCheeks:
   .ascii "Player 10: SANDY CHEEKS\n"
   .ascii "I've run out of character ideas... But at least she really does know karate!\n"
   .ascii "Health: \0"

.text
.global _start

_start:
#SET TEXT COLOR TO BLUE
   mov rdx, 4
   call SetForeColor

#START OF GAME
   lea rdx, Welcome
   call PrintZString

#SET TEXT COLOR TO WHITE
   mov rdx, 7
   call SetForeColor
   lea rdx, Players
   call PrintZString
   call ScanInt
   call CheckPlayers
   mov PlayerTotal, rdx         #Store total num of players
   mov PlayersLeft, rdx
   mov rsi, 0                   #Set current player to 0
   jmp StartGame

StartGame:
#MAKE SURE WE AREN'T GOING OUT OF THE ARRAY
   movq rax, PlayerTotal
   cmp rsi, rax
   jge FixLoop

#CHECK IF MORE THAN 2 PLAYERS ARE ALIVE
   movq rax, PlayersLeft
   cmp rax, 2
   jl EndGame

#CHECK IF CURRENT PLAYER HAS MORE THAN 0 HP
   movq rax, [PlayerHealth + rsi * 8]
   cmp rax, 1
   jge Turn                     #GIVE A TURN IF TRUE
   jmp Skip                     #SKIP PLAYER IF FALSE (DEAD)
   
Skip:
   add rsi , 1
   jmp StartGame

Turn:
#SET TEXT COLOR TO WHITE
   mov rdx, 7
   call SetForeColor

#PRINT PLAYER INFO
   movq rdx, [PlayerList + rsi * 8]
   call PrintZString
   movq rdx, [PlayerHealth + rsi * 8]
   call PrintInt

#CHANGE COLOR TO GREEN FOR QUESTION
   mov rdx, 2
   call SetForeColor

#ASK TARGET
   lea rdx, Target
   call PrintZString
   call ScanInt
   call CheckTarget                    #CHECK IF INPUT IS VALID
   mov rcx, rdx                        #STORE TARGET IN RCX

#CHANGE TEXT COLOR BACK TO WHITE
   mov rdx, 7
   call SetForeColor

#PRINT ATTACK LIST
   lea rdx, AttackList
   call PrintZString

#CHANGE TEXT COLOR BACK TO GREEN
   mov rdx, 2
   call SetForeColor

#ASK ATTACK CHOICE
   lea rdx, AttackPrompt
   call PrintZString
   call ScanInt
   call CheckAttack                   #CHECK IF INPUT IS VALID
   cmp rdx, 1
   je Attack1
   cmp rdx, 2
   je Attack2
   cmp rdx, 3
   je Attack3

Update:
#DISPLAY DAMAGE DONE STORE DAMAGE VALUE IN RAX PLEASEEEEEE
   mov rdx, 1
   call SetForeColor
   lea rdx, Damage
   call PrintZString
   mov rdx, rax
   call PrintInt
   lea rdx, Damage2
   call PrintZString

#UPDATE HEALTH
   movq CurrentPlayer, rsi
   mov rsi, rcx                              #MOVE TARGET INTO RSI
   sub rsi, 1                                #SUB 1 FOR CORRECT INDEX
   sub [PlayerHealth + rsi * 8], rax         #UPDATE HEALTH IN ARRAY
   movq rsi, CurrentPlayer                   #MOVE CURRENTPLAYER BACK TO RSI

#CHECK REMAINING ALIVE PLAYERS
   mov rdi, 0                                #LOOP COUNTER
   mov rax, PlayerTotal
   mov rsi, 0                                #START AT INDEX 0 FOR LOOP
   mov rbx, 0                                #TEMP ALIVE PLAYER COUNTER
   call CountLoop
   mov PlayersLeft, rbx

#CHECK IF LAST PLAYER
   movq rsi, CurrentPlayer
   mov rax, PlayerTotal
   add rsi, 1
   cmp rax, rsi
   je FixLoop
   jmp StartGame

FixLoop:
   mov rsi, 0
   jmp StartGame

CountLoop:
   cmp rdi, rax                             #COMPARE LOOP VALUE TO MAX PLAYER COUNT
   je EndLoop
   movq rcx, [PlayerHealth + rsi * 8]       #GET CURRENT HEALTH OF CURRENT INDEX (PLAYER INDEX)
   cmp rcx, 0
   jg AddCount                              #PLAYER IS ALIVE
   add rdi, 1
   add rsi, 1
   jmp CountLoop

AddCount:
   add rbx, 1
   add rdi, 1
   add rsi, 1
   jmp CountLoop

EndLoop:
   ret

CheckPlayers:                               #INPUT VALIDATION FOR AMOUNT OF PLAYERS
   cmp rdx, 10
   jg ErrorFoundV2
   cmp rdx, 0
   jle ErrorFoundV2
   ret

CheckTarget:                                #INPUT VALIDATION FOR TARGET CHOICE
   movq rax, PlayerTotal
   cmp rdx, rax
   jg ErrorFound
   cmp rdx, 0
   jle ErrorFound
   ret

CheckAttack:                                #INPUT VALIDATION FOR ATTACK CHOICE
   cmp rdx, 4
   jge ErrorFound
   cmp rdx, 0
   jle ErrorFound
   ret
   
ErrorFound:                                 #ERROR IN USER INPUT (TARGET OR ATTACK)
   mov rdx, 6
   call SetForeColor
   lea rdx, Whoops
   call PrintZString
   mov rdx, 7
   call SetForeColor
   jmp Turn

ErrorFoundV2:                               #ERROR IN USER INPUT (STARTING PLAYER AMOUNT)
   mov rdx, 6
   call SetForeColor
   lea rdx, Whoops
   call PrintZString
   mov rdx, 7
   call SetForeColor
   jmp _start

Attack1:
#DOES THE ATTACK LAND? ~10% Chance of missing
   mov rdx, 70
   call Random
   add rdx, 1
   cmp rdx, 8
   jle FailedAttack
   mov rdx, 20           
   call Random                              #GET RANDOM DMG (1-20)
   add rdx, 1                               #+1 FOR 1-20
   mov rax, rdx

#CHANGE TEXT COLOR TO WHITE
   mov rdx, 7
   call SetForeColor
#PRINT ART 1 FOR ATTACK 1
   lea rdx, Art1
   call PrintZString
   jmp Update

Attack2:
#DOES THE ATTACK LAND? ~35% Chance of missing
   mov rdx, 70
   call Random
   add rdx, 1
   cmp rdx, 47
   jge FailedAttack
   mov rdx, 25
   call Random                              #GET RANDOM DMG (15-40)
   add rdx, 16                              #+1 FOR  1-25 THEN +15 FOR DESIRED DMG RANGE
   mov rax, rdx

#CHANGE TEXT COLOR TO WHITE
   mov rdx, 7
   call SetForeColor
#PRINT ART2 FOR ATTACK 2
   lea rdx, Art2
   call PrintZString
   jmp Update

Attack3:
#DOES THE ATTACK LAND? ~85% Chance of missing
   mov rdx, 70
   call Random
   add rdx, 1
   cmp rdx, 60
   jle FailedAttack
   mov rdx, 50
   call Random                              #GET RANDOM DMG (25-75)
   add rdx, 26                              #+1 FOR 1-50 THEN +25 FOR DESIRED DMG RANGE
   mov rax, rdx

#CHANGE TEXT COLOR TO WHITE
   mov rdx, 7
   call SetForeColor
#PRINT ART3 FOR ATTACK 3
   lea rdx, Art3
   call PrintZString
   jmp Update
 
FailedAttack:
#TEXT COLOR TO YELLOW FOR ATTACK MISSED
   mov rdx, 3
   call SetForeColor
   lea rdx, AttackFailed
   call PrintZString
   mov rax, 0
   jmp Update

#IF THERE IS LESS THAN 2 PLAYERS LEFT GAME OVER
#RESET RDI AND RSI FOR THE FOR LOOP TO USE
#CALL WINNERLOOP TO FIND WHO WON
EndGame:
   mov rsi, 0
   mov rdi, 0
   mov rax, PlayerTotal
   call WinnerLoop                             #FIND WHO WON

#SET TEXT COLOR TO CYAN FOR VICTORY
   mov rdx, 6
   call SetForeColor
#PRINT GAMEOVER ART INSTEAD
   lea rdx, Art4
   call PrintZString

#PRINT INFO OF LAST REMAINING PLAYER (FROM WINNERLOOP)
   movq rdx, rbx                               
   call PrintZString
   mov rdx, rcx
   call PrintInt
   lea rdx, Wins
   call PrintZString

#SET TEXT COLOR BACK TO WHITE (THIS IS REDUNDANT BUT IT SETS THE COLOR BACK TO WHITE BEFORE CLOSING)
   mov rdx, 7
   call SetForeColor
   call Exit    #END OF PROGRAM, PROGRAM EXITS HERE




#LOOP THROUGH PLAYER LIST TO FIND WHO IS LAST PERSON WITH > 1 HP (WHO IS WINNER?)
WinnerLoop:                                  
   cmp rdi, rax
   jg EndLoop
   movq rcx, [PlayerHealth + rsi * 8]
   cmp rcx, 1
   jge Winner
   add rsi, 1
   add rdi, 1
   jmp WinnerLoop

#LOAD WINNER INFO INTO RBX TO PRINT
Winner:  
   movq rbx, [PlayerList + rsi * 8]
   jmp EndLoop
