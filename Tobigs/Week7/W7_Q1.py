import sys
from _collections import deque

R, C = map(int, input().split())
board = []
result = 1
q = deque()

for i in range(R):
    line = sys.stdin.readline().strip()
    board.append(list(line))


def solve(start_x, start_y):
    global result

    # 상하좌우 움직임을 표현
    move1 = [-1, 0, 0, 1]
    move2 = [0, 1, -1, 0]

    q.append([start_x, start_y, board[start_x][start_y]])
    # 시작점과 시작점의 알파벳을 추가해서 시작!

    while q:
        node = q.popleft()
        x = node[0]
        y = node[1]
        root = node[2]

        for i in range(4):
            if 0 <= x + move1[i] < R and 0 <= y + move2[i] < C and board[x + move1[i]][y + move2[i]] not in root:
                q.append([x + move1[i], y + move2[i], root + board[x + move1[i]][y + move2[i]]])
                result = max(result, len(root)+1)


solve(0, 0)

print(result)
