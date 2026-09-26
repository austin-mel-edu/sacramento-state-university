# Baseline noise in mass spectrometer measurements

Client project report for Thermochron Systems and Adam Goldsmith

Prepared by Austin Melendez and Harmen Hundal  
Original analysis: May 19, 2026 | Data rerun: September 24, 2026

## Summary

Background noise should be estimated using the measurement time of each instrument channel. The instrument records a small electrical background even when no sample signal is present. Our analysis of 492,000 baseline readings found that both the typical noise level and its variation changed substantially with measurement time. A correction based on one timing setting may therefore misrepresent the background in another channel.

We recommend developing and testing a correction that matches each channel's measurement time. The project provides a statistical foundation for this work. It has not yet shown that the proposed approach improves real sample measurements or the rock ages calculated from them.

## Project Question

How does instrument background noise behave, and how should that knowledge guide more reliable estimates of the true sample signal? We focused on whether noise follows a consistent pattern and how that pattern changes with **dwell time**, the time the instrument spends collecting one reading.

## Findings

**Longer dwell times had lower and less variable background noise.** The median was 82% lower at 4.096 seconds than at 0.128 seconds. That setting takes 32 times as long per reading, creating a measurement-time tradeoff.

**Occasional large readings matter.** The average exceeded the median at every setting. The distributions below show why one average cannot describe the full range of background noise.

**Baseline channels did not closely track one another.** Readings at different dwell times generally did not rise and fall together within the same cycle. This limits the case for using one live baseline value to correct every channel.

**The model follows much of the observed pattern.** Freshly fitted curves broadly follow the measured distributions, with visible mismatches. This makes the model a candidate for validation, rather than a finished correction method.

![Boxplots of background current at six dwell-time settings.](assets/v4/client-background-distribution.png)

**Figure 1. Measured background distributions.** Current is in femtoamperes (fA); lower values mean less background. Boxes contain the middle 50% of readings; dark lines and labels mark the medians. Whiskers reach the most extreme readings within 1.5 box heights of each box. Outlier points are omitted for readability, but all 492,000 readings, including zeros, enter the calculations. Source: fresh assumptions notebook, appended report figure.

## Suggestions

1. **Test a correction matched to each channel's dwell time.** Use baseline measurements taken at the corresponding setting. Start with the observed median as a simple comparison method, and assess whether the fitted noise model improves on it.

2. **Keep the live baseline channel for monitoring.** Use it to flag changes in instrument behavior. Test whether it adds useful information for a particular channel before using it as a direct correction for that channel.

3. **Validate with blanks and samples with known signals.** Compare the current method, a median correction matched to dwell time, and the fitted model on independent runs. Measure recovery of known signals, remaining error, and uncertainty, especially for weak signals. Check performance separately by instrument and laboratory.

4. **Build uncertainty into the final signal estimate.** Develop a method that keeps estimated true signals at or above zero and reports a plausible range. Simple baseline subtraction can still produce negative estimates. Signals close to the background level need a clear rule for reporting uncertainty or a detection limit.

5. **Choose longer dwell times selectively.** Consider them where weak signals need greater precision, while checking the effect on total measurement time. Repeat baseline checks after changes to instrument settings, maintenance, or operating conditions.

## Limitations

**The study measured background noise, not correction performance.** It did not demonstrate improved accuracy for unknown samples, isotope ratios, or rock-age estimates. The practical benefits remain to be measured.

**The evidence covers a defined set of conditions.** The analysis concerns three Prisma Pro instruments at Glasgow, Salzburg, and Wuhan, using six dwell times from 0.128 to 4.096 seconds. A separate Salzburg batch was labeled Nineamu. Results should be checked before transfer to other instruments, settings, or periods of operation.

**The model is an approximation.** Laboratory and batch differences remain relevant, and the fitted model does not explicitly adjust for them. Only one fitted statistical model is reported, so it has not been established as the best available choice. Its most unusual predicted readings need particular scrutiny.

**Data handling and repeated measurements affect interpretation.** Cleaning relied on assumptions about automatic baseline subtraction and timestamp resets. One file with an incomplete header was excluded, along with three zero readings from logarithmic modeling. Many readings came from the same runs; the large observation count alone does not establish long-term stability or independence.

## Supporting statistics

The rerun reproduced **492,000 readings** from **73 baseline runs**, with **82,000 readings at each dwell time**. The table and distribution chart include three zeros. They describe measured background noise, not corrected sample signals. [3, 4]

Current values are in **femtoamperes** (fA), where 1 fA = 10⁻¹⁵ amperes. Smaller values represent lower background current.

| Dwell time (seconds) | Median (fA) | Mean (fA) | Standard deviation (fA) | 95th percentile (fA) |
| ---: | ---: | ---: | ---: | ---: |
| 0.128 | 29.86 | 39.28 | 34.87 | 108.40 |
| 0.256 | 19.56 | 24.90 | 21.39 | 66.62 |
| 0.512 | 12.66 | 15.65 | 12.92 | 40.81 |
| 1.024 | 8.61 | 10.25 | 7.97 | 25.57 |
| 2.048 | 6.36 | 7.16 | 5.13 | 16.65 |
| 4.096 | 5.26 | 5.64 | 3.70 | 12.25 |

