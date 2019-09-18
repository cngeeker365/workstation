# import types


class Animal(object):
    def run(self):
        print('Animal is running...')


class Dog(Animal):

    def run(self):
        print('Dog is running...')

    def eat(self):
        print('Eating meat...')


class Cat(Animal):

    def run(self):
        print('Cat is running...')


dog = Dog()
dog.run()

cat = Cat()
cat.run()

a = list()      # a是list类型
b = Animal()    # b是Animal类型
c = Dog()       # c是Dog类型

print(isinstance(a, list))
print(isinstance(b, Animal))
print(isinstance(b, Dog))
print(isinstance(c, Dog))
print(isinstance(c, Animal))

'''
对于静态语言（例如Java）来说，如果需要传入Animal类型，则传入的对象必须是Animal类型或者它的子类，否则，将无法调用run()方法。
对于Python这样的动态语言来说，则不一定需要传入Animal类型。我们只需要保证传入的对象有一个run()方法就可以了.
动态语言的“鸭子类型”，它并不要求严格的继承体系，一个对象只要“看起来像鸭子，走起路来像鸭子”，那它就可以被看做是鸭子
'''


def run_twice(animal):
    animal.run()
    animal.run()


run_twice(Animal())
run_twice(Dog())
run_twice(Cat())

print(type(123))
print(type('str'))
print(type(None))
print(type(abs))
print(type(b))

# type(123) == type(456)
# type(123) == int
# type(run_twice) == types.FunctionType
# type(abs) == types.BuiltinFunctionType
# type(lambda x: x) == types.LambdaType
# type((x for x in range(10))) == types.GeneratorType

print(isinstance(c, Dog) and isinstance(c, Animal))
print((b'a').__class__)
print(isinstance(b'a', bytes))  # True

# 总是优先使用isinstance()判断类型，可以将指定类型及其子类“一网打尽”。
print(isinstance([1, 2, 3], (list, tuple)))
print(isinstance((1, 2, 3), (list, tuple)))

# dir()函数: 获得一个对象的所有属性和方法,它返回一个包含字符串的list
print(dir('ABC'))


# 在Python中，如果你调用len()函数试图获取一个对象的长度，实际上，在len()函数内部，它自动去调用该对象的__len__()方法
class MyDog(object):
    def __len__(self):
        return 100


dog = MyDog()
print(len(dog))
print(dog.__len__())


# 以下类似于反射的样子
class MyObject(object):
    def __init__(self):
        self.x = 9

    def power(self):
        return self.x * self.x


obj = MyObject()
hasattr(obj, 'x')           # 有属性'x'吗？
hasattr(obj, 'y')           # 有属性'y'吗？
setattr(obj, 'y', 19)       # 设置一个属性'y'
getattr(obj, 'z', 404)      # 获取属性'z'，如果不存在，返回默认值404
hasattr(obj, 'power')       # 有属性'power'吗？
fn = getattr(obj, 'power')  # 获取属性'power'并赋值到变量fn，fn指向obj.power
fn()


def readImage(fp):
    if hasattr(fp, 'read'):
        read = getattr(fp, 'read')
        return read()
    return None
