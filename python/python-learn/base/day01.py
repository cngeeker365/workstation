# def spam(divideBy):
#     try:
#         return 42 / divideBy
#     except ZeroDivisionError:
#         print('Error: Invalid argument.')


# print(spam(2))
# print(spam(12))
# print(spam(0))
# print(spam(1))
import pprint

# 井字棋游戏源码（http://nostarch.com/automatestuff/）
theBoard = {'top-L': ' ', 'top-M': ' ', 'top-R': ' ',
            'mid-L': ' ', 'mid-M': ' ', 'mid-R': ' ',
            'low-L': ' ', 'low-M': ' ', 'low-R': ' '}


def printBoard(board):
    pprint.pprint(board['top-L'] + '|' + board['top-M'] + '|' + board['top-R'])
    pprint.pprint('-+-+-')
    pprint.pprint(board['mid-L'] + '|' + board['mid-M'] + '|' + board['mid-R'])
    pprint.pprint('-+-+-')
    pprint.pprint(board['low-L'] + '|' + board['low-M'] + '|' + board['low-R'])


printBoard(theBoard)


"""This is a test Python program.
Written by Al Sweigart al@inventwithpython.com
This program was designed for Python 3, not Python 2.
"""


def spam():
    return """This is a multiline comment to help
    explain what the spam() function does."""


print(spam())