**Mean** is the arithmetic average. **Standard deviation** measures spread; a smaller value means less variation. The **95th percentile** is the level below which approximately 95% of the baseline readings fall. It is not a validated sample detection limit.

From the shortest to the longest setting, the median fell by **82.4%**, the mean by **85.6%**, and the standard deviation by **89.4%**. These are descriptive comparisons across settings, not measured gains in sample accuracy.

For context, the median background at the live baseline timing of 0.512 seconds was about **2.4 times** the median at 4.096 seconds. This illustrates why a timing mismatch matters; it is not a rule for scaling individual live readings.

## Model fit in the measured data

Each panel shows one dwell-time setting. The gray bars show how often background readings occurred; the teal line smooths those observations, and the rust line shows the fitted model. Curves that lie close together indicate a closer match to these data. [4]

![Observed distributions, smoothed observations and fitted model at all six dwell times.](assets/v4/model-fit-log-scale.png)

**Figure 2. Model fit across the six settings.** Source: freshly executed modeling notebook, original code cell 13. Horizontal axes use log10 current in amperes; a one-unit increase represents ten times the current. Each panel displays its 0.1st to 99.9th percentile range of positive readings, so the most extreme tails are outside view. Density is relative concentration, not the number of readings.

**What this shows.** The model captures the broad shape and shift of the distributions, with differences around some peaks and tails. These are comparisons with the same observations used to fit the model.

**What remains to be tested.** A visual fit does not establish better sample correction. Independent blank and known-signal runs are needed to assess accuracy, uncertainty and behavior close to zero.

## How closely the channels move together

This chart compares readings from different dwell-time channels within the same measurement cycle. Values near zero indicate little tendency for the channels to rank high or low together. The small off-diagonal values support testing any proposed transfer of live baseline readings between channels. [3]

![Spearman correlation matrix across six dwell-time channels. Off-diagonal correlations range from -0.095 to 0.134.](assets/v4/channel-correlation.png)

**Figure 3. Association between dwell-time channels.** Source: freshly executed assumptions notebook, original code cells 44 and 47; 82,000 aligned cycles. Row and column labels are dwell times in seconds. Each diagonal value is 1 because a channel is compared with itself.

**Average pairwise correlation: 0.0073.** Individual pairs ranged from **-0.0948 to 0.1335**. Positive values mean readings tend to rank together; negative values mean they tend to rank in opposite directions. The scale spans -1 to 1.

These pooled correlations do not prove independence or rule out relationships within individual runs, laboratories or periods of operation. They also do not test whether a baseline channel is useful for detecting longer-term changes.

## Methods and technical notes

### Data and execution

All three notebooks were run from start to finish on September 24, 2026 using the supplied data folder. Of 76 directly selected files, 73 were classified as baseline runs and two as experimental runs. Glasgow/He 674 lacked mass labels in its header and could not be parsed. The duplicate data/pro copy and nested nosem folder were not included; the original nonrecursive selection rule was retained. [3, 4]

The parser reversed suspected automatic baseline subtraction using its existing 1.024-second reference and retained the final segment after timestamp resets. No negative readings remained. Three zeros were excluded only for logarithmic modeling, leaving **491,997 positive readings**. Source notebooks and raw files were preserved; executed copies, data hashes, package versions and figure sources accompany this report. [4]

### Model and diagnostics

A seven-parameter **log-skew-t model** was fitted to natural-log current. Its location, scale and tail behavior depend on log dwell time, with shared skewness. The best of six starts reported convergence; several others stopped after one iteration at poorer fits. A global optimum is not established. The model describes background noise, not a correction for real samples. [4]

The fresh fit reports **AIC 1,351,186.11** and **BIC 1,351,263.86**. These are relative model-comparison scores, not accuracy percentages or pass marks. Alternatives must use comparable observations and likelihood scales. No independent test of correction performance is reported. [4]

### Reconciliation and next checks

The fresh shared skewness estimate is **-3.8055**, whereas the earlier technical report lists **0.0592**. The fresh correlation matrix gives an average of **0.0073**, also differing from an older narrative note. This report uses the fresh computed outputs; the conflicting historical interpretations should be corrected before the technical material is reused. [2-4]

Use medians or validated quantiles for an initial correction comparison. A positive noise model does not ensure a nonnegative corrected signal. Check near-zero signals, extreme predictions, laboratory and batch effects, and uncertainty on runs excluded from fitting.

## Project sources

1. [Project Background.docx](<../../Project Background.docx>). Instrument context, acquisition settings and objectives.

2. Melendez, Austin, and Harmen Hundal. *Identifying the Distribution of Baseline Noise in Mass Spectrometer Measurements.* [Technical Report.docx](<../../Technical Report.docx>), May 19, 2026. Historical analysis and instrument context.

3. [02-assumptions-executed.ipynb](../jupyter-notebook/02-assumptions-executed.ipynb), September 24, 2026. Fresh summaries, correlations and report distribution figure.

4. [01-preprocessing-executed.ipynb](../jupyter-notebook/01-preprocessing-executed.ipynb) and [03-modeling-executed.ipynb](../jupyter-notebook/03-modeling-executed.ipynb), September 24, 2026. Fresh processing, model fit and diagnostic plots. [Execution manifest](../analysis/run-2026-09-24/execution_manifest.json) records input hashes and package versions.
