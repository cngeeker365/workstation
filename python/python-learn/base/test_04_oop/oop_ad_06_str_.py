class Student(object):
    def __init__(self, name):
        self.name = name

    def __str__(self):
        return 'Student object (name: %s)' % self.name

    __repr__ = __str__  # 通常__str__()和__repr__()代码都是一样的

    # __call__()方法：直接对实例进行调用
    def __call__(self):
        print('My name is %s.' % self.name)


print(Student('Michael'))  # 调用的是 __str__()
s = Student('Michael')
s()     # 调用 __call__()
# s     # 调用的是 __repr__()，

# 怎么判断一个变量是对象还是函数呢？
# 其实，更多的时候，需要判断一个对象是否能被调用，能被调用的对象就是一个Callable对象，比如函数和我们上面定义的带有__call__()的类实例
# 通过callable()函数，我们就可以判断一个对象是否是“可调用”对象
print(callable(s))
callable(max)

'''
如果一个类想被用于for ... in循环，类似list或tuple那样，就必须实现一个__iter__()方法，该方法返回一个迭代对象，
然后，Python的for循环就会不断调用该迭代对象的__next__()方法拿到循环的下一个值，直到遇到StopIteration错误时退出循环
'''


class Fib(object):
    def __init__(self):
        self.a, self.b = 0, 1                       # 初始化两个计数器a，b

    def __iter__(self):
        return self                                 # 实例本身就是迭代对象，故返回自己

    def __next__(self):
        self.a, self.b = self.b, self.a + self.b    # 计算下一个值
        if self.a > 100000:  # 退出循环的条件
            raise StopIteration()
        return self.a  # 返回下一个值

    def __getitem__(self, n):                       # 像 list 一样 按照下标取出元素
        if isinstance(n, int):      # n是索引
            a, b = 1, 1
            for x in range(n):
                a, b = b, a + b
            return a
        if isinstance(n, slice):    # n是切片
            start = n.start
            stop = n.stop
            if start is None:
                start = 0
            a, b = 1, 1
            L = []
            for x in range(stop):
                if x >= start:
                    L.append(a)
                a, b = b, a + b
            return L


for n in Fib():
    print(n)

f = Fib()
print(f[0])
print(f[1])
print(f[2])
print(f[0:5])
print(f[:10:2])


class Chain(object):

    def __init__(self, path=''):
        self._path = path

    # 只有在没有找到属性的情况下，才调用__getattr__，已有的属性不会在__getattr__中查找
    # __getattr__默认返回就是None，要让class只响应特定的几个属性，就要按照约定，抛出AttributeError的错误
    # 支持 REST API 的动态链式调用，感觉有点类似于动态路由
    def __getattr__(self, path):
        return Chain('%s/%s' % (self._path, path))

    def __str__(self):
        return self._path

    __repr__ = __str__


print(Chain().status.user.timeline.list)
# TODO: 如何写出 /users/:user/repos 调用？
# print(Chain().users('michael').repos)
