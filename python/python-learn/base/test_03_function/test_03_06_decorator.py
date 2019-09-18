import functools

# decorator就是一个返回函数的高阶函数


def now_1():
    print('2015-3-25')


def log(func):                                  # 定义一个能打印日志的decorator
    # wrapper()函数的参数定义是(*args, **kw)，因此，wrapper()函数可以接受任意参数的调用
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper


@log    # @log放到 now_2()函数的定义处，相当于执行了语句 now_2 = log(now_2)
def now_2():
    print('2015-3-25')


def log_param(text):
    def decorator(func):
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator


@log_param('execute')
def now_3():
    print('2015-3-25')


now_1()
now_2()
now_3()


def log_wraps(func):
    @functools.wraps(func)
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper


def log_decorator(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator


@log_wraps
def now_4():
    print('2015-3-25')


@log_decorator('decorator')
def now_5():
    print('2015-3-25')


print(now_3.__name__)   # 经过decorator装饰之后的函数，它们的__name__已经从原来的'now_*'变成了'wrapper'
print(now_4.__name__)   # Python内置的functools.wraps 完成 wrapper.__name__ = func.__name__
print(now_5.__name__)   # 针对带参数的decorator，也可以将 __name__修正
