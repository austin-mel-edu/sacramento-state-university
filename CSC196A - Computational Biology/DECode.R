# Install limma
if (!require("BiocManager", quietly = TRUE))
  install.packages("BiocManager")

BiocManager::install("limma")

# Download data
BiocManager::install("breastCancerVDX")
BiocManager::install("CLL")

library(limma)
library(breastCancerVDX)
data(vdx)

# Matrix containing gene expressions as measured by Affymetrix hgu133a 
# technology (single-channel, oligonucleotides).
x = exprs(vdx) 
# AnnotatedDataFramecontainingannotationsofAffymicroarrayplatform hgu133a.
f = fData(vdx)
# AnnotatedDataFrame containing Clinical information of the breast cancer
# patients whose tumors were hybridized.
p = pData(vdx)
p$er <- ifelse(p$er == 0, "negative", "positive")

# Visualize gene expression with a boxplot
boxplot(x[1, ] ~ p[, "er"], main = f[1, "symbol"])

# Getting a subset of data

x_sub <- x[1000, 1:10]
f_sub <- f[1000, ]
p_sub <- p[1:10, ]

# Object-oriented programming with Bioconductor classes

install.packages("BiocManager")
BiocManager::install("Biobase")

# Load package
library(Biobase)

# Create ExpressionSet object
eset <- ExpressionSet(assayData = x,
                      phenoData = AnnotatedDataFrame(p),
                      featureData = AnnotatedDataFrame(f))
# View the number of features (rows) and samples (columns)
dim(eset)

design <- model.matrix(~er, data = pData(eset))

# Fit the model
fit <- lmFit(eset, design)

# Calculate the t-statistics
fit <- eBayes(fit)

# Summarize results
results <- decideTests(fit)
summary(results)

top_genes <- topTable(fit, adjust="fdr", sort.by="B", number=Inf)
head(top_genes)

DE_Gene <- top_genes[which(top_genes$adj.P.Val<0.05),]
head(DE_Gene)

plotMD(fit, column=1, status=results[,1], main=colnames(fit)[1],
       xlim=c(-8,13),pch=20, cex=1)
abline(h=0)


# Design matrix for group-means

design <- model.matrix(~0+ er, data = pData(eset))
head(design)

colSums(design)


cm <- makeContrasts(status = erpositive - ernegative,
                    levels = design)

cm

# Testing the group-means parametrization
fit <- lmFit(eset, design)
head(fit$coefficients, 3)


fit2 <- contrasts.fit(fit, contrasts = cm)
head(fit2$coefficients, 3)

# The parametrization does not change the results

# Calculate the t-statistics
fit2 <- eBayes(fit2)

# Count the number of differentially expressed genes
results <- decideTests(fit2)
summary(results)

top_genes <- topTable(fit2, adjust="fdr", sort.by="B", number=Inf)
head(top_genes)

DE_Gene <- top_genes[which(top_genes$adj.P.Val<0.05),]
head(DE_Gene)

plotMD(fit2, column=1, status=results[,1], main=colnames(fit2)[1],
       xlim=c(-8,13),pch=20, cex=1)
abline(h=0)


# summarize test results as "up", "down" or "not expressed"
dT <- decideTests(fit2, adjust.method="fdr", p.value=0.05)
# Venn diagram of results
vennDiagram(dT, circle.col=palette())


# volcano plot (log P-value vs log fold change)
colnames(fit2) # list contrast names
ct <- 1        # choose contrast of interest
volcanoplot(fit2, coef=ct, main=colnames(fit2)[ct], pch=20,
            highlight=length(which(dT[,ct]!=0)), names=rep('+', nrow(fit2)))

# Heat map
install.packages("pheatmap")
library(pheatmap)
de_genes <- rownames(top_genes)[1:20]
expression_matrix <- exprs(eset)[de_genes, ]

pheatmap(expression_matrix, scale="row", clustering_distance_rows="euclidean", 
         clustering_distance_cols="euclidean", clustering_method="complete",
         color = colorRampPalette(c("navy", "white", "firebrick"))(50))


# A study with 3 groups
BiocManager::install("leukemiasEset")

library(leukemiasEset)
library(Biobase)

data(leukemiasEset) 
# ExpressionSet overview: 
eset = leukemiasEset

# Group-means design matrix for 3 groups
design <- model.matrix(~0 + LeukemiaType,
                       data = pData(eset))
head(design, 3)

colSums(design)

cm <- makeContrasts(AMLvALL = LeukemiaTypeAML - LeukemiaTypeALL,
                    CMLvALL = LeukemiaTypeCML - LeukemiaTypeALL,
                    CMLvAML = LeukemiaTypeCML - LeukemiaTypeAML,
                    levels = design)

cm

library(limma)
# Fit coefficients
fit <- lmFit(eset, design)
# Fit contrasts
fit2 <- contrasts.fit(fit, contrasts = cm)
# Calculate t-statistics
fit2 <- eBayes(fit2)
# Summarize results
results <- decideTests(fit2)
summary(results)

