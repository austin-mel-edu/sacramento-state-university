from collections import Counter
import random
import numpy as np
import scipy as sp
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.decomposition import TruncatedSVD
from sklearn.cluster import KMeans


sparse = sp.sparse.load_npz("tfidf.npz")
tf = TfidfVectorizer()

X = sparse
X.shape


#terms = sparse.get_feature_names_out()
#print(terms)

file1 = open("terms.txt", "r")
terms = []
Lines = file1.readlines()
for term in Lines:
    terms.append(term.strip())
terms = np.array(terms)

# Principal Components using SVD
############################################################

# Experiment with this
ndim = 50 
svd = TruncatedSVD(n_components=ndim, random_state=230)
svd.fit(X)

# These are the principal components
Xpc = svd.transform(X)

X.shape

Xpc.shape

# Percentage of total variance in data explained by 
# these principal components
100 * sum(svd.explained_variance_ratio_)


# Kmeans!
############################################################
# Experiment with different values
K = 3

km = KMeans(n_clusters=K, random_state=2408)
# We can also just use X here if we like
#clusters = km.fit_predict(Xpc)
clusters = km.fit_predict(X)
# How many are in each cluster?
print(Counter(clusters))


# What are the centers?
#Xcenters = svd.inverse_transform(km.cluster_centers_)
# Do this if we're not using the Principal components
Xcenters = km.cluster_centers_

# An index of which terms have the largest coefficients
# in each cluster
bigindex = np.argsort(Xcenters)
for i in range(K):
    # The 3 most important terms in each cluster
    print(terms[bigindex[i, :]][-5:])

# Let's look at 4 random documents from cluster 1
#g = clusters == 1
#gdocs = corpus[g]
#np.random.choice(gdocs, size=4, replace=True)
