import re

phoneNumRegex = re.compile(r'\d\d\d-\d\d\d-\d\d\d\d')
mo = phoneNumRegex.findall('My number is 415-555-4242. hh is 333-012-2323.')
print('Phone number found: ' + mo[1])


phoneNumRegex = re.compile(r'(\d\d\d)-(\d\d\d-\d\d\d\d)')
mo = phoneNumRegex.search('My number is 415-555-4242.')
mo.group(1)
mo.group(2)
mo.group(0)
mo.group()
areaCode, mainNumber = mo.groups()
print(areaCode)
print(mainNumber)


phoneNumRegex = re.compile(r'(\(\d\d\d\)) (\d\d\d-\d\d\d\d)')
mo = phoneNumRegex.search('My phone number is (415) 555-4242.')
mo.group(1)
mo.group(2)

heroRegex = re.compile(r'Batman|Tina Fey')
mo1 = heroRegex.search('Batman and Tina Fey.')
print(mo1.group())

# | 管道匹配分组
batRegex = re.compile(r'Bat(man|mobile|copter|bat)')
mo = batRegex.search('Batmobile lost a wheel')
print(mo.group())
print(mo.group(1))
print(mo.group(0))

# ? 零次或一次
batRegex = re.compile(r'Bat(wo)?man')
mo1 = batRegex.search('The Adventures of Batman')
print(mo1.group())
mo2 = batRegex.search('The Adventures of Batwoman')
print(mo2.group())

# * 零次或多次
batRegex = re.compile(r'Bat(wo)*man')
mo1 = batRegex.search('The Adventures of Batman')
mo1.group()
mo2 = batRegex.search('The Adventures of Batwoman')
mo2.group()
mo3 = batRegex.search('The Adventures of Batwowowowoman')
mo3.group()

# + 一次或多次
batRegex = re.compile(r'Bat(wo)+man')
mo1 = batRegex.search('The Adventures of Batwoman')
print(mo1.group())
mo2 = batRegex.search('The Adventures of Batwowowowoman')
print(mo2.group())
mo3 = batRegex.search('The Adventures of Batman')
print(mo3 is None)

# {} 匹配特定次数
haRegex = re.compile(r'(Ha){3}')
mo1 = haRegex.search('HaHaHa')
print(mo1.group())
mo2 = haRegex.search('Ha')
print(mo2 is None)

phoneNumRegex = re.compile(r'(\d\d\d)-(\d\d\d)-(\d\d\d\d)')     # has groups
phoneNumRegex.findall('Cell: 415-555-9999 Work: 212-555-0000')

phoneNumRegex = re.compile(r'\d\d\d-\d\d\d-\d\d\d\d')           # has no groups
phoneNumRegex.findall('Cell: 415-555-9999 Work: 212-555-0000')

xmasRegex = re.compile(r'\d+\s\w+')
mo = xmasRegex.findall('12 drummers, 11 pipers, 10 lords, 9 ladies, 8 maids, 7 swans, 6 geese, 5 rings, 4 birds, 3 hens, 2 doves, 1 partridge')
print(mo)

# 字符分类[aeiouAEIOU]将匹配所有元音字
# 字符分类[a-zA-Z0-9]将匹配所有小写字母、 大写字母和数字
# 在方括号内，普通的正则表达式符号不会被解释
vowelRegex = re.compile(r'[aeiouAEIOU]')
print(vowelRegex.findall('RoboCop eats baby food. BABY FOOD.'))

# 通过在字符分类的左方括号后加上一个插入字符（^）,可以得到“非字符类”
consonantRegex = re.compile(r'[^aeiouAEIOU]')
print(consonantRegex.findall('RoboCop eats baby food. BABY FOOD.'))

# 正则表达式的开始处使用插入符号（^），表明匹配必须发生在被查找文本开始处
beginsWithHello = re.compile(r'^Hello')
print(beginsWithHello.search('Hello world!'))
print(beginsWithHello.search('He said hello.') is None)

# 正则表达式的末尾加上美元符号（$），表示该字符串必须以这个正则表达式的模式结束
endsWithNumber = re.compile(r'\d$')
print(endsWithNumber.search('Your number is 42'))
print(endsWithNumber.search('Your number is forty two.') is None)

