import sys

R, C = map(int, input().split())
board = []
min = sys.maxsize

for i in range(R):
    line = sys.stdin.readline().strip()
    board.append(list(line))

def solve():
    # 상하좌우 표현
    move1 = [-1, 0, 0, 1]
    move2 = [0, 1, -1, 0]
    stack = []
    trace = []

    start = [0, 0]
    stack.append(start)
    trace.append(board[0][0])
    while stack:
        node = stack.pop()
        x = node[0]
        y = node[1]

        for i in range(4):
            if 0 <= x + move1[i] < R and 0 <= y + move2[i] < C and board[x + move1[i]][y + move2[i]] not in trace:
                stack.append([x + move1[i], y + move2[i]])
                trace.append(board[x + move1[i]][y + move2[i]])







