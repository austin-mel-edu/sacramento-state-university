# Install limma package from Bioconductor
suppressMessages({if (!require("BiocManager", quietly = TRUE))
  suppressWarnings(install.packages("BiocManager"))
  suppressWarnings(BiocManager::install("limma", update = T))
})

suppressPackageStartupMessages({
  library("limma")
})

groups <- GSE133039$groups
# Create design matrix with no intercept
design <- model.matrix(~0 + groups)
colnames(design) <- levels(groups)
head(design)

norm_expression_data <- GSE133039$norm_expression_data

fit <- lmFit(norm_expression_data, design)  # fit linear model

# set up contrasts of interest and recalculate model coefficients
cts <- paste("c", "d", sep="-")
cont.matrix <- makeContrasts(contrasts=cts, levels=design)
cont.matrix

fit2 <- contrasts.fit(fit, cont.matrix)

# compute statistics and table of top significant genes
fit2 <- eBayes(fit2, 0.01)

dt <- decideTests(fit2,p.value=0.05)
summary(dt)

top_genes <- topTable(fit2, adjust="fdr", sort.by="B", number=Inf)
head(top_genes)

DE_Gene <- top_genes[which(top_genes$adj.P.Val<0.05),]
head(DE_Gene)

# Saving the result to local folder
saveRDS(DE_Gene, file="C:/Users/austi/Desktop/data/DE_genes.rds")


# Visualization

# Mean-difference plot
plotMD(fit2, column=1, status=dt[,1], main=colnames(fit2)[1],
       xlim=c(-8,13),pch=20, cex=1)
abline(h=0)

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

pheatmap(expression_matrix, scale="row", clustering_distance_rows="euclidean",
         clustering_distance_cols="euclidean", clustering_method="complete",
         color = colorRampPalette(c("navy", "white", "firebrick"))(50))
