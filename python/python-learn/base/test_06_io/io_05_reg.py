'''
@Description: In User Settings Edit
@Author: your name
@Date: 2019-09-24 22:17:41
@LastEditTime: 2019-09-24 22:45:16
@LastEditors: Please set LastEditors
'''
import re

print(re.match(r'^\d{3}\-\d{3,8}$', '010-12345'))
print(re.match(r'^\d{3}\-\d{3,8}$', '010 12345'))

if re.match(r'^\d{3}\-\d{3,8}$', '010-12345'):
    print(re.match(r'^\d{3}\-\d{3,8}$', '010-12345').group())
    print("ok")
else:
    print("failed")

# 无法识别连续的空格，用正则表达式进行切分
print(re.split(r'\s+', 'a b   c'))
print(re.split(r'[\s\,]+', 'a,b, c  d'))
print(re.split(r'[\s\,\;]+', 'a,b;; c  d'))

# 分组
'''
如果正则表达式中定义了组，就可以在Match对象上用group()方法提取出子串来
注意到group(0)永远是原始字符串，group(1)、group(2)……表示第1、2、……个子串
'''
m = re.match(r'^(\d{3})-(\d{3,8})$', '010-12345')
print(m.group()[0])
print(m.group()[1])
print(m.group()[2])

t = '19:05:30'
m = re.match(r'^(0[0-9]|1[0-9]|2[0-3]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])$', t)
print(m.groups())

'''
编译
当我们在Python中使用正则表达式时，re模块内部会干两件事情：
    1. 编译正则表达式，如果正则表达式的字符串本身不合法，会报错；
    2. 用编译后的正则表达式去匹配字符串。
如果一个正则表达式要重复使用几千次，出于效率的考虑，我们可以预编译该正则表达式，接下来重复使用时就不需要编译这个步骤了，直接匹配：
'''
# 编译:
re_telephone = re.compile(r'^(\d{3})-(\d{3,8})$')
# 使用：
print(re_telephone.match('010-12345').groups())
print(re_telephone.match('010-8086').groups())