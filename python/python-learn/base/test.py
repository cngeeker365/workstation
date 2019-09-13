# digits = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
# print(min(digits))
# print(max(digits))
# print(sum(digits))


# squares = [value**2 for value in range(1,11)]
# print(squares)

# alien_0 = {'color': 'green', 'points': 5}
# alien_1 = {'color': 'yellow', 'points': 10}
# alien_2 = {'color': 'red', 'points': 15}
# aliens = [alien_0, alien_1, alien_2]
# for alien in aliens:
#     print(alien)

# name = input("Please enter your name: ")
# print("Hello, " + name + "!")

# message = ""
# while message != 'quit':
#     message = input("Please enter : ")
#     print(message)

# pets = ['dog', 'cat', 'dog', 'goldfish', 'cat', 'rabbit', 'cat']
# print(pets)
# while 'cat' in pets:
#     pets.remove('cat')
# print(pets)

# def print_models(unprinted_designs, completed_models):
#     """
#     模拟打印每个设计，直到没有未打印的设计为止
#     打印每个设计后，都将其移到列表completed_models中
#     """
#     while unprinted_designs:
#         current_design = unprinted_designs.pop()
#         # 模拟根据设计制作3D打印模型的过程
#         print("Printing model: " + current_design)
#         completed_models.append(current_design)

# def show_completed_models(completed_models):
#     """显示打印好的所有模型"""
#     print("\nThe following models have been printed:")
#     for completed_model in completed_models:
#         print(completed_model)

# unprinted_designs = ['iphone case', 'robot pendant', 'dodecahedron']
# completed_models = []
# print_models(unprinted_designs, completed_models)
# show_completed_models(completed_models)

# print("Give me two numbers, and I'll divide them.")
# print("Enter 'q' to quit.")
# while True:
#         first_number = input("\nFirst number: ")
#         if first_number == 'q':
#                 break
#         second_number = input("Second number: ")
#         try:
#                 answer = int(first_number) / int(second_number)
#         except ZeroDivisionError:
#                 print("You can't divide by 0!")
#         else:
#                 print(answer)

# filename = 'alice.txt'
# try:
#         with open(filename) as f_obj:
#                 contents = f_obj.read()
# except FileNotFoundError:
#         msg = "Sorry, the file " + filename + " does not exist."
#         print(msg)
# else:
#         # 计算文件大致包含多少个单词
#         words = contents.split()
#         num_words = len(words)
#         print("The file " + filename + " has about " + str(num_words) + " words.")
