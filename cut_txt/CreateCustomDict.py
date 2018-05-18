import csv
import jieba
import re
import jieba.analyse

#Use TextRank algorithm to select the tags
file = open('record.csv',"rb").read()
tags_textrank = jieba.analyse.textrank(file,topK=10000)
result = "/".join(tags_textrank)
resultSplit = result.split("/")
out = open("new_draft_textRank.csv",'w',newline='\n')
csv_writer = csv.writer(out, dialect='excel')
csv_writer.writerow(resultSplit)

#Read the tags in draf and replace the letters and numbers
read = open("new_draft_textrank.csv","r").read()
useful = re.sub(r"[a-zA-Z0-9]","", read)
useful = useful.split(",")

#Create the custom dict
temp= []
for each in useful:
    if each !='' and each != "," and each != ".":
        temp.append(each)

dict = "\n".join(temp)
out = open("custom_dict.txt",'w')
out.write(dict)
