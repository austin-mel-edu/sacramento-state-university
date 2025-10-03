# CPU Scheduling Metrics Analysis
## CSC 139 Scehduler Assignemnt
### Austin Melendez
#### 10/02/2025


This report shows the calculations of **Average Turnaround Time (TAT)**, **Waiting Time (WT)**, and **Response Time (RT)** for the five scheduling algorithms: **FCFS, SJF, Round Robin, Priority, and Priority with Round Robin**.

---

## Definitions

- **Turnaround Time (TAT):**
$$ 
TAT = Completion\ Time - Arrival\ Time
$$

- **Waiting Time (WT):**
$$
WT = Turnaround\ Time - Burst\ Time
$$

- **Response Time (RT):**
$$
RT = First\ Response\ Time - Arrival\ Time
$$

Since all tasks arrive at time 0, formulas simplify to:

$$
TAT = Completion\ Time
$$

$$
WT = TAT - Burst\ Time
$$

$$
RT = First\ Start\ Time
$$

---

## First-Come, First-Served (FCFS)

Execution order: T1 → T2 → T3 → T4 → T5 → T6 → T7 → T8

| Task | Burst | Completion Time | TAT | WT | RT |
|------|-------|-----------------|-----|----|----|
| T1   | 20    | 20              | 20  | 0  | 0  |
| T2   | 25    | 45              | 45  | 20 | 20 |
| T3   | 25    | 70              | 70  | 45 | 45 |
| T4   | 15    | 85              | 85  | 70 | 70 |
| T5   | 20    | 105             | 105 | 85 | 85 |
| T6   | 10    | 115             | 115 | 105| 105|
| T7   | 30    | 145             | 145 | 115| 115|
| T8   | 25    | 170             | 170 | 145| 145|

**Averages:**  

$$
\text{Avg TAT} = \frac{20+45+70+85+105+115+145+170}{8} = 95.625
$$

$$
\text{Avg WT} = \frac{0+20+45+70+85+105+115+145}{8} = 73.125
$$

$$
\text{Avg RT} = \frac{0+20+45+70+85+105+115+145}{8} = 73.125
$$

---

## Shortest Job First (SJF)

Execution order: T6 → T4 → T5 → T1 → T8 → T3 → T2 → T7

| Task | Burst | Completion Time | TAT | WT | RT |
|------|-------|-----------------|-----|----|----|
| T6   | 10    | 10              | 10  | 0  | 0  |
| T4   | 15    | 25              | 25  | 10 | 10 |
| T5   | 20    | 45              | 45  | 25 | 25 |
| T1   | 20    | 65              | 65  | 45 | 45 |
| T8   | 25    | 90              | 90  | 65 | 65 |
| T3   | 25    | 115             | 115 | 90 | 90 |
| T2   | 25    | 140             | 140 | 115| 115|
| T7   | 30    | 170             | 170 | 140| 140|

**Averages:**  

$$
\text{Avg TAT} = \frac{10+25+45+65+90+115+140+170}{8} = 82.5
$$

$$
\text{Avg WT} = \frac{0+10+25+45+65+90+115+140}{8} = 61.25
$$

$$
\text{Avg RT} = \frac{0+10+25+45+65+90+115+140}{8} = 61.25
$$

---

## Round Robin (RR, quantum = 10ms)

Execution order (simplified by quantum): T1 → T2 → T3 → T4 → T5 → T6 → T7 → T8 → T1 …

| Task | Burst | Completion Time | TAT | WT | RT |
|------|-------|-----------------|-----|----|----|
| T6   | 10    | 55              | 55  | 45 | 50 |
| T1   | 20    | 95              | 95  | 75 | 0  |
| T4   | 15    | 115             | 115 | 100| 30 |
| T5   | 20    | 125             | 125 | 105| 40 |
| T2   | 25    | 140             | 140 | 115| 10 |
| T3   | 25    | 145             | 145 | 120| 20 |
| T7   | 30    | 155             | 155 | 125| 60 |
| T8   | 25    | 160             | 160 | 135| 70 |

**Averages:**  

$$
\text{Avg TAT} = \frac{55+95+115+125+140+145+155+160}{8} = 123.75
$$

$$
\text{Avg WT} = \frac{45+75+100+105+115+120+125+135}{8} = 102.5
$$

$$
\text{Avg RT} = \frac{50+0+30+40+10+20+60+70}{8} = 35
$$

---

## Priority Scheduling

Execution order: T8 → T5 → T4 → T1 → T7 → T3 → T2 → T6

| Task | Burst | Completion Time | TAT | WT | RT |
|------|-------|-----------------|-----|----|----|
| T8   | 25    | 25              | 25  | 0  | 0  |
| T5   | 20    | 45              | 45  | 25 | 25 |
| T4   | 15    | 60              | 60  | 45 | 45 |
| T1   | 20    | 80              | 80  | 60 | 60 |
| T7   | 30    | 110             | 110 | 80 | 80 |
| T3   | 25    | 135             | 135 | 110| 110|
| T2   | 25    | 160             | 160 | 135| 135|
| T6   | 10    | 170             | 170 | 160| 160|

**Averages:**  

$$
\text{Avg TAT} = \frac{25+45+60+80+110+135+160+170}{8} = 98.125
$$

$$
\text{Avg WT} = \frac{0+25+45+60+80+110+135+160}{8} = 76.875
$$

$$
\text{Avg RT} = \frac{0+25+45+60+80+110+135+160}{8} = 76.875
$$

---

## Priority with Round Robin (Priority RR, quantum = 10ms)

Execution order: Highest priority first; ties resolved with Round Robin.

| Task | Burst | Completion Time | TAT | WT | RT |
|------|-------|-----------------|-----|----|----|
| T8   | 25    | 25              | 25  | 0  | 0  |
| T4   | 15    | 40              | 40  | 25 | 25 |
| T5   | 20    | 50              | 50  | 30 | 35 |
| T1   | 20    | 70              | 70  | 50 | 45 |
| T2   | 25    | 95              | 95  | 70 | 55 |
| T3   | 25    | 105             | 105 | 80 | 65 |
| T7   | 30    | 115             | 115 | 85 | 75 |
| T6   | 10    | 125             | 125 | 115| 115|

**Averages:**  

$$
\text{Avg TAT} = \frac{25+40+50+70+95+105+115+125}{8} = 78.125
$$

$$
\text{Avg WT} = \frac{0+25+30+50+70+80+85+115}{8} = 56.875
$$

$$
\text{Avg RT} = \frac{0+25+35+45+55+65+75+115}{8} = 52.5
$$

---

# Final Comparison Table

| Algorithm   | Avg TAT | Avg WT | Avg RT |
|-------------|---------|--------|--------|
| FCFS        | 95.63   | 73.13  | 73.13  |
| SJF         | 82.50   | 61.25  | 61.25  |
| RR          | 123.75  | 102.50 | 35.00  |
| Priority    | 98.13   | 76.88  | 76.88  |
| Priority RR | 78.13   | 56.88  | 52.50  |

---

# Conclusion

- **SJF** and **Priority RR** give the best average turnaround and waiting times.  
- **Round Robin** increases fairness but has higher turnaround and waiting times.  
- **Response time** is lowest in **Round Robin**, since all tasks get CPU quickly.  
- **Priority RR** balances fairness and priority well, offering a good compromise.
