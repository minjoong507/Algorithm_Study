# while True:
#     x = int(input())
#
#     if x == 0:
#         break
#     result = 0
#     for i in range(x+1, x * 2 + 1):
#         if i < 10:
#             count = 0
#             for j in range(1, i+1):
#                 if i % j == 0:
#                     count += 1
#             if count == 2:
#                 result += 1
#         else:
#             if i % 6 == 1 or i % 6 == 5:
#                 Find = True
#                 m = int(i*0.5)
#                 for j in range(2, m+1):
#                     if i % j != 0:
#                         continue
#                     else:
#                         Find = False
#                         break
#                 if Find:
#                     result += 1
#     print(result)

while True:
    x = int(input())
    if x == 0:
        break
    else:
        MAX = 2 * x + 1
        table = [True] * MAX
        limit = int(MAX ** 0.5)
        for i in range(2, limit + 1):
            if table[i] is True:
                for j in range(i+i, MAX, i):
                    table[j] = False
    result = [i for i in range(2,MAX) if table[i] is True]

    print(len([i for i in result if i > x]))




