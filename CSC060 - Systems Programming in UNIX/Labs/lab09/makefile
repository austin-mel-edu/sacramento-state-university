# makefile for lab9                          
# Biel

lab9: lab9.o ParseCmd.o
	gcc lab9.o ParseCmd.o -Wall -o lab9 

lab9.o: lab9.c lab9_10.h
	gcc -c lab9.c -Wall

ParseLine.o: ParseCmd.c lab9_10.h
	gcc -c ParseCmd.c -Wall
			
