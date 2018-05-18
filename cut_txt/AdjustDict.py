import jieba
jieba.load_userdict("dict.txt")
jieba.add_word('卡')
jieba.del_word('滋卡')