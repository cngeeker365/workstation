import pickle
import json

d_1 = dict(name='Bob', age=20, score=88)
f_1 = open('dump.txt', 'wb')
pickle.dump(d_1, f_1)
f_1.close()


f_2 = open('dump.txt', 'rb')
d_2 = pickle.load(f_2)
f_2.close()
print(d_2)

print(json.dumps(d_1))
json_str = '{"age": 20, "score": 88, "name": "Bob"}'
print(json.loads(json_str))


class Student(object):
    def __init__(self, name, age, score):
        self.name = name
        self.age = age
        self.score = score


s = Student('Sss', 33, 111)
# print(json.dumps(s))
print(json.dumps(s, default=lambda obj: obj.__dict__))


def student2dict(std):
    return {
        'name': std.name,
        'age': std.age,
        'score': std.score
    }


def dict2student(d):
    return Student(d['name'], d['age'], d['score'])


print(json.dumps(s, default=student2dict))
print(json.loads(json_str, object_hook=dict2student))
