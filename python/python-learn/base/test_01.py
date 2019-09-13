def factorial(n):
    '''return n!'''
    return 1 if n < 2 else n*factorial(n-1)


fact = factorial
print(list(map(fact, range(10))))
print([fact(n) for n in range(10)])
print(list(map(factorial, filter(lambda n: n % 2, range(6)))))
print([factorial(n) for n in range(6) if n % 2])

fruits = ['strawberry', 'fig', 'apple', 'cherry', 'raspberry', 'banana']
print(sorted(fruits, key=len))

'''
    a[::-1]切片法。
    第一个: 表示的是切片的区间，如果没有设定数值，默认是全部区间；
    第二个：表示的是切片的步数和方向，默认为切片方向为从前向后，默认步数为1.上面的-1，代表的就是从后向前，一次往前切一次，也就是刚好倒置列表
'''


def reverse(word):
    return word[::-1]


print(reverse('testing'))


def myfun():
    return 1, 2, 3


print(myfun())
