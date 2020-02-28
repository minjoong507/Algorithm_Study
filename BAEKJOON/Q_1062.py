A, B = map(int, input().split())

word = []
for i in range(A):
    temp = input()[4:-4]
    word.append(set(temp))

result_list = []
stack = set('antatica')
count = B - len(stack)
for i in word:
    result = 0
    if len(i - stack) == 0:
        result += 1
    else:
        if count - len(i - stack) >= 0:
            result += 1
            count = count - len(i - stack)
            stack.union(i)
    result_list.append(result)

print(max(result_list))
