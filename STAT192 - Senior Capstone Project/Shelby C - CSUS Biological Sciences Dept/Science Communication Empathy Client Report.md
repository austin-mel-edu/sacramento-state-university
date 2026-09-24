# Empathy in science communication

Client project report

Prepared for Shelby Chandar, CSUS Biological Sciences

24 September 2026

## Summary

Students reported higher empathy after the study period, but the training group did not clearly improve more than the comparison group. Among 222 students with both before and after surveys, average scores increased on both empathy measures. Because comparison-group students also improved, the results do not establish that the training caused the increase.

The practical next step is a more consistent evaluation of the program before using this study to support wider adoption. The findings leave open the possibility of a benefit, but do not demonstrate one beyond the comparison group.

## Project Question

Does empathy-focused science communication training help students report greater empathy, beyond any change seen in a comparison group? The project also asked whether the results differed by academic major.

The study compared 96 students in the training group with 126 in the comparison group. Its major categories were Biology and Biological Sciences, labeled "STEM," and all other majors, labeled "Non-STEM." These are project-specific categories, not a general comparison of all STEM and non-STEM fields.

## Findings

**Average scores rose on both surveys.** Across all 222 students, the Jefferson score increased by 5.96 points and the modified Toronto score increased by 1.31 points. These are average changes; they do not mean that every student improved. The surveys use different scales, so their point increases should be interpreted separately.

**The training showed no clear added advantage.** Jefferson scores rose slightly more in the training group, while Toronto scores rose slightly more in the comparison group. Neither difference was clear enough to establish an added training benefit. This does not prove that the training has no effect.

**Major did not clearly distinguish the results.** The two major groups had similar starting scores, with no clear difference in average improvement or in their response to training relative to the comparison group.

**Starting scores mattered.** Students with higher initial scores tended to show smaller gains. Analyses that accounted for starting scores still did not establish an added training benefit.

## Suggestions

1. **Use the results to guide the next evaluation.** Describe the current finding as an increase in self-reported empathy across the study sample. If the program continues, treat it as an opportunity to refine and evaluate the training. Avoid presenting this study as proof that the program improves empathy.

2. **Make the next comparison more consistent.** Use comparable course sections, the same participation expectations, and the same survey timing. Randomly assign students or sections where feasible. Record attendance and completion so the evaluation can distinguish assignment to training from actual participation.

3. **Measure communication as well as survey responses.** Add a short communication task assessed with a clear rubric, ideally by reviewers who do not know each student's group. A later follow-up could show whether changes persist. Check that any adapted questionnaire measures the intended qualities consistently.

4. **Plan for a useful and credible result.** Agree in advance on what improvement would matter in practice, then use that target to plan the sample size. Aim for more balanced groups, use reliable participant identifiers, and establish scoring and incomplete-response rules before collecting data.

## Limitations

**Participation differed across classes.** Some instructors required the program; others offered extra credit. Motivation, teaching, or course context could therefore contribute to the observed changes. The study does not establish that the training alone caused them.

**The outcomes describe self-reported empathy.** They do not directly demonstrate better communication with an audience. Survey familiarity or a desire to give favorable answers could affect responses. The before-and-after results also do not establish lasting change.

**The measures have constraints.** The Toronto questionnaire was adapted for this project, so its scores should not be treated as directly interchangeable with the standard questionnaire. High starting scores may also leave less room to register improvement; the observed pattern does not establish why gains were smaller for these students.

**The comparisons have limited precision and scope.** Unequal group sizes and a few large individual changes add uncertainty. No clear group difference is not proof of equal effects. Participants came from undergraduate Biological Sciences course sections, and the project's narrow major classification limits broader conclusions.

**Course context was not modeled directly.** The analyses treated students as independent, although students in the same class may share experiences. Recording course-section membership would allow this to be addressed in a future evaluation.

## Supporting statistics

The analysis included 222 matched students: 96 in training and 126 in the comparison group. The major subgroups contained 53 and 47 Biology or Biological Sciences students, respectively, and 43 and 79 students in other majors. [1, 2]

