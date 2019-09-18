import functools

# functools.partial的作用就是，把一个函数的某些参数给固定住（也就是设置默认值），返回一个新的函数，调用这个新函数会更简单
int2 = functools.partial(int, base=2)

print(int2('1000000'))
print(int2('1000000', base=10))


args = (5, 6, 7)
max2 = functools.partial(max, 10)
print(max2(*args))
