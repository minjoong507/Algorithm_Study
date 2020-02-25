import sys
A = int(input())

def makeblank(i, j):
    di = i
    dj = j
    while di != 0:
        if (di % 3) == 1 and (dj % 3) == 1:
            return True
        di = di // 3
        dj = dj // 3
    return False


for i in range(A):
    for j in range(A):
        if makeblank(i, j):
            sys.stdout.write(' ')
        else:
            sys.stdout.write('*')
    sys.stdout.write('\n')