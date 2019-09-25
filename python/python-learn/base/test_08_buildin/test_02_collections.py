from collections import namedtuple, deque, defaultdict, OrderedDict, ChainMap, Counter
import os
import argparse

'''
namedtuple
'''
Point = namedtuple('Point', ['x', 'y'])
p = Point(1, 2)
print(p)
print(p.x, p.y)
print(isinstance(p, Point))
print(isinstance(p, tuple))

# namedtuple('名称', [属性list])
# 如果要用坐标和半径表示一个圆
Circle = namedtuple('Circle', ['x', 'y', 'r'])

'''
deque:
    1. 使用list存储数据时，按索引访问元素很快，但是插入和删除元素就很慢了，因为list是线性存储，数据量大的时候，插入和删除效率很低
    2. deque是为了高效实现插入和删除操作的双向列表，适合用于队列和栈
    3. deque除了实现list的append()和pop()外，还支持appendleft()和popleft()，这样就可以非常高效地往头部添加或删除元素。
'''
q = deque(['a', 'b', 'c'])
q.append('x')
q.appendleft('y')
print(q)

'''
defaultdict
'''
dd = defaultdict(lambda: 'N/A')
dd['key1'] = 'abc'
print(dd['key1'])
print(dd['key2'])

'''
OrderedDict
    1. Key会按照插入的顺序排列 
'''
d = dict([('a', 1), ('b', 2), ('c', 3)])    # dict的Key是无序的
print(d)
od = OrderedDict([('a', 1), ('b', 2), ('c', 3)])    # OrderedDict的Key是有序的
od['z'] = 1
od['y'] = 2
od['x'] = 3
print(od)
print(list(od.keys()))

'''
OrderedDict可以实现一个FIFO（先进先出）的dict，当容量超出限制时，先删除最早添加的Key
'''


class LastUpdatedOrderedDict(OrderedDict):

    def __init__(self, capacity):
        super(LastUpdatedOrderedDict, self).__init__()
        self._capacity = capacity

    def __setitem__(self, key, value):
        containsKey = 1 if key in self else 0
        if len(self) - containsKey >= self._capacity:
            last = self.popitem(last=False)
            print('remove:', last)
        if containsKey:
            del self[key]
            print('set:', (key, value))
        else:
            print('add:', (key, value))
        OrderedDict.__setitem__(self, key, value)


'''
ChainMap:
    1. ChainMap可以把一组dict串起来并组成一个逻辑上的dict。ChainMap本身也是一个dict，但是查找的时候，会按照顺序在内部的dict依次查找。
    2. 什么时候使用ChainMap最合适？举个例子：
        应用程序往往都需要传入参数，参数可以通过命令行传入，可以通过环境变量传入，还可以有默认参数。
        可以用ChainMap实现参数的优先级查找，即先查命令行参数，如果没有传入，再查环境变量，如果没有，就使用默认参数。
    3. 命令行参数 > 环境变量 > 默认
'''
# 构造缺省参数:
defaults = {
    'color': 'red',
    'user': 'guest'
}

# 构造命令行参数:
parser = argparse.ArgumentParser()
parser.add_argument('-u', '--user')
parser.add_argument('-c', '--color')
namespace = parser.parse_args()
command_line_args = {k: v for k, v in vars(namespace).items() if v}

# 组合成ChainMap:
combined = ChainMap(command_line_args, os.environ, defaults)

# 打印参数:
print('color=%s' % combined['color'])
print('user=%s' % combined['user'])

'''
Counter:
    1. 一个简单的计数器
    2. 实际上也是dict的一个子类
'''
c = Counter()
for ch in 'programming':
    c[ch] = c[ch] + 1

print(c)
