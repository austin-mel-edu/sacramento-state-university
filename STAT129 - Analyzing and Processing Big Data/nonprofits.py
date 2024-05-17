import os
import re
import random
from multiprocessing import Pool
from lxml import etree
from copy import deepcopy
import pandas as pd
import seaborn as sns

datadir = "/stat129/all990files/"
all990 = [datadir + p for p in os.listdir(datadir)]

#n = 6000
#random.seed(1029)
#s990 = random.sample(all990, n)

#xmlfile = s990[0]

fields900 = ["CYTotalRevenueAmt","TaxYr","EIN","BusinessNameLine1Txt","MissionDesc"]

#DEPENDING ON FIELD BEING SEARCHED FOR, TRY DIFFERENT BRANCHES ON THE XPATH TREE TO FIND DATA
def tryparse(field):
    #print(field)
    if "CYTotalRevenueAmt" == field:
        xpath = "/Return/ReturnData/IRS990/"
    elif "MissionDesc" == field:
        xpath = "/Return/ReturnData/IRS990/"
    elif "TaxYr" == field:
        xpath = "/Return/ReturnHeader/"
    elif "EIN" == field:
        xpath = "/Return/ReturnHeader/Filer/"
    elif "BusinessNameLine1Txt" == field:
        xpath = "/Return/ReturnHeader/Filer/BusinessName/"
    else:
        return None

    return xpath

#EXTRACT FUNCTION
def extract(xmlfile):
    tree = etree.parse(xmlfile)
    fields990 = ["CYTotalRevenueAmt","TaxYr","EIN","BusinessNameLine1Txt","MissionDesc"]
    
    #SPECIFICALLY GET MISSION DESCRIPTION
    mission = tree.xpath("//MissionDesc/text()")


    if not mission:
        return None
    mission = mission[0]

    #USE RE TO FIND ALL NONPROFITS WITH "ANIMAL SHELTER" IN THEIR MISSION DESCRIPTION
    pattern = r"ANIMAL SHELTER"
    if not re.search(pattern, mission, flags=re.IGNORECASE):
        return None


    result = {}
    
    for f in fields990:
        xpath = tryparse(f)
        try:
            result[f] = tree.xpath(xpath + f + "/text()")[0]
        except:
            #Result not in XPATH location
            pass
    return result

#MULTITHREADING POOL
with Pool(10) as p:
    data = p.map(extract, all990)

#SAMPLE SUBSET OF 990 FILES
#data = [extract(x) for x in s990]

datacopy = deepcopy(data)

#REMOVE ALL NONE VALUES FROM DATA
datasubset = [x for x in datacopy if x is not None]

#CONVERT DATA TO CORRECT DATATYPES (INT)
for x in datasubset:
    for k, v in x.items():
        if k in {"TaxYr","CYTotalRevenueAmt", "EIN"}:
            x[k] = int(v)

#print(datasubset)

#LIST OF NONPROFITS WITH 990S IN THE YEAR 2023
curryear = [x for x in datasubset if x["TaxYr"] == 2020]
#SORT THIS NEW LIST BY REVENUE AMOUNT
curryear.sort(key = lambda x: x["CYTotalRevenueAmt"])

#GET IDS OF 5 NONPROFITS WITH HIGHEST (LAST) REVENUE AMOUNTS
high_rev_ids = {x["EIN"] for x in curryear[-5:]}
#print(high_rev_ids)

#GET ALL 990 DATA OF THE 5 NONPROFITS FOUND IN LAST LIST
finaldataset = [x for x in datasubset if x["EIN"] in high_rev_ids]


#CONVERT DATA TO DATAFRAME FOR PANDAS
d = pd.DataFrame(finaldataset)
#print(d)

#CREATE PLOT
ax = sns.lineplot(x = "TaxYr",
                  y = "CYTotalRevenueAmt",
                  hue = "BusinessNameLine1Txt",
                 data = d)

ax.figure.savefig("nonprofits.pdf")




