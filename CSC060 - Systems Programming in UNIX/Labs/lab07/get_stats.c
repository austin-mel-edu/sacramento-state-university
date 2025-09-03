/*----------------------------------------------------------------*/
/* AUSTIN MELENDEZ */
/* get_stats is a function to figure the best time for each       */
/* racer, compute the all-over average of the best times, and     */
/* find the longest time and the shortest time on the track       */

#include "lab7.h"

void get_stats(	driver_t driver_list[NRACERS],  /* in & out */
        stats_t *race_stats )                   /* in & out */
{
    int d, t;  /* driver (row) and time (column) */

    race_stats->average_of_best = 0.0;

    /* initialize the fast and slow times */
    race_stats->winning_time = driver_list[0].tries[0];
    race_stats->slowest_time = driver_list[0].tries[0];

    for (d = 0; d < NRACERS; d++)
    {
        driver_list[d].deviation = 0.0;
        driver_list[d].best_time = driver_list[d].tries[0];
        
        for (t = 0; t < TRIES ; t++){
            if (driver_list[d].tries[t] < driver_list[d].best_time){
                driver_list[d].best_time = driver_list[d].tries[t];
            }
            if (driver_list[d].best_time < race_stats->winning_time){
                 race_stats->winning_time = driver_list[d].best_time; 
            }
            if (driver_list[d].tries[t] > race_stats->slowest_time){
                race_stats->slowest_time = driver_list[d].tries[t];
            }
        }

        race_stats->average_of_best += driver_list[d].best_time;
    }

    /* Compute the average of the best times */
    race_stats->average_of_best /= (double) NRACERS;

    /* Compute the deviation of the best time from the driver's best time */
    for (d = 0; d < NRACERS; d++)
    {
        driver_list[d].deviation = race_stats->winning_time - driver_list[d].best_time;
    }
    return;
}

/*--------------------------------------------------------*/
