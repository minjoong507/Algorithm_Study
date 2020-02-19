# A = input()

# def solve(A):
#     word = list(A)
#     for i in range(len(word)//2 + 1):
#         print(i)
#         if word[i] == "?":
#             if word[-i] != "?":
#                 word[i] = word[-i]
#             else:
#                 word[i] = 'a'
#                 word[-i] = 'a'
#         else:
#             if word[-i] == "?":
#                 word[-i] = word[i]
#                 print("change")
#             elif word[i] == word[-i]:
#                 pass
#             else:
#                 print("NO")
#                 return
#     print(''.join(word))
#     return


# solve(A)
a = 'bfsd'

print(a[:len(a)//2])
print(a[len(a)//2:][::-1])

a = 'bfasd'

print(a[:len(a)//2])
print(a[len(a)//2+1:][::-1])