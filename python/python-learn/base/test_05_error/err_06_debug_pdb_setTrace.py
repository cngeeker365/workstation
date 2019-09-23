# err.py
import pdb

s = '0'
n = int(s)
pdb.set_trace()  # 程序会自动在 pdb.set_trace()暂停并进入pdb调试环境，可以用命令p查看变量，或者用命令c继续运行
print(10 / n)
