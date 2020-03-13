import sys
K, N = map(int, input().split())


def solve(k, n):
    line = []

    for i in range(k):
        line.append(int(sys.stdin.readline().strip()))

    start, end = 1, max(line)

    while start <= end:
        mid = (start + end) // 2
        lines = 0
        for i in line:
            lines += i // mid

        if lines >= N:
            start = mid + 1
        else:
            end = mid - 1
    return end


print(solve(K, N))