# 多重继承
class Animal(object):
    pass

# 大类:哺乳类和鸟类


class Mammal(Animal):
    pass


class Bird(Animal):
    pass

# 功能定义


class Runnable(object):
    def run(self):
        print('Running...')


class Flyable(object):
    def fly(self):
        print('Flying...')

# 各种动物:(MixIn 设计模式)


class Dog(Mammal, Runnable):
    pass


class Bat(Mammal, Flyable):
    pass


class Parrot(Bird, Flyable):
    pass


class Ostrich(Bird, Runnable):
    pass
