# # from itertools import combinations
# # #
# # # def prob1(A):
# # #     letter_check = []
# # #     comb = []
# # #     word_len = []
# # #
# # #     for word in A:
# # #         letter_check.append(list(word))
# # #
# # #     for i in range(len(A)-1):
# # #         for j in range(i+1, len(A)):
# # #             if check(letter_check[i], letter_check[j]):
# # #                 comb.append([i, j])
# # #
# # #     total_comb = []
# # #     for i in range(len(A)):
# # #         total_comb.append(list(combinations(range(1,len(A)+1), i+1)))
# # #     print(total_comb)
# # #
# # #     for combi in comb:
# # #         for index in A:
# # #             if combi[0] not in index or combi[1] not in index:
# # #
# # #
# # #
# # def check(a, b):
# #     for i in b:
# #         if i in a:
# #             return True
# #         else:
# #             continue
# #     return False
# # #
# # # A = list(input().split())
# # # print(prob1(A))
# # #
# # # A = [[1], [2], [3], [1,2], [1,3], [1,2,3],[2,3,4]]
# # # B = [[1,2],[1,3]]
# # #
# # #
# # # for combi in B:
# # #     for index in A:
# # #         if combi[0] not in index or combi[1] not in index:
# #
# # A =[1,2,3]
# # total_comb = []
# # for i in range(len(A)):
# #     total_comb.append(list(combinations(range(1, len(A) + 1), i + 1)))
# # print(total_comb)
def check(a, b):
    for i in b:
        if i not in a:
            continue
        else:
            return False
    return True

A = list(input().split())
wordbox = []
for i in range(len(A)):
    temp = A[i]
    for j in range(i, len(A)):
        if check(list(temp), list(A[j])):
            temp += A[j]
    if len(set(temp)) == len(temp):
        wordbox.append(len(temp))
    else:
        wordbox.append(0)
print(max(wordbox))
