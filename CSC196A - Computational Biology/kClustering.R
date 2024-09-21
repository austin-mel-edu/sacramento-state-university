library(tidyverse)
library(RColorBrewer)

expression_data <- GSE133039$expression_data

expression_data.cor <- cor(expression_data, use="pairwise.complete.obs")

expression_data.dist <- as.dist(1 - expression_data.cor)

expression_data.tree <- hclust(expression_data.dist, method="complete")

plot(expression_data)

plot(expression_data, cex=0.2)

install.packages("dendextend")

library(dendextend)
expression_data.dend <- as.dendrogram(expression_data.tree) # create dendrogram object

nleaves(expression_data.dend)  # number of leaves in tree
## [1] 66
nnodes(expression_data.dend)  # number of nodes (=leaves + joins) in tree
## [1] 131

# Plotting dendrograms in dendextend
plot(expression_data.dend, leaflab = "none")

# Cutting dendrograms

clusters <- cutree(expression_data.dend, k=4)
table(clusters)
clusters[1:6]

# k=3 highlighted
plot(color_branches(expression_data.dend, k=3),leaflab="none")

# The number of genes in each cluster:
clusters <- cutree(expression_data.dend, k=3, order_clusters_as_data = FALSE)
table(clusters)

# k=4 highlighted
plot(color_branches(expression_data.dend, k=4),leaflab="none")

# The number of genes in each cluster:
clusters <- cutree(expression_data.dend, k=4, order_clusters_as_data = FALSE)
table(clusters)

# k=5 highlighted
plot(color_branches(expression_data.dend, k=5),leaflab="none")

# The number of genes in each cluster:
clusters <- cutree(expression_data.dend, k=5, order_clusters_as_data = FALSE)
table(clusters)
