import sys
row, col = map(int, input().split())
map = [list(input()) for i in range(row)]

# map = [[0 for i in range(col)] for j in range(row)]
visited = [[False for a in range(col)] for b in range(row)]
state = [[0 for c in range(col)] for d in range(row)]
#
# for i in range(row):
#     map_num = list(sys.stdin.readline())
#     for j in range(col):
#         if map_num[j] == 'H':
#             map[i][j] = map_num[j]
#         else:
#             map[i][j] = int(map_num[j])

result = [] # 움직인 횟수를 담을 리스트

def solve():
    stack = [] # 코인 위치를 담을 스택

    #시작점이 구멍인 경우
    if map[0][0] == 'H':
        result.append(0)
        return

    stack.append([0, 0])

    while stack:
        now = stack.pop()
        x = now[0]
        y = now[1]
        value = int(map[x][y])
        visited[x][y] = True  # 나는 여길 지나갔고
        # print(stack)
        # print(str(x) + ',' + str(y))
        # print(result)

        # 오른쪽으로 이동할건데 맵안에 있고
        if y + value < col:
            # 다음 위치가 구멍이 아니어야함
            if map[x][y + value] != 'H':
                if visited[x][y + value]: # 내가 다음가는 위치가 방문했던 위치라면 -1 출력하고 끝
                    print('-1')
                    exit(0)
                stack.append([x, y + value]) # 내 다음 위치를 스택에 넣음
                state[x][y + value] = state[x][y] + 1
            # 구멍이라면?
            else:
                visited[x][y] = False
                result.append(state[x][y] + 1)
        else:
            visited[x][y] = False
            result.append(state[x][y] + 1)

        # 왼쪽
        if y - value >= 0:
            if map[x][y - value] != 'H':
                if visited[x][y - value]:
                    print('-1')
                    exit(0)
                # visited[x][y] = True
                stack.append([x, y - value])
                state[x][y - value] = state[x][y] + 1

            else:
                visited[x][y] = False
                result.append(state[x][y] + 1)
        else:
            visited[x][y] = False
            result.append(state[x][y] + 1)

        # 위
        if x - value >= 0:
            if map[x - value][y] != 'H':
                if visited[x - value][y]:
                    print('-1')
                    exit(0)
                # visited[x][y] = True
                stack.append([x - value, y])
                state[x - value][y] = state[x][y] + 1

            else:
                visited[x][y] = False
                result.append(state[x][y] + 1)
        else:
            visited[x][y] = False
            result.append(state[x][y] + 1)

        # 아래쪽
        if x + value < row:
            if map[x + value][y] != 'H':
                if visited[x + value][y]:
                    print('-1')
                    exit(0)
                # visited[x][y] = True
                stack.append([x + value, y])
                state[x + value][y] = state[x][y] + 1

            else:
                visited[x][y] = False
                result.append(state[x][y] + 1)
        else:
            visited[x][y] = False
            result.append(state[x][y] + 1)

        state[x][y] = 0

solve()

if min(result) == -1:
    print('-1')
else:
    print(max(result))
