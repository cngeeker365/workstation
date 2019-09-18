# filter()函数用于过滤序列
# filter()接收一个函数和一个序列, filter()把传入的函数依次作用于每个元素，然后根据返回值是True还是False决定保留还是丢弃该元素


def is_odd(n):
    return n % 2 == 1


# filter()函数返回的是一个Iterator，也就是一个惰性序列，所以要强迫filter()完成计算结果，需要用list()函数获得所有结果并返回list
print(list(filter(is_odd, [1, 2, 4, 5, 6, 9, 10, 15])))


# 计算素数____埃氏筛法
#   1. 构造一个从3开始的奇数序列
#   2. 定义一个筛选函数
#   3. 定义一个生成器，不断返回下一个素数


def _odd_iter():
    n = 1
    while True:
        n = n + 2
        yield n


def _not_divisible(n):
    return lambda x: x % n > 0


def primes():
    yield 2
    it = _odd_iter()  # 初始序列
    while True:
        n = next(it)  # 返回序列的第一个数
        yield n
        it = filter(_not_divisible(n), it)  # 构造新序列


# 打印1000以内的素数:
for n in primes():
    if n < 1000:
        print(n)
    else:
        break
