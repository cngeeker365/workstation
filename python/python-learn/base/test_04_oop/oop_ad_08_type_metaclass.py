def fn(self, name='world'):  # 先定义函数
    print('Hello, %s.' % name)


'''
1. 创建一个class对象，type()函数依次传入3个参数：
    1. class的名称；
    2. 继承的父类集合，注意Python支持多重继承，如果只有一个父类，别忘了tuple的单元素写法；
    3. class的方法名称与函数绑定，这里我们把函数fn绑定到方法名hello上
2. 通过type()函数创建的类和直接写class是完全一样的，因为Python解释器遇到class定义时，仅仅是扫描一下class定义的语法，然后调用type()函数创建出class
3. type()函数允许动态创建出类来, 动态语言本身支持运行期动态创建类; 要在静态语言运行期创建类，必须构造源代码字符串再调用编译器生成字节码实现，本质上都是动态编译，会非常复杂
'''

Hello = type('Hello', (object,), dict(hello=fn))  # 创建Hello class

h = Hello()
h.hello()
print(type(Hello))
print(type(h))

'''
----------------------------------------------------------------------------------------------------------------------------
metaclass，直译为元类，允许你创建类或者修改类。可以把类看成是metaclass创建出来的“实例”。先定义metaclass，就可以创建类，最后创建实例。
----------------------------------------------------------------------------------------------------------------------------
'''

# 例子: 通过 metaclass 给 MyList 增加一个add方法：
# metaclass是类的模板，所以必须从`type`类型派生：


class ListMetaclass(type):      # 按照默认习惯，metaclass的类名总是以Metaclass结尾，以便清楚地表示这是一个metaclass
    # __new__()方法接收到的参数依次是：
    #     1. 当前准备创建的类的对象；
    #     2. 类的名字；
    #     3. 类继承的父类集合；
    #     4. 类的方法集合
    def __new__(cls, name, bases, attrs):
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, bases, attrs)


# 在定义类的时候指示使用ListMetaclass来定制类，传入关键字参数metaclass
class MyList(list, metaclass=ListMetaclass):
    pass


L = MyList()
L.add(1)
print(L)

# list没有add()方法
L2 = list()
L2.append(1)
print(L2)


'''
----------------------------------------------------------------------------------------------------------------------------
动态修改有什么意义？
    1. 正常情况下，确实应该直接写，但是，ORM就是一个需要通过metaclass修改类定义的典型的例子。
    2. 要编写一个ORM框架，所有的类都只能动态定义，因为只有使用者才能根据表的结构定义出对应的类来。
----------------------------------------------------------------------------------------------------------------------------
'''


class Field(object):
    def __init__(self, name, column_type):
        self.name = name
        self.column_type = column_type

    def __str__(self):
        return '<%s:%s>' % (self.__class__.__name__, self.name)


class StringField(Field):
    def __init__(self, name):
        super(StringField, self).__init__(name, 'varchar(100)')


class IntegerField(Field):
    def __init__(self, name):
        super(IntegerField, self).__init__(name, 'bigint')


class ModelMetaclass(type):
    def __new__(cls, name, bases, attrs):
        if name == 'Model':
            return type.__new__(cls, name, bases, attrs)
        print('Found model: %s' % name)
        mappings = dict()
        for k, v in attrs.items():
            if isinstance(v, Field):
                print('Found mapping: %s ==> %s' % (k, v))
                mappings[k] = v
        for k in mappings.keys():
            attrs.pop(k)
        attrs['__mappings__'] = mappings  # 保存属性和列的映射关系
        attrs['__table__'] = name  # 假设表名和类名一致
        return type.__new__(cls, name, bases, attrs)


class Model(dict, metaclass=ModelMetaclass):

    def __init__(self, **kw):
        super(Model, self).__init__(**kw)

    def __getattr__(self, key):
        try:
            return self[key]
        except KeyError:
            raise AttributeError(r"'Model' object has no attribute '%s'" % key)

    def __setattr__(self, key, value):
        self[key] = value

    def save(self):
        fields = []
        params = []
        args = []
        for k, v in self.__mappings__.items():
            fields.append(v.name)
            params.append('?')
            args.append(getattr(self, k, None))
        sql = 'insert into %s (%s) values (%s)' % (
            self.__table__, ','.join(fields), ','.join(params))
        print('SQL: %s' % sql)
        print('ARGS: %s' % str(args))


class User(Model):
    # 定义类的属性到列的映射：
    id = IntegerField('id')
    name = StringField('username')
    email = StringField('email')
    password = StringField('password')


# 创建一个实例：
u = User(id=12345, name='Michael', email='test@orm.org', password='my-pwd')
# 保存到数据库：
u.save()
