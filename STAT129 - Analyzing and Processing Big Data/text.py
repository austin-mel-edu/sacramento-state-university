#IMPORT LIBRARIES
from sklearn.feature_extraction.text import CountVectorizer
import nltk
from nltk.corpus import stopwords
from nltk.stem.snowball import EnglishStemmer
from sklearn.feature_extraction.text import TfidfTransformer

#GIVEN
corpus = [
        "It's going to be raining tomorrow",
        "Rain, rain, go away",
        "It's rainy, so let's go to the library",
]

# What does each column in the matrix (feature) represent?
#cv0.get_feature_names_out()

#STEMMING AND REMOVING STOP WORDS FROM CORPUS
stemmer = EnglishStemmer()
analyzer = CountVectorizer().build_analyzer()

#REMOVES ANY STOPWORDS AND REDUCES EACH WORD TO ITS STEM
def stemmed_words(doc):
    #nltk.download('stopwords')
    stopwordz = set(stopwords.words('english'))
    docwords = [stemmer.stem(w) for w in analyzer(doc)]
    return [x for x in docwords if x not in stopwordz]

#STEMMED VERSION OF DOC1
stemmed_words(corpus[0])
#STEMMED VERSION OF DOC2
stemmed_words(corpus[1])
#STEMMED VERSION OF DOC3
stemmed_words(corpus[2])

#CREATE OBJECT REPRESENTING MODEL
cv1 = CountVectorizer(analyzer=stemmed_words)
#FIT IT TO OUR DATA
cv1.fit(corpus)
print(cv1.get_feature_names_out())

transformer = TfidfTransformer()
#MATRIX OF THE COUNTS OF EACH TERM
counts = cv1.transform(corpus)
#CREATE TFIDF MATRIX
tfidf = transformer.fit_transform(counts)

#PRINT TFIDF MATRIX IN DENSE FORM
print(tfidf.todense())
