'''
@property广泛应用在类的定义中，可以让调用者写出简短的代码，同时保证对参数进行必要的检查，这样，程序运行时就减少了出错的可能性。
'''


class Student(object):

    @property
    def score(self):
        return self._score

    @score.setter
    def score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value

    @property   # 只读属性
    def age(self):
        return 2015 - self._score


s = Student()
s.score = 60  # OK，实际转化为s.set_score(60)
print(s.score)  # OK，实际转化为s.get_score()
s.score = 9999
