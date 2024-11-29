#if (!require("BiocManager", quietly = TRUE))
#  install.packages("BiocManager")
#BiocManager::install("GEOquery", update = F)


library("GEOquery")

## change my_id to be the dataset that you want.
accession_ID <- "GSE133039"
gse <- getGEO(accession_ID,GSEMatrix =TRUE, AnnotGPL=TRUE)
if (length(gse) > 1) idx <- grep("GPL570", attr(gse, "names")) else idx <- 1
metadata <- gse[[idx]]

# Get the samples information
samples <- pData(metadata)

# load counts table from GEO
urld <- "https://www.ncbi.nlm.nih.gov/geo/download/?format=file&type=rnaseq_counts"
path <- paste(urld, "acc=GSE133039", "file=GSE133039_raw_counts_GRCh38.p13_NCBI.tsv.gz", sep="&");
tbl <- as.matrix(data.table::fread(path, header=T, colClasses="integer"), rownames=1)

# pre-filter low count genes
# keep genes with at least 2 counts > 10
keep <- rowSums( tbl >= 10 ) >= 2
tbl <- tbl[keep, ]
expression_matrix <- tbl

# log transform raw counts
# instead of raw counts can display vst(as.matrix(tbl)) i.e. variance stabilized counts
norm_expression_matrix <- log10(tbl + 1)

# Expression matrix
View(norm_expression_matrix)

# Calculate data quantile and remove the NA value
qx <- as.numeric(quantile(norm_expression_matrix, c(0., 0.25, 0.5, 0.75, 0.99, 1.0), na.rm=T))
LogC <- (qx[5] > 100) || (qx[6]-qx[1] > 50 && qx[2] > 0)

# Plot the boxplot of 10 samples
boxplot(norm_expression_matrix[,1:10],outline=FALSE)

# Select disease samples
disease_idx <- grep("Tumor liver tissue", samples$source_name_ch1)
# Create a vector to store label
groups <- rep("X", nrow(samples))
# Annotate disease samples as "d"
groups[disease_idx] <- "d"
# Control samples are labeled as "c"
groups[which(groups!="d")] <- "c"
groups <- factor(groups)

# Putting raw data, normalized data, and groups into a list
dat <- list(expression_data = expression_matrix,
            norm_expression_data = norm_expression_matrix,
            groups = groups)

# Save the data to the local disk using rds format
saveRDS(dat, file=paste0("C:/Users/austi/Desktop/data/",accession_ID,".rds"))

