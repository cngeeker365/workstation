from enum import Enum, unique
# from oop_ad_06_str_ import Student

Month = Enum('Month', ('Jan', 'Feb', 'Mar', 'Apr', 'May',
                       'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'))

# print(Month._member_names_)
# print(Month._value2member_map_)

for name, member in Month.__members__.items():
    print(name, '=>', member, ',', member.value)


@unique     # @unique装饰器可以帮助我们检查保证没有重复值
class Weekday(Enum):
    Sun = 0  # Sun的value被设定为0
    Mon = 1
    Tue = 2
    Wed = 3
    Thu = 4
    Fri = 5
    Sat = 6


print(Weekday.Mon)
print(Weekday['Mon'])
print(Weekday.Mon.name)
print(Weekday.Mon.value)
print(Weekday(1))
print(type(Weekday.Mon))
print(type(Weekday.Mon.value))
print(type(Weekday.Mon.name))

'''
stu = Student("haha")
print(stu)
# class的定义是运行时动态创建的，而创建class的方法就是使用type()函数
print(type(stu))
'''
