# AUSTIN MELENDEZ
#makefile for lab7 structs and make  Fall 2023, CSC60

lab7: lab7.o get_data.o get_stats.o get_median.o print_all.o do_sort.o open_out_file.o lab7.h
	gcc lab7.o get_data.o get_stats.o get_median.o print_all.o do_sort.o open_out_file.o -o lab7

lab7.o: lab7.c lab7.h
	gcc -c lab7.c

get_data.o: get_data.c lab7.h
	gcc -c get_data.c

get_stats.o: get_stats.c lab7.h
	gcc -c get_stats.c

get_median.o: get_median.c lab7.h
	gcc -c get_median.c

print_all.o: print_all.c lab7.h
	gcc -c print_all.c

do_sort.o: do_sort.c lab7.h
	gcc -c do_sort.c

open_out_file.o: open_out_file.c lab7.h
	gcc -c open_out_file.c 
