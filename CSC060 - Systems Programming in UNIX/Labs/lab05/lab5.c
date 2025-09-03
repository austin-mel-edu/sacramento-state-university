/*-------------------------------------------------*/
/* Austin Melendez                                 */
/* Lab 5                                           */
/* Figure the area of a parabola using data files  */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define IN_FILE_NAME "lab5.dat"
#define OUT_FILE_NAME "lab5.txt"

int main(void)
{
    double nsides, radius, area;
    FILE *infile;
    FILE *outfile;

    // insert the fopen of the data file (lab5.dat) with error checking
    infile = fopen("lab5.dat","r");
    if(infile == NULL){
        printf("ERROR!");
        exit(EXIT_FAILURE);
    }

    // insert the fopen of the output file (lab5.txt) with error checking
    outfile = fopen("lab5.txt","w");
    if(outfile == NULL){
        printf("ERROR!");
        exit(EXIT_FAILURE);
    }


    fprintf(outfile, "\nAustin Melendez.  Lab 5. \n\n");
    fprintf(outfile, "Area of Inscribed Polygons \n\n");
    fprintf(outfile, " Sides    Radius      Area   \n");
    fprintf(outfile, "-------  --------   -------- \n");

    // insert code for:
    //   while loop to read the data,                                
    //     the formula to compute the area,
    //     and the fprintf to print the data line
    while((fscanf(infile,"%lf%lf", &nsides, &radius)) == 2){
        area = 0.5 * nsides * (radius * radius) * sin((2 * M_PI) / nsides);
        fprintf(outfile,"%6.2lf    %6.2lf %10.3lf\n\n",nsides,radius,area);
    }

    // Insert the fclose for both files
    fclose(infile);
    fclose(outfile);
    return EXIT_SUCCESS;
}
/*---------------------------------------------------*/
