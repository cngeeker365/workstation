# 关键字lambda表示匿名函数
# 匿名函数有个限制，就是只能有一个表达式，不用写return，返回值就是该表达式的结果
# 匿名函数也是一个函数对象，也可以把匿名函数赋值给一个变量，再利用变量来调用该函数

# 匿名函数lambda x: x * x
print(list(map(lambda x: x * x, [1, 2, 3, 4, 5, 6, 7, 8, 9])))

f = lambda x: x * x
print(f(5))


def build(x, y):
    return lambda: x * x + y * y    # 可以把匿名函数作为返回值返回
