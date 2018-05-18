import csv
import jieba
import jieba.analyse
list = []
#f = open('test_record.csv',encoding='utf-8')
f = open ('record.csv',encoding = 'utf-8')
csv_reader = csv.reader(f)
i = 0;
for row in csv_reader:
    list.insert(i,row)
    i = i+ 1
    print(row)
print("The content in List \n")
for each_item in list:
    print(each_item)

#print("The 2nd item in each row")
out = open("media_record.txt",'a',encoding = "utf-8")
#将每行的文本切割
for each_row in list:
    print(each_row[1])
    content = each_row[1]
    seg_list = jieba.cut(content)
    print("The cut result of each 2nd item")
    #print(seg_list)
    test_list = "/".join(seg_list)
    print(test_list)
    out.write(test_list)
    result = test_list.split('/')
    print(result[0] + "the 1st")
    #print(seg_list[0])
    print("\n")
    out.write("\n")

"""
#关键词提取TF-IDF
content2 = open("record_text.csv","rb").read()
tags_ifidf = jieba.analyse.extract_tags(content2,topK=5000)
result1 = "/".join(tags_ifidf)
print(result1)

resultSplit = result1.split("/")
out = open("new_draft_ifidf.csv",'a',newline='\n')
csv_writer = csv.writer(out, dialect='excel')
csv_writer.writerow(resultSplit)


#关键词提取TextRank
#content3 = open("record_text.csv","rb").read()
tags_textrank = jieba.analyse.textrank(content2,topK=100000)
result2 = "/".join(tags_textrank)
print(result2)

resultSplit2 = result2.split("/")
out = open("new_draft_textRank.csv",'a',newline='\n')
csv_writer = csv.writer(out, dialect='excel')
csv_writer.writerow(resultSplit2)

#file = open("new_custom_dict.csv",encoding = 'utf-8')

"""