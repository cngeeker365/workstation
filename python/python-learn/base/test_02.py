# 列表生成器
L = [x * x for x in range(10)]
# 生成器
g = (x * x for x in range(10))
print(next(g))
print(next(g))
print(next(g))

# generator的函数，在每次调用next()的时候执行，遇到yield语句返回，再次执行时从上次返回的yield语句处继续执行


def odd():
    print('step 1')
    yield 1
    print('step 2')
    yield(3)
    print('step 3')
    yield(5)


o = odd()
print(next(o))
print(next(o))
print(next(o))


def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'


g = fib(6)
while True:
    try:
        x = next(g)
        print('g:', x)
    except StopIteration as e:
        print('Generator return value:', e.value)
        break

for n in fib(6):
    print(n)
