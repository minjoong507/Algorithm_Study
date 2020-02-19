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
