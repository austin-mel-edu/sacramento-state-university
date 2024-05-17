#TEMPERATURE OVER TIME HOMEWORK

year=${1:9:4}

#Station 1 =
station1="EZE00100082"
#Station 2 = 
station2="UK000047811"
#Station 3 = 
station3="ITE00100554"
#Station 4 =
station4="GM000004204"
#Station 5 =
station5="BE000006447"


#SETUP CSV FILE FOR GRAPHING LATER
#echo "station,year,temperature" > station-year-temp.csv

zgrep -e $station1 $1 | zgrep "TMAX" | cut -d, -f4 | sort -n > out$station1$year.txt
python3 -u calcmedian.py $station1$year > median$station1$year.txt
#python3 -u adjustscale.py EZE00100082 > medianEZE00100082$year.txt
echo $station1","$year","$(<median$station1$year.txt) >> station-year-temp.csv

zgrep -e $station2 $1 | zgrep "TMAX" | cut -d, -f4 | sort -n > out$station2$year.txt
python3 -u calcmedian.py $station2$year > median$station2$year.txt
#python3 -u adjustscale.py GM000010962 > medianGM000010962$year.txt
echo $station2","$year","$(<median$station2$year.txt) >> station-year-temp.csv

zgrep -e $station3 $1 | zgrep "TMAX" | cut -d, -f4 | sort -n > out$station3$year.txt
python3 -u calcmedian.py $station3$year > median$station3$year.txt
#python3 -u adjustscale.py GM000010962 > medianGM000010962$year.txt
echo $station3","$year","$(<median$station3$year.txt) >> station-year-temp.csv

zgrep -e $station4 $1 | zgrep "TMAX" | cut -d, -f4 | sort -n > out$station4$year.txt
python3 -u calcmedian.py $station4$year > median$station4$year.txt
#python3 -u adjustscale.py GM000010962 > medianGM000010962$year.txt
echo $station4","$year","$(<median$station4$year.txt) >> station-year-temp.csv

zgrep -e $station5 $1 | zgrep "TMAX" | cut -d, -f4 | sort -n > out$station5$year.txt
python3 -u calcmedian.py $station5$year > median$station5$year.txt
#python3 -u adjustscale.py GM000010962 > medianGM000010962$year.txt
echo $station5","$year","$(<median$station5$year.txt) >> station-year-temp.csv


#HARD CODED VERSION
#zgrep -e "USW00013994" $1 | zgrep "TMAX" | cut -d, -f4 | sort -n > outUSW00013994$year.txt
#python3 -u calcmedian.py USW00013994$year > medianUSW00013994$year.txt
#python3 -u adjustscale.py USW00013994 > medianUSW00013994$year.txt
#echo "USW00013994,"$year","$(<medianUSW00013994$year.txt) >> station-year-temp.csv

rm out$station1$year.txt
rm median$station1$year.txt
rm out$station2$year.txt
rm median$station2$year.txt
rm out$station3$year.txt
rm median$station3$year.txt
rm out$station4$year.txt
rm median$station4$year.txt
rm out$station5$year.txt
rm median$station5$year.txt


