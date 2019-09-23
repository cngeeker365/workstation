from io import StringIO, BytesIO

'''
StringIO顾名思义就是在内存中读写str
'''
f_1 = StringIO()
f_1.write('hello')
f_1.write(' ')
f_1.write('world!')

print(f_1.getvalue())

f_2 = StringIO('Hello!\nHi!\nGoodbye!')
while True:
    s = f_2.readline()
    if s == '':
        break
    print(s.strip())

'''
BytesIO实现了在内存中读写bytes二进制数据
'''
f_3 = BytesIO()
f_3.write('中文'.encode('utf-8'))
print(f_3.getvalue())

f_4 = BytesIO(b'\xe4\xb8\xad\xe6\x96\x87')
print(f_4.read().decode('utf-8'))
