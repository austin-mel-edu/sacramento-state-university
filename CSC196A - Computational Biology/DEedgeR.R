# Install edgeR package from Bioconductor
suppressMessages({ if (!require("BiocManager", quietly = TRUE))
  install.packages("BiocManager")
  suppressWarnings(BiocManager::install("edgeR", update = TRUE, force = TRUE))
})

# Load edgeR package
library(edgeR)

expression_data <- GSE133039$expression_data

groups <- GSE133039$groups

# Assigning expression matrix to count
count <- expression_data

# Perform DE analysis using DGEList function
dge <- DGEList(counts = count, group = factor(groups))

dim(dge)
dge.full <- dge # keep the old one in case we mess up
head(dge$counts)

head(cpm(dge))

apply(dge$counts, 2, sum) # total gene counts per sample

keep <- rowSums(cpm(dge)>100) >= 2
dge <- dge[keep,]
dim(dge)

dge$samples$lib.size <- colSums(dge$counts)
dge$samples

# Normalizing the data
dge <- calcNormFactors(dge)
dge

# Data Exploration
plotMDS(dge, method="bcv", col=as.numeric(dge$samples$group))
legend("bottomleft", as.character(unique(dge$samples$group)), col=1:3, pch=20)

et12 <- exactTest(d1, pair=c(1,2)) # compare groups 1 and 2
topTags(et12, n=10)

top <- topTags(et12)

# Differential Expression

de1 <- decideTests(et12, adjust.method="BH", p.value=0.05)
summary(de1)

# Saving the result to local folder
saveRDS(top, file="C:/Users/austi/Desktop/data/DE_edgeR_genes.rds")

# Visualization

# GLM estimates of dispersion
design.mat <- model.matrix(~ 0 + dge$samples$group)
colnames(design.mat) <- levels(dge$samples$group)

d2 <- estimateGLMCommonDisp(dge,design.mat)
d2 <- estimateGLMTrendedDisp(d2,design.mat, method="auto")
# You can change method to "auto", "bin.spline", "power", "spline", "bin.loess".
# The default is "auto" which chooses "bin.spline" when > 200 tags and "power" otherwise.
d2 <- estimateGLMTagwiseDisp(d2,design.mat)

# Plot Biological Coefficient of Variation
plotBCV(d2)

# Smear plot
de1tags12 <- rownames(d1)[as.logical(de1)]
plotSmear(et12, de.tags=de1tags12)
abline(h = c(-2, 2), col = "blue")

design.mat
