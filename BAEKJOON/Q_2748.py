A = int(input())

def solve(x):
    time = x-2
    a = 0
    b = 1
    for i in range(x):
        temp = b
        b += a
        a = temp
    return a

if A == 0:
    print(0)
elif A == 1:
    print(1)
else:
    print(solve(A))