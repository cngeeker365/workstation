# 高阶函数
from functools import reduce

# Python内建了map()和reduce()函数
# +--- map()函数接收两个参数，一个是函数，一个是Iterable，map将传入的函数依次作用到序列的每个元素，并把结果作为新的Iterator返回
# +--- reduce把一个函数作用在一个序列[x1, x2, x3, ...]上，函数接收两个参数，reduce把结果继续和序列的下一个元素做累积计算，其效果就是：reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4)


def f(x):
    return x * x


# map()传入的第一个参数是f，即函数对象本身。由于结果r是一个Iterator，Iterator是惰性序列，因此通过list()函数让它把整个序列都计算出来并返回一个list。
r = map(f, [1, 2, 3, 4, 5, 6, 7, 8, 9])
print(list(r))


def add(x, y):
    return x + y


r = reduce(add, [1, 3, 5, 7, 9])
print(r)


DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4,
          '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}


def str2int_1(s):
    def fn(x, y):
        return x * 10 + y

    def char2num(s):
        return DIGITS[s]
    return reduce(fn, map(char2num, s))


def char2num(s):
    return DIGITS[s]


def str2int_2(s):
    return reduce(lambda x, y: x * 10 + y, map(char2num, s))
