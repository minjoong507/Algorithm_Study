import sys
sys.setrecursionlimit(10000)

row, col = map(int, input().split())
map = [input() for i in range(row)]

# map = [[0 for i in range(col)] for j in range(row)]
visited = [[False for a in range(col)] for b in range(row)]
distance = [[-1 for c in range(col)] for d in range(row)]
state = False
# 왼쪽, 위, 오른쪽, 아래를 표현하기 위해 만듬
di = [-1, 0, 1, 0]
dj = [0, -1, 0, 1]


def solve(i, j):
    global state
    if not (0 <= i < row and 0 <= j < col) or map[i][j] == 'H':
        return 0
    if visited[i][j]:
        state = True
        return -1
    if distance[i][j] != -1:
        return distance[i][j]

    visited[i][j] = True
    for move in range(4):
        distance[i][j] = max(distance[i][j], solve(i + di[move] * int(map[i][j]), j + dj[move] * int(map[i][j])) + 1)
        if state:
            return -1
    visited[i][j] = False

    return distance[i][j]

print(solve(0,0))
