import pickle as pkl
import numpy as np
file  = open('D:\java_neno_workspace\Map\maptable.txt')
file_label = open('D:\java_neno_workspace\Map\label.txt')
data_with_label = [] # sotre the each line with their labels
#data = [] # the data will be duumpped into the pkl file
list_total = [] # the list to store the whole file
list_line = [] # the list to store each sentence
list_label = []
#Load the file into the memory
for each_line in file:
    print(each_line + 'content of each line', end=':')
    list_line = each_line.split(',')
    print(len(list_line))
    #print(list_line + '----The content of the list')
    list_line.remove('\n')
    list_total.append(list_line)


#Check the the load process
for sentence in list_total:
    for word in sentence:
        print(word, end=',')
    print('\n')
print(list_total)
total = np.array(list_total)
data_with_label.append(total)

#load the labels of each lines
for each_label in file_label:
    print('The label of the line is:' + each_label)
    #each_label.remove('\n')
    list_label.append(each_label.strip())
print(list_label)
label = np.array(list_label)
data_with_label.append(label)

#data_with_label.append(list_total)
#data_with_label.append(list_label)
#make the pkl file
with open('subject.pkl','wb') as output:
    pkl.dump(data_with_label,output)

#check the dump process
f = open('subject.pkl','rb')
info = np.array(pkl.load(f))
print('The content in the file:')
print(info)   #show file

x,y = info
print('The final result:')
print(x)
print(y)
