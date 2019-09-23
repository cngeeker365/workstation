def foo(s):
    n = int(s)
    assert n != 0, 'n is zero!'     # 启动Python解释器时可以用-O参数来关闭assert
    return 10 / n


def main():
    foo('0')


main()
