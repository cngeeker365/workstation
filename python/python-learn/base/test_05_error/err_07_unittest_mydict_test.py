import unittest

from err_07_unittest_mydict import Dict


class TestDict(unittest.TestCase):  # 编写单元测试时，我们需要编写一个测试类，从unittest.TestCase继承

    def setUp(self):
        print('setUp...')

    def tearDown(self):
        print('tearDown...')

    def test_init(self):  # 以test开头的方法就是测试方法，不以test开头的方法不被认为是测试方法，测试的时候不会被执行
        d = Dict(a=1, b='test')
        self.assertEqual(d.a, 1)  # 断言函数返回的结果与1相等
        self.assertEqual(d.b, 'test')
        self.assertTrue(isinstance(d, dict))

    def test_key(self):
        d = Dict()
        d['key'] = 'value'
        self.assertEqual(d.key, 'value')

    def test_attr(self):
        d = Dict()
        d.key = 'value'
        self.assertTrue('key' in d)
        self.assertEqual(d['key'], 'value')

    def test_keyerror(self):
        d = Dict()
        # 另一种重要的断言就是期待抛出指定类型的Error，比如通过d['empty']访问不存在的key时，断言会抛出KeyError
        with self.assertRaises(KeyError):
            value = d['empty']

    def test_attrerror(self):
        d = Dict()
        with self.assertRaises(AttributeError):
            value = d.empty


# if __name__ == '__main__':
#     unittest.main()
