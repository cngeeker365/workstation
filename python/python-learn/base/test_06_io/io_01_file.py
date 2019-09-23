'''
open()函数返回的这种有个read()方法的对象，在Python中统称为file-like Object。
除了file外，还可以是内存的字节流，网络流，自定义流等等。
StringIO就是在内存中创建的file-like Object，常用作临时缓冲。
'''
with open('/path/to/file', 'r') as f:
    print(f.read())
    '''
    如果文件很小，read()一次性读取最方便；
    如果不能确定文件大小，反复调用read(size)比较保险；
    如果是配置文件，调用readlines()最方便
    '''
    for line in f.readlines():
        print(line.strip())  # 把末尾的'\n'删掉

'''
要读取二进制文件，比如图片、视频等等，用'rb'模式打开文件即可
'''
f = open('/Users/michael/test.jpg', 'rb')
f.read()

'''
要读取非UTF-8编码的文本文件，需要给open()函数传入encoding参数，例如，读取GBK编码的文件
'''
f = open('/Users/michael/gbk.txt', 'r', encoding='gbk')
f.read()

# open()函数还接收一个errors参数，表示如果遇到编码错误后如何处理。最简单的方式是直接忽略：
f = open('/Users/michael/gbk.txt', 'r', encoding='gbk', errors='ignore')

'''
w模式：写入时，若文件存在，则覆盖
a模式：以追加模式写入
'''
with open('/Users/michael/test.txt', 'w') as f:
    f.write('Hello, world!')
