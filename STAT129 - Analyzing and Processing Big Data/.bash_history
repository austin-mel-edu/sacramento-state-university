rm station-year-temp.csv
parallel zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173" > station-year-temp.csv
grep "TMAX" station-year-temp.csv | sort -n | uniq
cat station-year-temp.csv 
grep "TMAX" station-year-temp.csv | sort -n > station-year-temp.csv
cat station-year-temp.csv 
rm station-year-temp.csv
parallel zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173" > station-year-temp.csv
cat station-year-temp.csv 
grep "TMAX" station-year-temp.csv > station-year-temp.csv
grep "TMAX" station-year-temp.csv > station-year-tem.csv
ls
cat station-year-tem.csv
grep "TMAX" station-year-temp.csv
clear
parallel zgrep "TMAX" /stat129/csv.gz | zgrep {} /stat129/csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173" 
parallel zgrep "TMAX" /stat129/2023.csv.gz | zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173" 
parallel zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173" | zgrep "TMAX" /stat129/2023.csv.gz
parallel zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173" | zgrep "TMAX" /stat129/2023.csv.gz
parallel --dryrun zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173" | zgrep "TMAX" /stat129/2023.csv.gz
parallel --dryrun zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173"
zgrep "TMAX" /stat129/2023.csv.gz | parallel --dryrun zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173"
zgrep "TMAX" /stat129/2023.csv.gz | parallel zgrep {} /stat129/2023.csv.gz ::: "US1NYNG0022" "US1NYNG0022" "USW00012839" "USC00028998" "US1INMR0173"
ls
rm station-year-tem.csv
rm station-year-temp.csv
zgrep "USC00047851" /stat129/2023.csv.gz | grep "TMAX" | cut -d, -f1,2,4 > station-year-temp.csv
zgrep "US1NYNG0022" /stat129/2023.csv.gz | grep "TMAX" | cut -d, -f1,2,4 >> station-year-temp.csv 
zgrep "USW00012839" /stat129/2023.csv.gz | grep "TMAX" | cut -d, -f1,2,4 >> station-year-temp.csv 
zgrep "USC00028998" /stat129/2023.csv.gz | grep "TMAX" | cut -d, -f1,2,4 >> station-year-temp.csv 
zgrep "US1INMR0173" /stat129/2023.csv.gz | grep "TMAX" | cut -d, -f1,2,4 >> station-year-temp.csv 
ls
cat station-year-temp.csv 
zgrep "US1INMR0173" /stat129/2023.csv.gz | grep "TMAX" | cut -d, -f1,2,4
zgrep "US1INMR0173" /stat129/2023.csv.gz
zgrep "USC00028998" /stat129/2023.csv.gz
cat station-year-temp.csv 
grep "NEW YORK" /stat129/ghcnd-stations.txt 
zgrep "USW00093732" /stat129/2023.csv.gz
zgrep "USW00014786" /stat129/2023.csv.gz
zgrep "US1NYNY0074" /stat129/2023.csv.gz
zgrep "USC00308721" /stat129/2023.csv.gz
grep "LIVERMORE" /stat129/ghcnd-stations.txt 
zgrep "USC00044997" /stat129/2023.csv.gz
grep "ST LOUIS" /stat129/ghcnd-stations.txt 
zgrep "USW00013994" /stat129/2023.csv.gz
zgrep "USW00013994" /stat129/2023.csv.gz | grep "TMAX"
parallel zgrep {} /stat129/csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994"
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994"
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX"
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 | sort -n | uniq
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 | sort -k 2,2 -n | uniq
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 | sort -k 2 | uniq
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 | sort -kn 2 | uniq
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 | sort -n -k2 | uniq
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 | sort -n
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 | sort -k2,2
parallel zgrep {} /stat129/2023.csv.gz ::: "USC00047851" "USC00308721" "USW00012839" "USC00044997" "USW00013994" | grep "TMAX" | cut -d, -f1,2,4 > station-year-temp.csv
cat station-year-temp.csv 
ls
vim clacmedian.py
exit
tmuc
tmux
clear
parallel zgrep {} /stat129/2*.csv.gz ::: "TMAX" | cut -d, -f1,2,3,4,6,7 | grep -w "X"
exit
clear
grep "USW00023234" /stat129/ghcnd-stations.txt 
zgrep "USW0002324" /stat129/2003.csv.gz | grep "20030520"
zgrep "USW0002324" /stat129/2003.csv.gz | zgrep "20030520"
grep "USW0002324" /stat129/2003.csv.gz | grep "20030520"
zgrep
zgrep "USW00023234" /stat129/2003.csv.gz
zgrep "USW00023234" /stat129/2003.csv.gz | zgrep "20030520"
zgrep "USW00023234" /stat129/2003.csv.gz | zgrep "20030520" | zgrep "PRCP"
zgrep "USW00023234" /stat129/2000.csv.gz | zgrep "PRCP" | shuff | head -20
zgrep "USW00023234" /stat129/2000.csv.gz | zgrep "PRCP" | shuf | head -20
clear
zgrep "USW00023234" /stat129/2000.csv.gz | zgrep "PRCP" | shuf | head -20 > rain2000sf.txt
cat rain2000sf.txt
cat /stat129/sf20.txt
zcat /stat129/2020.csv.gz | cut -d, -f3 | uniq
zcat /stat129/2020.csv.gz | cut -d, -f3 | sort | uniq
cat /stat129/sf20.txt
clear
cat /stat129/sf10.txt
comm /stat129/sf10.txt /stat129/sf20.txt
cat /stat129/sf10.txt
cat /stat129/sf20.txt
zcat /stat129/2020.csv.gz | cut -d, -f3 | sort | uniq
zgrep "USW00023234" /stat129/2020.csv.gz | cut -d, -f3 | sort | uniq
zgrep "USW00023234" /stat129/2020.csv.gz | cut -d, -f3 | sort | uniq > sf20.txt
comm sf20.txt /stat129/sf20.txt
clear
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort -m | uniq
zcat /stat129/1995.csv.gz | head
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | uniq
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep " " | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | grep " " | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | grep "" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | grep "D" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | parallel grep {} "D" "G" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | parallel grep {} /stat129/1995.csv.gz "D" "G" | wc -l
clear
zcat /stat129/1995.csv.gz | cut -d, -f6
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | uniq
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "D" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "G" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "I" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "K" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "L" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "M" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "N" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "O" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "R" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "S" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "T" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "W" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "X" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "Z" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | grep "^$" | wc -l
zcat /stat129/1995.csv.gz | cut -d, -f6 | sort | wc -l
clear
parellel zgrep {} /stat129/*.csv.gz ::: "TMAX" | cut -d, -f1,2,3,4,6,7 | grep "X"
parallel zgrep {} /stat129/*.csv.gz ::: "TMAX" | cut -d, -f1,2,3,4,6,7 | grep "X"
parallel --dryrun zgrep {} /stat129/*.csv.gz ::: "TMAX" | cut -d, -f1,2,3,4,6,7 | grep "X"
parallel --dryrun zgrep {} /stat129/2*.csv.gz ::: "TMAX" | cut -d, -f1,2,3,4,6,7 | grep "X"
parallel zgrep {} /stat129/2*.csv.gz ::: "TMAX" | cut -d, -f1,2,3,4,6,7 | grep -w "X"
clear
tmux
zcat /stat129/1995.csv.gz | cut -d, -f 1,2,3,4,6 | grep "TMAX" | grep -w "^$" | sort -n | tail -5
zcat /stat129/1995.csv.gz | cut -d, -f 1,2,3,4,6 | grep "TMAX" | sort -n | tail -5
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | grep "^$" | sort -n | tail -5
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | grep -w "^$" | sort -n | tail -5
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -5
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | grep "^$" | tail -20
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | grep -w "^$" | tail -5
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | grep "^$" | tail -5
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | grep "^$" | tail -30
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -30
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -50
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -80
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | grep '^[[:blank:]]*$' | sort -n
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -150
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -200
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -250
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -350
zcat /stat129/1995.csv.gz | grep "TMAX" | cut -d, -f 4,6 | sort -n | tail -350Sexit
exit
clear
ls
vim tempovertime.sh
vim calcmedian.py
ls
vim calcmedian.py
python3 calcmedian.py 2
vim calcmedian.py
python3 calcmedian.py 2
vim calcmedian.py
python3 calcmedian.py 2
vim calcmedian.py
python3 calcmedian.py 2
vim calcmedian.py
python3 calcmedian.py 2
python3 calcmedian.py [2,3,4]
vim calcmedian.py
python3 calcmedian.py [2,3,4]
vim calcmedian.py
python3 calcmedian.py [2,3,4]
vim calcmedian.py
python3 calcmedian.py [2,3,4]
vim calcmedian.py
python3 calcmedian.py [2,3,4]
python3 calcmedian.py 234567
python3 calcmedian.py 23456
vim calcmedian.py
python3 calcmedian.py 23456
vim calcmedian.py
python3 calcmedian.py 23456
vim calcmedian.py
python3 calcmedian.py 23456
vim calcmedian.py
vim tempovertime.sh
bash tempovertime.sh test
vim tempovertime.sh 
bash tempovertime.sh test
bash tempovertime.sh
vim tempovertime.sh 
bash tempovertime.sh
vim tempovertime.sh 
bash tempovertime.sh
vim tempovertime.sh 
bash tempovertime.sh
vim tempovertime.sh 
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
clear
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
ls
rm clacmedian.py
vim calcmedian.py 
exit
clear
ls
vim tempovertime.sh 
bash tempovertime.sh test
vim tempovertime.sh 
bash tempovertime.sh test
cat testout.txt
clear
ls
vim calcmedian.py 
python3 calcmedian.py testout.txt
vim calcmedian.py 
python3 calcmedian.py testout.txt
vim calcmedian.py 
python3 calcmedian.py testout.txt
vim calcmedian.py 
python3 calcmedian.py testout.txt
vim calcmedian.py 
python3 calcmedian.py testout.txt
vim calcmedian.py 
python3 calcmedian.py testout.txt
python3 calcmedian.py
vim calcmedian.py 
vim tempovertime.sh 
bash tempovertime.sh
vim tempovertime.sh 
bash tempovertime.sh
vim tempovertime.sh 
vim calcmedian.py 
vim calcmedian.py "USC00308721" /stat129/2020.csv.gz
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
ls
rm testout.txt
ls
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
ls
cat testout.txt
clear
ls
vim calcmedian.py 
rm testout.txt
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
ls
rm testout.txt
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
rm testout.txt
vim calcmedian.py 
cat testout.txt
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
cat testout.txt 
clear
rm testout.txt
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
rm testout.txt
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
cat testout.txt
:wq
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
clear
ls
rm testout.txt
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
ls
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim calcmedian.py 
ls
rm testout.txt
python3 calcmedian.py "USC00308721" /stat129/201*.csv.gz
ls
cat 2010out.txt
cat 2010out.txt 
rm 2010out.txt 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
ls
cat 2020out.txt 
clear
exit
clear
ls
rm 2020out.txt
vim calcmedian.py 
python3 calcmedian.py "USC00308721" /stat129/2020.csv.gz
vim tempovertime.sh
vim calcmedian.py 
vim tempovertime.sh
vim calcmedian.py 
python3 calcmedian.py
vim calcmedian.py 
python3 calcmedian.py
ls
rm 2020out.txt
ls
clear
bash tempovertime.sh "USC00308721" /stat129/2020.csv.gz

ls
cat testout.txt
cat median.txt
clear
vim calcmedian.py
vim tempovertime.sh
bash tempovertime.sh "USC00308721" 2020
vim tempovertime.sh
bash tempovertime.sh "USC00308721" 2020
vim tempovertime.sh
bash tempovertime.sh "USC00308721" 2020
ls
cat tester.txt
vim tempovertime.sh
bash tempovertime.sh "USC00308721" 2020
cat tester.txt
rm tester.txt
ls
rm median.txt
rm testout.txt
ls
vim tempovertime.sh
bash tempovertime.sh "USC00308721" *
vim tempovertime.sh
parellel {} bash tempovertime.sh "USC00308721" -e ::: [*]
parallel {} bash tempovertime.sh "USC00308721" -e ::: [*]
parallel ::: bash tempovertime.sh "USC00308721" *
parallel --dryrun ::: bash tempovertime.sh "USC00308721" *
parallel --dryrun {} bash tempovertime.sh "USC00308721" ::: a
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: a
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: *
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: [*]
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: -e [*]
parallel --dryrun -e bash tempovertime.sh "USC00308721" {} ::: [*]
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: [1-9]
parallel --dryrun -e bash tempovertime.sh "USC00308721" {} ::: [1-9]
parallel --dryrun -e bash tempovertime.sh "USC00308721" {} ::: -e [1-9]
parallel --dryrun bash tempovertime.sh "USC00308721" {.} ::: [1-9]
parallel --dryrun bash tempovertime.sh "USC00308721" {.} ::: 1800 2000
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: 1800 2000
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: [*]
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: "*"
vim tempovertime.sh
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: "*"
parallel bash tempovertime.sh "USC00308721" {} ::: "*"
ls
rm median.txt
rm tester.txt
rm testout.txt
vim tempovertime.sh
parallel bash tempovertime.sh "USC00308721" {
cat tester.txt
cat median.txt
vim tempovertime.sh
clear
vim tempovertime.sh
vim calcmedian.py 
vim tempovertime.sh
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2003
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2003
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2003
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2003
ls
cat tester.txt
cat median.txt
rm median.txt
rm tester.txt
rm restout.txt
rm testout.txt
ls
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2002
ls
vim tempovertime.sh 
clear
ls
rm tester.txt
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2002
ls
cat tester.txt
vim tempovertime.sh 
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2002
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2002
ls
vim calcmedian.py 
rm medianUSC00308721200.txt
ls
vim tempovertime.sh 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000 2001 2002
parallel bash tempovertime.sh "USC00308721" {} ::: 2000
vim calcmedian.py 
ls
vim tempovertime.sh 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000
ls
cat outUSC003087212000.txt 
cat medianUSC003087212000.txt 
cat tester.txt
rm tester.txt
rm outUSC003087212000.txt 
rm medianUSC003087212000.txt 
vim tempovertime.sh 
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000
ls
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000
ls
cat medianUSC003087212000.txt 
rm medianUSC003087212000.txt 
rm outUSC003087212000.txt 
rm tester.txt
ls
vim calcmedian.py 
vim tempovertime.sh 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000
ls
cat medianUSC003087212000.txt 
cat outUSC003087212000.txt 
vim tempovertime.sh 
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000
vim calcmedian.py 
parallel bash tempovertime.sh "USC00308721" {} ::: 2000
ls
vim calcmedian.py 
ls
cat tester.txt
rm tester.txt
vim calcmedian.py 
bash tempovertime.sh "USC00308721" 2000
ls
cat tester.txt
rm tester.txt
vim calcmedian.py 
vim tempovertime.sh 
bash tempovertime.sh "USC00308721" 2000
ls
cat outUSC003087212000.txt 
rm outUSC003087212000.txt 
vim tempovertime.sh 
ls
rm tester.txt
bash tempovertime.sh "USC00308721" 2000
ls
cat outUSC003087212000.txt 
rm outUSC003087212000.txt 
vim tempovertime.sh 
bash tempovertime.sh "USC00308721" 2000
ls
cat outUSC003087212000.txt 
rm outUSC003087212000.txt 
vim tempovertime.sh 
zgrep "USC00308721" /stat129/2020.csv.gz | grep "TMAX
zgrep "USC00308721" /stat129/2020.csv.gz | grep "TMAX" | cut -d, -f4
zgrep "USC00308721" /stat129/2020.csv.gz | grep "TMAX" | cut -d, -f4 > out.txt
clear
ls
cat out.txt
clear
rm out.txt
bash tempovertime.sh "USC
bash tempovertime.sh "USC00308721" 2020
ls
cat outUSC003087212020.txt 
clear
ls
rm outUSC003087212020.txt 
vim tempovertime.sh 
bash tempovertime.sh "USC00308721" 2020
ls
cat outUSC003087212020.txt 
clear
cat medianUSC003087212020.txt 
ls
clear
ls
vim tempovertime.sh 
ls
vim tempovertime.sh 
ls
rm outUSC003087212020.txt 
rm medianUSC003087212020.txt 
bash tempovertime.sh "USC00308721" 2020
ls
cat tester.txt
exit
clear
ls
cat tester.txt
rm tester.txt
vim tempovertime.sh 
zgrep "USC00047851" /stat129/*.csv.gz | grep "TMAX" | cut -d, -f1,2,4
vim tempovertime.sh 
bash tempovertime.sh "USC00308721" /stat129/*.csv.gz
vim tempovertime.sh 
man zgrep
vim tempovertime.sh 
bash tempovertime.sh "USC00308721" /stat129/*.csv.gz
bash tempovertime.sh /stat129/*.csv.gz
bash tempovertime.sh test /stat129/*.csv.gz
vim tempovertime.sh 
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: 2000
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: /stat129/*.csv.gz
vim
vim tempovertime
vim tempovertime.sh
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: /stat129/*.csv.gz
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: /stat129/200*.csv.gz
parallel bash tempovertime.sh "USC00308721" {} ::: /stat129/200*.csv.gz
parallel --dryrun bash tempovertime.sh "USC00308721" {} ::: /stat129/200*.csv.gz
vim tempovertime.sh
ls
cat outtest.txt
rm outtest*.txt
ls
rm outU*.txt
ls
rm tester.txt
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/*.csv.gz
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/*.csv.gz
vim tempovertime.sh
YEAR=hi
echo YEAR
echo #YEAR
echo $YEAR
bash tempovertime.sh "USC00308721" /stat129/2020.csv.gz
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/2020.csv.gz
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/2020.csv.gz
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/2020.csv.gz
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/2020.csv.gz
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/2020.csv.gz
ls
rm out*.txt
ls
vim tempovertime.sh
bash tempovertime.sh "USC00308721" /stat129/200*.csv.gz
ls
vim tempovertime.sh
ls
clear
bash tempovertime.sh "USC00308721" /stat129/200*.csv.gz
ls
cat outUSC003087212000.txt 
cat medianUSC003087212000.txt 
rm outUSC003087212000.txt 
rm medianUSC003087212000.txt 
vim tempovertime.sh
vim calcmedian.py 
vim tempovertime.sh
ls
bash tempovertime.sh "USC00308721" /stat129/200*.csv.gz
ls
cat outUSC003087212000.txt 
rm outUSC003087212000.txt 
rm medianUSC003087212000.txt 
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2000.csv.gz
ls
cat outUSC003087212000.txt 
cat medianUSC003087212000.txt 
vim tempovertime.sh
ls
rm outUSC003087212000.txt 
rm medianUSC003087212000.txt 
bash tempovertime.sh "USC00308721" /stat129/2000.csv.gz
cat outUSC003087212000.txt 
ls
rm outUSC003087212000.txt 
zgrep "USC00308721" /stat129/2000.csv.gz | grep "TMAX" | cut -d, -f1,2,4
zgrep "USC00308721" /stat129/2023.csv.gz | grep "TMAX" | cut -d, -f1,2,4
ls
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
cat outUSC003087212023.txt 
ls
rm outUSC003087212023.txt 
vim calcmedian.py 
clear
ls
cat tester.txt
clear
rm tester.txt
ls
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
cat outUSC003087212023.txt 

rm outUSC003087212023.txt 
vim tempovertime.sh 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim tempovertime.sh 
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim tempovertime.sh 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
cat outUSC003087212023.txt 
clear
ls
cat medianUSC003087212023.txt 
rm medianUSC003087212023.txt 
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
cat medianUSC003087212023.txt 
rm outUSC003087212023.txt 
rm medianUSC003087212023.txt 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
cat outUSC003087212023.txt 
clear
cat medianUSC003087212023.txt 
ls
rm outUSC003087212023.txt 
rm medianUSC003087212023.txt 
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
cat medianUSC003087212023.txt 
cat outUSC003087212023.txt 
clear
ls
rm outUSC003087212023.txt 
rm medianUSC003087212023.txt 
vim calcmedian.py 
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
cat medianUSC003087212023.txt 
vim calcmedian.py 
ls
rm medianUSC003087212023.txt 
cat outUSC003087212023.txt 
clear
ls
python3 calcmedian.py outUSC003087212023.txt 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
ls
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
vim calcmedian.py 
python3 calcmedian.py USC003087212023
ls
rm outUSC003087212023.txt 
ls
rm tester.txt
ls
clear
ls
bash tempovertime.sh "USC00308721" /stat129/2023.csv.gz
ls
cat outUSC003087212023.txt 
cat medianUSC003087212023.txt 
ls
clear
ls
vim tempovertime.sh 
cat tester.txt
rm tester.txt
clear
ls
rm outUSC003087212023.txt 
rm medianUSC003087212023.txt 
clear
ls
vim tempovertime.sh 
ls
cd /stat129
ls
zcat 1800.csv.gz 
clear
cd
zcat 1800.csv.gz | cut -d, -f1 > test1.txt
zcat /stat129/1800.csv.gz | cut -d, -f1 > test1.txt
zcat /stat129/2000.csv.gz | cut -d, -f1 > test2.txt
comm test1.txt test2.txt
clear
diff test1.txt test2.txt
diff -s test1.txt test2.txt
diff -c test1.txt test2.txt
man comm
comm -1 -2 test1.txt test2.txt
zcat /stat129/2000.csv.gz | cut -d, -f1 | sort > test2.txt
zcat /stat129/1800.csv.gz | cut -d, -f1 | sort > test1.txt
cat test1.txt
clear
zcat /stat129/1800.csv.gz | cut -d, -f1 | sort | uniq > test1.txt
zcat /stat129/2000.csv.gz | cut -d, -f1 | sort | uniq > test2.txt
comm -1 -2 test1.txt test2.txt
ls
rm test1.txt
rm test2.txt
rm tester.txt
ls
bash tempovertime.sh "EZE00100082" /stat129/2000.csv.gz
ls
cat tester.txt 
clear
ls
bash tempovertime.sh "EZE00100082" /stat129/200*.csv.gz
ls
cat tester.txt
rm tester.txt
bash tempovertime.sh "EZE00100082" /stat129/200*.csv.gz
ls
cat tester.txt 
rm tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
ls
cat tester.txt
rm tester.txt
vim calcmedian.py 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
cat tester.txt
bash tempovertime.sh "EZE00100082" /stat129/2008.csv.gz
ls
cat tester.txt 
zcat /stat129/2008.csv.gz | grep "EZE00100082" | grep "TMAX"
zcat /stat129/2004.csv.gz | grep "EZE00100082" | grep "TMAX"
zcat /stat129/2000.csv.gz | grep "EZE00100082" | grep "TMAX"
cat tester.txt
vim calcmedian.py 
ls
rm tester.txt
bash tempovertime.sh "EZE00100082" /stat129/2008.csv.gz
ls
cat tester.txt
rm tester.txt
bash tempovertime.sh "EZE00100082" /stat129/2000.csv.gz
ls
cat tester.txt
clear
rm tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
vim calcmedian.py 
clear
ls
cat tester.txt
rm tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
cat tester.txt
vim calcmedian.py 
rm tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
rm tester.txt
vim calcmedian.py 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
cat tester.txt
vim calcmedian.py 
clear
ls
rm tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
rm tester.txt
vim calcmedian.py 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
cat tester.txt
clear
rm tester.txt
vim calcmedian.py 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
vim calcmedian.py 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
cat tester.txt
rm tester.txt
clear
ls
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/200*.csv.gz
cat tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/2008.csv.gz
cat tester.txt
zgrep "EZE00100082" /stat129/2008.csv.gz | zgrep "TMAX"
zgrep "EZE00100082" /stat129/2005.csv.gz | zgrep "TMAX"
zgrep "EZE00100082" /stat129/2005.csv.gz | zgrep "TMAX" | wc -l
vim calcmedian.py 
vim tempovertime.sh 
clear
ls
rm tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/20*.csv.gz
cat tester.txt
vim calcmedian.py 
clear
rm tester.txt
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/20*.csv.gz
cat tester.txt
zgrep "EZE00100082" /stat129/2010.csv.gz | zgrep "TMAX"
clear
rm tester.txt
zgrep "EZE00100082" /stat129/*.csv.gz | zgrep "TMAX"
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
clear
ls
cat tester.txt
clear
cat tester.txt

ls
vim calcmedian.py 
rm tester.txt
ls
vim tempovertime.sh 
ls
clear
ls
vim calcmedian.py 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
ls
cat station-year-temp.csv
clear
cat station-year-temp.txt
clear
vim calcmedian.py 
clear
rm station-year-temp.txt
rm station-year-temp.csv
vim tempovertime.sh 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
ls
cat station-year-temp.csv 
vim calcmedian.py 
clear
ls
rm station-year-temp.csv 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
vim calcmedian.py 
rm station-year-temp.csv 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
clear
cat station-year-temp.csv 
clear
ls
rm station-year-temp.csv 
vim tempovertime.sh 
cp tempovertime.sh stat129
cp calcmedian.py stat129
cd stat129
git status
git add calcmedian.py 
git add tempovertime.sh 
git commit
git push
git status
cd
clear
ls
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
ls
rm station-year-temp.csv 
parallel bash tempovertime.sh "USW00012839" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
clear
rm station-year-temp.csv 
parallel bash tempovertime.sh "USC00308721" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
clear
rm station-year-temp.csv 
parallel bash tempovertime.sh "USW00013994" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
clear
parallel bash tempovertime.sh "GM000010962" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
rm station-year-temp.csv 
clear
parallel bash tempovertime.sh "ITE00100554" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
clear
rm station-year-temp.csv 
parallel bash tempovertime.sh "EZE00100082
" {} ::: /stat129/*.csv.gz
cd /stat129
ls
cd
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
clear
grep "ITE00100554" /stat129/ghcnd-stations.txt 
grep "EZE00100082" /stat129/ghcnd-stations.txt 
grep "GM000010962" /stat129/ghcnd-stations.txt 
grep "ITE00100554" /stat129/ghcnd-stations.txt 
clear
ls
rm station-year-temp.csv 
parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
parallel bash tempovertime.sh "ITE00100554" {} ::: /stat129/*.csv.gz
parallel bash tempovertime.sh "GM000010962" {} ::: /stat129/*.csv.gz
parallel bash tempovertime.sh "USW00012839" {} ::: /stat129/*.csv.gz
parallel bash tempovertime.sh "USW00013994" {} ::: /stat129/*.csv.gz
cat station-year-temp.csv 
clear
ipython
/opt/anaconda/bin/ipython
clear
cat station-year-temp.csv 
clear
vim station-year-temp.csv 
clear
/opt/anaconda/bin/ipython
ls
cp year-temp.pdf
cp year-temp.pdf stat129
cd stat129
git add year-temp.pdf 
git "tempovertime pdf" commit
git commit
git push
git status
clear
time parallel bash tempovertime.sh "EZE00100082" {} ::: /stat129/*.csv.gz
time parallel bash tempovertime.sh "ITE00100554" {} ::: /stat129/*.csv.gz
time parallel bash tempovertime.sh "GM000010962" {} ::: /stat129/*.csv.gz
time parallel bash tempovertime.sh "USW00012839" {} ::: /stat129/*.csv.gz
time parallel bash tempovertime.sh "USW00013994" {} ::: /stat129/*.csv.gz
exit
clear
ls
rm outEZE00100082.txt 
rm medianEZE00100082.txt 
ls
clear
ls
vim tempovertime.sh 
clear
l
ls
cat station-year-temp.csv 
clear
ls
ls -a
clear
ls -a 
;ev
ajve
sclear
cear
clear
ls
vim tempovertime.sh 
cp /stat129/stat129-spring24/grep* ~
ls
exit
clear
ls
vim tempovertime.sh 
parallel --dryrun bash tempovertime.sh "ITE00100554|EZE00100082" {} ::: /stat129/*.csv.gz
vim tempovertime.sh 
clear
parallel --dryrun bash tempovertime.sh ::: /stat129/*.csv.gz
clear
ls
rm station-year-temp.csv 
ls
parallel bash tempovertime.sh ::: /stat129/*.csv.gz
ls
rm median*.txt
ls
rm out*.txt
ls
clear
ls
vim tempovertime.sh
clear
ls
cat station-year-temp.csv 
clear
rm station-year-temp.csv 
ls
parallel bash tempovertime.sh ::: /stat129/*.csv.gz
ls
cat station-year-temp.csv 
clear
rm station-year-temp.csv 
vim tempovertime.sh 
vim calcmedian.py 
vim tempovertime.sh
vim calcmedian.py 
vim tempovertime.sh
vim calcmedian.py 
vim adjustscale.py
vim calcmedian.py 
vim adjustscale.py
vim calcmedian.py 
vim tempovertime.sh
vim adjustscale.py
vim calcmedian.py 
vim adjustscale.py
vim tempovertime.sh
vim adjustscale.py
vim tempovertime.sh
vim adjustscale.py
vim tempovertime.sh
ls
parallel bash tempovertime.sh ::: /stat129/*.csv.gz
ls
rm median*.txt
rm out*.txt
clear
ls
vim adjustscale.py 
parallel bash tempovertime.sh ::: /stat129/*.csv.gz
clear
ls
rm median*.txt
rm out*.txt
vim adjustscale.py 
ls
clear
parallel bash tempovertime.sh ::: /stat129/200*.csv.gz
clear
rm median*.txt
ls
rm station-year-temp.csv 
ls
vim adjustscale.py 
parallel bash tempovertime.sh ::: /stat129/200*.csv.gz
clear
ls
cat station-year-temp.csv 
rm station-year-temp.csv 
vim adjustscale.py 
parallel bash tempovertime.sh ::: /stat129/200*.csv.gz
ls
cat medianITE001005541750.txt 
rm median*.txt
rm out*.txt
ls
vim adjustscale.py 
clear
parallel bash tempovertime.sh ::: /stat129/*.csv.gz
ls
rm median*.txt
rm out*.txt
ls
rm station-year-temp.csv 
ls
vim adjustscale.py 
clear
ls
parallel bash tempovertime.sh ::: /stat129/*.csv.gz
lw
ls
rm median*.txt
rm out*.txt
cd /stat129
ls
cd
vim adjustscale.py 
vim tempovertime.sh
clear
ls
rm station-year-temp.csv 
ls
time parallel bash tempovertime.sh ::: /stat129/*.csv.gz
cat tempovertime.sh 
exit
clear
la
ls
cd /stat129
ls
cd tax
ls
xmllint --xpath "//IRS990/RevenueAmt" /stat129/tax/b.xml
vim b.xml
xmllint --xpath "Return/ReturnData/IRS990//RevenueAmt" /stat129/tax/b.xml
cd
/opt/anaconda/bin/ipython
exit
clear
ls
/opt/anaconda/bin/ipython3
cd /stat129
ls
cd tax
ls
cd
vim /stat129/tax/b.xml
xmllint --xpath "//IRS990/ProgSrvcAccomActy2Grp/RevenueAmt" /stat129/tax/b.xml
/opt/anaconda/bin/ipython3
ls
vim nonprofits.py
cd /stat129
ls
cd /stat129/stat129-spring24
ls
cd python
ls
cd .
ls
cd ..
ls
cat xpath.py
cat xpath-a.py
cat xpath-a.sh
cat xpath-b.sh
cat xpath-simple.sh
cd
ls
vim nonprofits.py 
clear
/opt/anaconda/bin/ipython3
vim nonprofits.py 
python3 nonprofits.py 
vim nonprofits.py 
python3 nonprofits.py
exit
clear
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
cd /stat129
ls
cd data
ls
cd ..
cd tax
ls
vim b.xml
vim nonprofits.py 
cd
vim nonprofits.py 
tmux
clear
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
clear
ls
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
clear
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
exit
clear
ls
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
vim b.xml
vim /stat129/tax/b.xml
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
vim /stat129/tax/b.xml
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
clear
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
exit
clear
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py 
ls
vim nonprofits.py 
ls
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
ls
cd stat129
ls
cd
cp nonprofits.pdf stat129/
ls
cp stat129
ls
cd stat129
ls
git status
git add -a
git add -A
git commit 
git push
cd
vim nonprofits.py 
rm nonprofits.pdf
ls
cd stat129
rm nonprofits.pdf
cd
/opt/anaconda/bin/ipython3 nonprofits.py 
ls
cp nonprofits.pdf stat129/
cd stat129
ls
git add -A
git commit
git push
vim nonprofits.py 
cd
vim nonprofits.py 
/opt/anaconda/bin/ipython3 nonprofits.py 
rm stat129/nonprofits.pdf 
cp nonprofits.pdf stat129/
cd stat129
git add -A
git commit "2023 nonprofits"
git commit
git push
cd
vim nonprofits.py 
time /opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.p
vim nonprofits.py
time /opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
exit
clear
ls
vim nonprofits.p
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 

vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
vim nonprofits.py
/opt/anaconda/bin/ipython3 nonprofits.py 
rm stat129/nonprofits.pdf
cp nonprofits.pdf stat129/
cd stat129
git add -A
git commit 
git push
clear
cd
ls
clear
ls
clear
cp /stat129/stat129-spring24/blob/main/text.py .
cd /stat129/stat129-spring24
ls
cd blob
cd
cp /stat129/stat129-spring24/text.py .
ls
vim text.py
clear
exit
clear
ls
vim text.py
/opt/anaconda/bin/ipython
vim text.py
/opt/anaconda/bin/ipython
vim text.py
/opt/anaconda/bin/ipython
vim text.py
/opt/anaconda/bin/ipython
vim text.py
/opt/anaconda/bin/ipython
vim text.py
/opt/anaconda/bin/ipython python3 text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
/opt/anaconda/bin/ipython text.py
vim text.py
clear
ls
cd /stat129/stat129-spring24
cat descriptions.csv 
clear
ls
cd
ls
clear
ls
exit
clear
/opt/anaconda/bin/ipython
exit
clear
xmllint --xpath "//RevenueAmt" /stat129/stat129-spring24/tax/b.xml
xmllint --xpath "//RevenueAmt" /stat129/tax/b.xml
clear
echo Hello | grep -Po "ll"
echo Hello | grep -Po "[l]"
echo Hello | grep -Po "[l]{2}"
echo Hello | grep -Po "[l]{3}"
echo Hello | grep -Po "[l]{3}"clear
clear
words * docs * 8 / 1e6
clear
echo "The current president is Joe Biden. The previous president was Donald Trump, IIRC." | grep -Po "Joe Biden|Donald Trump"
cd /stat129/tax
vim b.xml
xmllint --xpath "//Filer//USAddress//CityNm" /stat129/tax/b.xml
xmllint --xpath "//Filer//USAddress//CityNm.text()" /stat129/tax/b.xml
xmllint --xpath "//Filer//USAddress//CityNm.text" /stat129/tax/b.xml
xmllint --xpath "//Filer//USAddress//CityNm()" /stat129/tax/b.xml
cd
ipython
ls
vim nonprofits.py
xmllint --xpath "//Filer//USAddress//CityNm/text()" /stat129/tax/b.xml
ipython
clear
echo "The current president is Joe Biden. The previous president was Donald Trump, IIRC." | grep -Po "Joe Biden|Donald Trump"
xmllint --xpath "//Filer//USAddress//CityNm/text()" /stat129/tax/b.xml
xmllint --xpath "/Filer/USAddress//CityNm/text()" /stat129/tax/b.xml
xmllint --xpath "//Filer/USAddress/CityNm/text()" /stat129/tax/b.xml
xmllint --xpath "//Filer//USAddress/CityNm/text()" /stat129/tax/b.xml
clear
cd /stat129/tax
vim b.xml
exit
clear
ls
cp /stat129/stat129-spring24/descriptions.csv .
ls

cp nonprofits.py wordmatrix.py
ls
vim wordmatrix.py 
ls
vim text.py
rm wordmatrix.py 
cp text.py wordmatrix.py
vim wordmatrix.py 
vim descriptions.csv 
clear
vim wordmatrix.py 
vim descriptions.csv 
vim wordmatrix.py 
python3 wordmatrix.py 
vim wordmatrix.py 
python3 wordmatrix.py 
vim wordmatrix.py 
python3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
vim text.py
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
clear
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
clear
/opt/anaconda/bin/ipython3 wordmatrix.py 
clear
/opt/anaconda/bin/ipython3 wordmatrix.py 
clear
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
exit 
clear
ls
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
ipython
clear
ls
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
ipython
clear
ls
clear
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py vim wordmatrix.py 
ls
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
vim wordmatrix.pyexit
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
clear
/opt/anaconda/bin/ipython3 wordmatrix.py 
clear
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
clear
/opt/anaconda/bin/ipython3 wordmatrix.py 
clear
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
exit
clear
ls
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.pyq
vim wordmatrix.py
vim text.py
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
exit
clear
ls
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
[[31]
exit
clear
ls
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
clear
exit
clear
exit
clear
ls
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
ls
cd /stat129
ls
cd stat129-spring24
/ls
ls
vim text2.py
cd
vim wordmatrix.py 
vim /stat129/stat129-spring24/text2.py
vim wordmatrix.py 
vim /stat129/stat129-spring24/text2.py
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py 
clear
exit
clear
exit
clear
cd csc138/Project
exit
clear
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
vim wordmatrix.py
/opt/anaconda/bin/ipython3 wordmatrix.py 
exit
ls
cd /stat129/stat129-spring24
ls
cd
cp /stat129/stat129-spring24/kmeans.py ..
cp /stat129/stat129-spring24/kmeans.py .
ls
vim kmeans.py
clear
ls
cp /stat129/stat129-spring24/tfidf.npz .
cp /stat129/stat129-spring24/terms.txt .
cp /stat129/stat129-spring24/descriptions.csv .
ls
vim kmeans.py
/opt/python3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
cat terms.txt
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
clear
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
vim kmeans.py
/opt/anaconda/bin/ipython3 kmeans.py
exit
ls
vim kmeans.py
clear
