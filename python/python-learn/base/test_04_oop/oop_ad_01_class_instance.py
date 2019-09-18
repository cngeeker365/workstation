# 在Python中，变量名类似__xxx__的，也就是以双下划线开头，并且以双下划线结尾的，是特殊变量，特殊变量是可以直接访问的，不是private变量
class Student(object):
    name = 'Student'    # 类属性

    def __init__(self, name, score):
        # private 变量，不能直接访问__name是因为Python解释器对外把__name变量改成了_Student__name
        self.__name = name
        self.__score = score


bart = Student('Bart Simpson', 59)
lisa = Student('Lisa Simpson', 87)
bart.age = 8
print(bart.age)
# print(lisa.age)   # Python允许对实例变量绑定任何数据，也就是说，对于两个实例变量，虽然它们都是同一个类的不同实例，但拥有的变量名称都可能不同

print(bart._Student__name)

# 设置__name变量！外部代码“成功”地设置了__name变量，但实际上这个__name变量和class内部的__name变量不是一个变量！
bart.__name = 'New Name'

print(bart.name)    # 打印类的name属性
bart.name = 'Bart'  # 给实例绑定name属性
print(bart.name)    # 由于实例属性优先级比类属性高，因此，它会屏蔽掉类的name属性
print(Student.name)  # 但是类属性并未消失，用Student.name仍然可以访问
del bart.name       # 如果删除实例的name属性
print(bart.name)    # 再次调用s.name，由于实例的name属性没有找到，类的name属性就显示出来了
