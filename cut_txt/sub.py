import re
import csv
import jieba
import jieba.analyse

#测试正则表达式的替换
senstence = open("new_draft_ifidf.csv","r").read()
useful = re.sub(r"[a-zA-Z0-9]","", senstence)
useful = useful.split(",")
print(useful)

temp= []


for each in useful:
    if each !='' and each != "," and each != ".":
        temp.append(each)

dict = "\n".join(temp)
out = open("custom_dict.txt",'w',encoding = "utf-8")
out.write(dict)
#csv_writer = csv.writer(out, dialect='excel')
#csv_writer.writerow(dict)
print(dict)

