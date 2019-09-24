'''
@Description: In User Settings Edit
@Author: your name
@Date: 2019-09-24 22:52:39
@LastEditTime: 2019-09-24 23:30:57
@LastEditors: Please set LastEditors
'''
from datetime import datetime, timedelta, timezone

'''
获取当前日期和时间
'''
now = datetime.now() # 获取当前datetime
print(now)
print(type(now))

'''
获取指定日期和时间
'''
dt = datetime(2015, 4, 19, 12, 20) # 用指定日期时间创建datetime
print(dt)

'''
datetime转换为timestamp
'''
dt.timestamp() # 把datetime转换为timestamp, 注意Python的timestamp是一个浮点数。如果有小数位，小数位表示毫秒数。

'''
timestamp转换为datetime
注意: 
    timestamp是一个浮点数，它没有时区的概念，而datetime是有时区的。上述转换是在timestamp和本地时间做转换。
    本地时间是指当前操作系统设定的时区。
'''
t = 1429417200.0
print(datetime.fromtimestamp(t))    # 本地时间, 实际上就是UTC+8:00时区的时间
print(datetime.utcfromtimestamp(t)) # UTC时间

'''
str转换为datetime, 注意转换后的datetime是没有时区信息的
'''
cday = datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')
print(cday)

'''
datetime转换为str
'''
print(now.strftime('%a, %b %d %H:%M'))

'''
datetime加减
'''
print(now + timedelta(hours=10))
print(now - timedelta(days=1))
print(now + timedelta(days=2, hours=12))

'''
本地时间转换为UTC时间
本地时间是指系统设定时区的时间，例如北京时间是UTC+8:00时区的时间，而UTC时间指UTC+0:00时区的时间。
一个datetime类型有一个时区属性tzinfo，但是默认为None，所以无法区分这个datetime到底是哪个时区，除非强行给datetime设置一个时区
'''
tz_utc_8 = timezone(timedelta(hours=8)) # 创建时区UTC+8:00
# 如果系统时区恰好是UTC+8:00，那么上述代码就是正确的，否则，不能强制设置为UTC+8:00时区
dt_utc_8 = now.replace(tzinfo=tz_utc_8) # 强制设置为UTC+8:00
print(dt_utc_8)

'''
时区转换: 先通过utcnow()拿到当前的UTC时间，再转换为任意时区的时间
时区转换的关键在于，拿到一个datetime时，要获知其正确的时区，然后强制设置时区，作为基准时间。
利用带时区的datetime，通过astimezone()方法，可以转换到任意时区。
注：不是必须从UTC+0:00时区转换到其他时区，任何带时区的datetime都可以正确转换，例如上述bj_dt到tokyo_dt的转换。
'''
# 拿到UTC时间，并强制设置时区为UTC+0:00: 
utc_dt = datetime.utcnow().replace(tzinfo=timezone.utc)
print(utc_dt)

# astimezone()将转换时区为北京时间:
bj_dt = utc_dt.astimezone(timezone(timedelta(hours=8)))
print(bj_dt)

# astimezone()将转换时区为东京时间:
tokyo_dt = utc_dt.astimezone(timezone(timedelta(hours=9)))
print(tokyo_dt)

# astimezone()将bj_dt转换时区为东京时间:
tokyo_dt2 = bj_dt.astimezone(timezone(timedelta(hours=9)))
print(tokyo_dt2)

'''
datetime表示的时间需要时区信息才能确定一个特定的时间，否则只能视为本地时间。
如果要存储datetime，最佳方法是将其转换为timestamp再存储，因为timestamp的值与时区完全无关。
'''