The two questionnaires are reported separately. Higher scores indicate greater self-reported empathy. "Change" means the after score minus the before score.

| Result | Jefferson | Modified Toronto |
| --- | ---: | ---: |
| Possible total score with all items answered | 14 to 98 | 0 to 64 |
| Overall average before the study | 75.76 | 47.88 |
| Overall average after the study | 81.72 | 49.18 |
| Overall average change | **+5.96** | **+1.31** |
| 95% confidence interval for overall change | +4.99 to +6.92 | +0.74 to +1.87 |
| p-value for overall change | < 0.001 | < 0.001 |
| Average change in the training group | +6.52 | +1.08 |
| Average change in the comparison group | +5.53 | +1.48 |
| Difference in change (training minus comparison) | **+0.99** | **-0.39** |
| 95% confidence interval for that difference | -0.92 to +2.90 | -1.51 to +0.72 |
| p-value for the training versus comparison difference | 0.308 | 0.489 |

Source: [4], analysis rerun on 24 September 2026. All means, confidence intervals, and p-values were checked against the new model outputs. Values are rounded; differences were calculated before rounding.

### How to read the uncertainty

A confidence interval shows the uncertainty around an estimate under the statistical model. Both intervals for the training-versus-comparison difference include zero. The data are therefore compatible with no added benefit, as well as some benefit or disadvantage within the reported ranges.

The p-values compare the observed evidence with a model of no average change or no group difference. The project used 0.05 as its statistical threshold. A p-value does not tell us whether a change matters in practice, or the probability that the training works. The overall increases were statistically clear, but the added training benefit was not.

## Technical notes

### Data and measurement

Anonymous identifiers linked before and after responses. Nine client-flagged participants were excluded for uniform response patterns suspected to reflect low engagement. Rerun checks confirm one before and one after record for each of the 222 retained students, with consistent group labels. [1, 2]

The study scored 14 Jefferson items from 1 to 7 and 16 modified Toronto items from 0 to 4. Negatively worded items were reversed before summation. These project scores should not be assumed interchangeable with other questionnaire versions. [1, 2]

### Analysis and secondary comparisons

Paired t-tests evaluated within-student change; Welch t-tests compared group averages. Change-score models tested whether the training-versus-comparison difference varied by major. Baseline-adjusted models, called ANCOVA, compared after scores while accounting for before scores. [1, 4]

| Comparison | Jefferson p | Toronto p |
| --- | ---: | ---: |
| Major groups at baseline | 0.933 | 0.907 |
| Major groups in average change | 0.176 | 0.697 |
| Training difference varies by major | 0.639 | 0.670 |
| Training difference varies by major after adjusting for baseline | 0.452 | 0.501 |

Source: [1], Sections 5.1 and 5.4-5.6. All four comparisons are above the project's 0.05 threshold. These results indicate insufficient evidence of differences, not proof of equivalence.

### Scoring and interpretation checks

The rerun confirmed that all 30 survey items were recognized and scored in each of the 444 retained survey records. No missing or unrecognized item values were found. The response label "Disgaree" in the raw data matches the scoring code. Recalculated baseline totals also match the original cleaned baseline file. [2]

Rerun diagnostics show departures from normality in change-score residuals, and the technical report identifies influential individual changes. Sensitivity checks are therefore useful. The negative relationship between starting score and change is consistent with limited room to improve, but does not by itself prove a ceiling effect. [1, 3]

### Project sources

[1] Melendez, Austin, and Sara Bruggman. *Differences in Surveyed Empathy Levels in Scientific Communication after Intervention Training.* Technical Report.docx, 19 May 2026. STAT 192 Statistics Capstone Project.

[2] 01-preprocessing.ipynb, rerun on 24 September 2026; scoring and pairing checks.

[3] 02-assumptions.ipynb, rerun on 24 September 2026; summaries, diagnostics, and change-score plots. Report charts retain the notebook data and geometry, with revised labels and styling.

[4] 03-modeling.ipynb, rerun on 24 September 2026; full model results.

All 42 code cells across the three notebooks were executed from the raw survey file with the original scoring and classification rules. This edition uses the resulting data, fitted models, and figures.
