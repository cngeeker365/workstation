import os

print(os.name)  # 如果是posix，说明系统是Linux、Unix或Mac OS X，如果是nt，就是Windows系统
# print(os.uname())   # 要获取详细的系统信息，可以调用uname()函数。注意uname()函数在Windows上不提供

# print(os.environ)
print(os.environ.get('PATH'))
print(os.environ.get('xxx', 'default'))

# 查看当前目录的绝对路径, 把两个路径合成一个时，不要直接拼字符串，而要通过os.path.join()函数，这样可以正确处理不同操作系统的路径分隔符。
print(os.path.abspath('.'))
# 在某个目录下创建一个新目录，首先把新目录的完整路径表示出来:
os.path.join('/Users/michael', 'testdir')
# 然后创建一个目录:
os.mkdir('/Users/michael/testdir')
# 删掉一个目录:
os.rmdir('/Users/michael/testdir')
# 要拆分路径时，也不要直接去拆字符串，而要通过os.path.split()函数，这样可以把一个路径拆分为两部分，后一部分总是最后级别的目录或文件名
os.path.split('/Users/michael/testdir/file.txt')
# os.path.splitext()可以直接让你得到文件扩展名
os.path.splitext('/path/to/file.txt')

# 对文件重命名:
os.rename('test.txt', 'test.py')
# 删掉文件:
os.remove('test.py')

# 列出当前目录下的所有目录
print([x for x in os.listdir('.') if os.path.isdir(x)])
# 列出所有的.py文件
print([x for x in os.listdir('.') if os.path.isfile(x) and os.path.splitext(x)[1] == '.py'])
