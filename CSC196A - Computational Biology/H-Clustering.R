library(tidyverse)
library(RColorBrewer)

# Yeast genome (>6000 genes) consisted of six different types of cell cycle 
# synchronization experiments.

spellman <- read_csv("https://github.com/Bio723-class/example-datasets/raw/master/spellman-wide.csv")

dim(spellman)
# Looking at the first few rows and columns of the data:

View(head(spellman))

spellman.cor <- dplyr::select(spellman, -time, -expt) %>% 
  cor(use="pairwise.complete.obs")

spellman.dist <- as.dist(1 - spellman.cor)

spellman.tree <- hclust(spellman.dist, method="complete")

plot(spellman.tree)


plot(spellman.tree, cex=0.2)

install.packages("dendextend")

library(dendextend)
spellman.dend <- as.dendrogram(spellman.tree) # create dendrogram object

nleaves(spellman.dend)  # number of leaves in tree
## [1] 724
nnodes(spellman.dend)  # number of nodes (=leaves + joins) in tree
## [1] 1447

# Plotting dendrograms in dendextend
plot(spellman.dend, leaflab = "none")

# Cutting dendrograms

clusters <- cutree(spellman.dend, k=4)
table(clusters)
clusters[1:6]

# A nicer plot that highlights each of the clusters.
plot(color_branches(spellman.dend, k=4),leaflab="none")


# 8 clusters
plot(color_branches(spellman.dend, k=8),leaflab="none")

# The number of genes in each cluster:
clusters <- cutree(spellman.dend, k=8, order_clusters_as_data = FALSE)
table(clusters)

# Generating a heat map from a cluster
spellman.long <- gather(spellman, gene, expression, -time, -expt) 
head(spellman.long)


# Looking at clusters
clusters.df <- data.frame(gene = names(clusters), cluster = clusters)

# Get all the names of genes in a given cluster:

cluster3.genes <- filter(clusters.df, cluster == 3)$gene

cat(as.character(cluster3.genes[1:10]), quote=FALSE,sep="\n");


color.scheme <- rev(brewer.pal(8,"RdBu")) # generate the color scheme to use

spellman.long %>%
  filter(gene %in% cluster3.genes & expt == "alpha") %>%
  ggplot(aes(x = time, y = gene)) + 
  geom_tile(aes(fill = expression)) +
  scale_fill_gradientn(colors=color.scheme, limits = c(-2,2)) + 
  theme(axis.text.y = element_text(size = 6))  # set size of y axis labels

# Working with sub-trees

# note that I determined the height to cut at by looking at the colored dendrogram
# plot above for 8 clusters
sub.trees <- cut(spellman.dend, h = 1.48)
sub.trees$lower

# retrieve any particular sub-tree by indexing into the list:
cluster3.tree <- sub.trees$lower[[3]]
cluster3.tree
## 'dendrogram' with 2 branches and 58 members total, at height 1.32836
nleaves(cluster3.tree)

# Combining heatmaps and dendrograms
library(gplots)

# subset out the alpha factor data
alpha.factor <- filter(spellman, expt == "alpha")

# create matrix after dropping time and expt columns
alpha.mtx <- as.matrix(dplyr::select(alpha.factor, -time, -expt)) # drop time, expt columns

# set row names to corresponding time points for nice plotting
row.names(alpha.mtx) <- alpha.factor$time

# transpose the matrix so genes are drawn in rows
transposed.alpha.mtx <- t(alpha.mtx)


# this is a large figure, so if working in RMarkdown document I suggest specifying
# the code block header as so to make the figure large
# {r, fig.width = 8, fig.height = 8}
heatmap.2(transposed.alpha.mtx,
          Rowv = cluster3.tree,  # use the dendrogram previously calculated
          Colv = NULL, # don't mess with my columns! (i.e. keep current ordering )
          dendrogram = "row",   # only draw row dendrograms
          breaks = seq(-2, 2, length.out = 9),  # OPTIONAL: set break points for colors
          col = color.scheme,  # use previously defined colors
          trace = "none", density.info = "none",  # remove distracting elements of plot
          xlab = "Time (mins)")



