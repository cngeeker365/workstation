from types import MethodType


class Student(object):
    pass


s = Student()
s.name = 'Michael'  # 动态给实例绑定一个属性


def set_age(self, age):  # 定义一个函数作为实例方法
    self.age = age


s.set_age = MethodType(set_age, s)  # 给实例绑定一个方法，仅影响当前实例
s.set_age(25)  # 调用实例方法
print(s.age)


def set_score(self, score):
    self.score = score


Student.set_score = set_score   # 为了给所有实例都绑定方法，可以给class绑定方法

# Python允许在定义class的时候，定义一个特殊的__slots__变量，来限制该class实例能添加的属性


class Student2(object):
    __slots__ = ('name', 'age')  # 用tuple定义允许绑定的属性名称


s2 = Student2()  # 创建新的实例
s2.name = 'Michael'  # 绑定属性'name'
s2.age = 25  # 绑定属性'age'
# s2.score = 99  # 绑定属性'score'，不会成功


class GraduateStudent(Student2):
    pass


# 使用__slots__要注意，__slots__定义的属性仅对当前类实例起作用，对继承的子类是不起作用的
g = GraduateStudent()
g.score = 9999
