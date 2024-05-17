#IMPORT LIBRARIES
import pandas as pd
import numpy as np
from sklearn.feature_extraction.text import CountVectorizer
import nltk
from nltk.corpus import stopwords
from nltk.stem.snowball import SnowballStemmer
from sklearn.feature_extraction.text import TfidfTransformer

df = pd.read_csv("descriptions.csv")
corpus = df["mission"]
#print(corpus)

#DETERMINE NUMBER OF ROWS/DOCS (6454)
#print(len(corpus))

#STEMMING AND REMOVING STOP WORDS FROM CORPUS
stemmer = SnowballStemmer("english",ignore_stopwords=True)
analyzer = CountVectorizer().build_analyzer()

#REMOVES ANY STOPWORDS AND REDUCES EACH WORD TO ITS STEM
def stemmed_words(doc):
    #nltk.download('stopwords')
    stopwordz = set(stopwords.words('english'))
    docwords = [stemmer.stem(w) for w in analyzer(doc)]
    return [x for x in docwords if x not in stopwordz]

def all_words(doc):
    return [x for x in doc]

#CREATE OBJECT REPRESENTING MODEL
cv1 = CountVectorizer(analyzer=stemmed_words)
cv2 = CountVectorizer()
#FIT IT TO OUR DATA
#cv1.fit(corpus)

#CREATE SPARSE MATRIX
sparse = cv1.fit_transform(corpus)
allwords = cv2.fit_transform(corpus)

#VERIFY ROW/COL COUNT FROM ABOVE (6454 x 8247)
#print(sparse.shape)

#NUMBER OF ELEMENTS IN SPARSE MATRIX
#print(sparse.size)

#DETERMINE NUMBER OF COLUMNS/UNIQUE WORDS (8247)
#print(len(cv1.get_feature_names_out()))

#print(corpus[99])
#print(corpus[0].split())
print(stemmed_words(corpus[0]))

#DETERMINE MOST FREQUENT WORDS FOUND IN CORPUS


words = cv1.get_feature_names_out()

counts = sparse.sum(axis=0)
counts = np.ravel(counts)

rank = np.argsort(counts)
words_pop = words[rank]

#print(words_pop[-10:])



#CREATE TFIDF MATRIX
transformer = TfidfTransformer()
tfidf = transformer.fit_transform(sparse)
#print(tfidf)

#PRINT TFIDF MATRIX IN DENSE FORM
#print(tfidf.todense())
