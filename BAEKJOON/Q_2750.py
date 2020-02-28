test_c = int(input())

result = []
for i in range(test_c):
    put = False
    if i == 0:
        result.append(int(input()))

    else:
        num = int(input())
        for index, number in enumerate(result):
            if num < number:
                result.insert(index, num)
                put = True
                break
        if not put:
            result.append(num)


for ans in result:
    print(ans)




# A = [1,2,3,4]
#
# A.insert(3,10)
# print(A)