import csv
import jieba
import logging
import time

time = time.time()
time = str(time)
name = time + '.log'
logging.basicConfig(filename=name, filemode="w", level=logging.DEBUG)

list = []
f = open('record.csv',encoding='utf-8')
csv_reader = csv.reader(f)
i = 0;
for row in csv_reader:
    list.insert(i,row)
    i = i+ 1
    print(row)
print("The content in List \n")
for each_item in list:
    print("Each row in the file\n")
    print(each_item)


#将每行的文本切割
#jieba.load_userdict("custom_dict.txt")
for each_row in list:
    print(each_row[1])
    content = each_row[1]
    seg_list = jieba.cut(content)
    logging.info("The cut result of each 2nd item")
    #print("The cut result of each 2nd item")
    test_list = "/".join(seg_list)
    logging.info(test_list)
    #print(test_list)
    result = test_list.split('/')
    logging.info(result[0] + "the 1st"+ "\n")
    #print(result[0] + "the 1st")
    #print("\n")