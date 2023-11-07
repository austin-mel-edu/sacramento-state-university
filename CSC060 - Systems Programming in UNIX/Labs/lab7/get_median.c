/*--------------------------------------------------------*/
/* AUSTIN MELENDEZ                                              */
 
#include "lab7.h"

void get_median(driver_t driver_list[NRACERS] ,
		stats_t *race_stats )
{
    int mid;

    race_stats->median = 0.0;

    mid = NRACERS / 2;
    
    if(NRACERS % 2 == 1){
         race_stats->median = driver_list[mid].best_time;
    }
    else{
        race_stats->median = (driver_list[mid].best_time +  driver_list[mid-1].best_time) / 2;   
    }


    return;
}

/*--------------------------------------------------------*/
