from itertools import combinations

N = int(input())
ability_board = []
for _ in range(N):
    ability_board.append(list(map(int, input().split())))

num_list = [i for i in range(N)]
res = float('inf')


def solve():
    global res

    for cand in combinations(num_list, N // 2):

        start_member = list(cand)
        link_member = list(set(num_list) - set(cand))

        start_comb = list(combinations(start_member, 2))
        link_comb = list(combinations(link_member, 2))

        # 점수 구하기
        start_sum = 0
        for x, y in start_comb:
            start_sum += (ability_board[x][y] + ability_board[y][x])

        link_sum = 0
        for x, y in link_comb:
            link_sum += (ability_board[x][y] + ability_board[y][x])

        if (res > abs(start_sum - link_sum)):
            res = abs(start_sum - link_sum)


solve()
print(res)