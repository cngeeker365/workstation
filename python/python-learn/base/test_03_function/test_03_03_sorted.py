# Python内置的sorted()函数就可以对list进行排序:
# +-- 参数1：待排序数据
# +-- 参数2：key函数来实现自定义的排序
# +-- 参数3：reverse=True|False
print(sorted([36, 5, -12, 9, -21]))
print(sorted([36, 5, -12, 9, -21], key=abs))
print(sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower))                 # 忽略大小写排序
print(sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower, reverse=True))   # 反向排序
