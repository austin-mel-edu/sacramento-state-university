# Install edgeR package from Bioconductor
suppressMessages({ if (!require("BiocManager", quietly = TRUE))
  install.packages("BiocManager")
  suppressWarnings(BiocManager::install("edgeR", update = TRUE, force = TRUE))
})

# Example dataset that is built into the package baySeq
BiocManager::install("baySeq", force = TRUE)

library(edgeR)
library(baySeq)
# Corrupted mobData
# https://bios221.stanford.edu/data/mobData.RData

load("mobData.RData")
head(mobData)

#View dataset information
help(mobData)

# MM="triple mutatnt shoot grafted onto triple mutant root"
# WM="wild-type shoot grafted onto triple mutant root"
# WW="wild-type shoot grafted onto wild-type root"
mobDataGroups <- c("MM", "MM", "WM", "WM", "WW", "WW")
data(mobAnnotation)
#?mobAnnotation
head(mobAnnotation)

d <- DGEList(counts=mobData,group=factor(mobDataGroups))
d

dim(d)
d.full <- d # keep the old one in case we mess up
head(d$counts)

head(cpm(d))

apply(d$counts, 2, sum) # total gene counts per sample

keep <- rowSums(cpm(d)>100) >= 2
d <- d[keep,]
dim(d)

d$samples$lib.size <- colSums(d$counts)
d$samples

# Normalizing the data
d <- calcNormFactors(d)
d

# Data Exploration
plotMDS(d, method="bcv", col=as.numeric(d$samples$group))
legend("bottomleft", as.character(unique(d$samples$group)), col=1:3, pch=20)

# Estimating the Dispersion

d1 <- estimateCommonDisp(d, verbose=T)
names(d1)

#Use empirical Bayes tagwise dispersions

d1 <- estimateTagwiseDisp(d1)
names(d1)

plotBCV(d1)

# GLM estimates of dispersion

design.mat <- model.matrix(~ 0 + d$samples$group)

colnames(design.mat) <- levels(d$samples$group)

d2 <- estimateGLMCommonDisp(d,design.mat)
d2 <- estimateGLMTrendedDisp(d2,design.mat, method="power")
# You can change method to "auto", "bin.spline", "power", "spline", "bin.loess".
# The default is "auto" which chooses "bin.spline" when > 200 tags and "power" otherwise.
d2 <- estimateGLMTagwiseDisp(d2,design.mat)
plotBCV(d2)



et12 <- exactTest(d1, pair=c(1,2)) # compare groups 1 and 2
et13 <- exactTest(d1, pair=c(1,3)) # compare groups 1 and 3
et23 <- exactTest(d1, pair=c(2,3)) # compare groups 2 and 3
topTags(et12, n=10)

# Differential Expression

de1 <- decideTests(et12, adjust.method="BH", p.value=0.05)
summary(de1)

# differentially expressed tags from the naive method in d1
de1tags12 <- rownames(d1)[as.logical(de1)]
plotSmear(et12, de.tags=de1tags12)
abline(h = c(-2, 2), col = "blue")

design.mat

#Finding the tags that are interesting by using a likelihood ratio test.
fit <- glmFit(d2, design.mat)
# compare (group 1 - group 2) to 0:
# this is equivalent to comparing group 1 to group 2
lrt12 <- glmLRT(fit, contrast=c(1,-1,0))
topTags(lrt12, n=10)


#topTags(lrt13, n=10)
#topTags(lrt23, n=10)
de2 <- decideTests(lrt12, adjust.method="BH", p.value = 0.05)
de2tags12 <- rownames(d2)[as.logical(de2)]
plotSmear(lrt12, de.tags=de2tags12)
abline(h = c(-2, 2), col = "blue")