# 同时使用^和$，表明整个字符串必须匹配该模式
wholeStringIsNum = re.compile(r'^\d+$')
wholeStringIsNum.search('1234567890')
print(wholeStringIsNum.search('12345xyz67890') is None)
print(wholeStringIsNum.search('12 34567890') is None)

# .（句点）字符称为“通配符”。它匹配除了换行之外的所有字符
atRegex = re.compile(r'.at')
print(atRegex.findall('The cat in the hat sat on the flat mat.'))

# 点-星（ .*）表示“任意文本”, 使用“贪心” 模式：它总是匹配尽可能多的文本
# 点-星和问号(.*?) 使用非贪心算法，？告诉python使用非贪心模式匹配
nameRegex = re.compile(r'First Name: (.*) Last Name: (.*)')
mo = nameRegex.search('First Name: Al Last Name: Sweigart')
print(mo.group(1))
print(mo.group(2))
print(mo.groups())
print(mo.group())

nongreedyRegex = re.compile(r'<.*?>')
mo = nongreedyRegex.search('<To serve man> for dinner.>')
print(mo.group())
greedyRegex = re.compile(r'<.*>')
mo = greedyRegex.search('<To serve man> for dinner.>')
print(mo.group())

# 通过传入 re.DOTALL 作为 re.compile()的第二个参数， 可以让句点字符匹配所有字符， 包括换行字符
noNewlineRegex = re.compile('.*')
print(noNewlineRegex.search('Serve the public trust.\nProtect the innocent.\nUphold the law.').group())
newlineRegex = re.compile('.*', re.DOTALL)
print(newlineRegex.search('Serve the public trust.\nProtect the innocent.\nUphold the law.').group())

# ?匹配零次或一次前面的分组。
# *匹配零次或多次前面的分组。
# +匹配一次或多次前面的分组。
# {n}匹配 n 次前面的分组。
# {n,}匹配 n 次或更多前面的分组。
# {,m}匹配零次到 m 次前面的分组。
# {n,m}匹配至少 n 次、至多 m 次前面的分组。
# {n,m}?或*?或+?对前面的分组进行非贪心匹配。
# ^spam 意味着字符串必须以 spam 开始。
# spam$意味着字符串必须以 spam 结束。
# .匹配所有字符，换行符除外。
# \d、 \w 和\s 分别匹配数字、单词和空格。
# \D、 \W 和\S 分别匹配出数字、单词和空格外的所有字符。
# [abc]匹配方括号内的任意字符（诸如 a、 b 或 c）。
# [^abc]匹配不在方括号内的任意字符。


# 要让正则表达式不区分大小写，可以向 re.compile()传入 re.IGNORECASE 或 re.I，作为第二个参数
robocop = re.compile(r'robocop', re.I)
print(robocop.search('RoboCop is part man, part machine, all cop.').group())
print(robocop.search('ROBOCOP protects the innocent.').group())
print(robocop.search('Al, why does your programming book talk about robocop so much?').group())

# Regex对象的 sub()方法需要传入两个参数。第一个参数是 替换者，第二个参数是 原始待匹配待替换者， 返回替换完成后的字符串
namesRegex = re.compile(r'Agent \w+')
print(namesRegex.sub('CENSORED', 'Agent Alice gave the secret documents to Agent Bob.'))

# 告诉 re.compile()， 忽略正则表达式字符串中的空白符和注释，可以向 re.compile() 传入变量 re.VERBOSE， 作为第二个参数
phoneRegex = re.compile(r'''(
                                (\d{3}|\(\d{3}\))?              # area code
                                (\s|-|\.)?                      # separator
                                \d{3}                           # first 3 digits
                                (\s|-|\.)                       # separator
                                \d{4}                           # last 4 digits
                                (\s*(ext|x|ext.)\s*\d{2,5})?    # extension
                                )''', re.VERBOSE)
emailRegex = re.compile(r'''(
                                [a-zA-Z0-9._%+-]+               # username
                                @                               # @ symbol
                                [a-zA-Z0-9.-]+                  # domain name
                                (\.[a-zA-Z]{2,4})               # dot-something
                                )''', re.VERBOSE)

# 正则表达式不区分大小写，并且句点字符匹配换行，
someRegexValue = re.compile('foo', re.IGNORECASE | re.DOTALL)
someRegexValue = re.compile('foo', re.IGNORECASE | re.DOTALL | re.VERBOSE)
