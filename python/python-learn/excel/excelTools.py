import openpyxl

wb = openpyxl.load_workbook('/Users/liangchao/PythonProjects/PyLearn/excel/破碎磨矿充填工艺点位-0701.xlsx')
# print(type(wb))
# print(wb.get_sheet_names())
# sheet = wb.get_sheet_by_name('3个工艺')
# print(sheet['A1'].value)
# c = sheet['M6']
# print('['+str(c.row)+','+str(c.column)+"]="+str(c.value))

# for r in sheet['A1':'M6']:
#     for c in r:
#         print(c.coordinate, str(c.value)) 
#     print('-------- END OF ROW ---------')


sheet2 = wb.get_active_sheet()
print(sheet2.title)
for co in list(sheet2.columns)[1]:
    print(co.value)

