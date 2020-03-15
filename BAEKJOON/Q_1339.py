import sys
import math

N = int(input())
result = 0
mark = [] # 있는 알파벳 관리할 리스트
total = [] # 그 갯수 체크

for i in range(N):
    word = sys.stdin.readline().strip()
    for j, idx in enumerate(word):
        if idx not in mark:
            mark.append(idx)
            total.append(math.pow(10, len(word) - j - 1))
        else:
            total[mark.index(idx)] += math.pow(10, len(word) - j - 1)


start = 9
max_num = max(total)
while max_num != 0:
    if start < 0:
        start = 0
    result += max_num * start
    total[total.index(max_num)] = 0
    max_num = max(total)
    start -= 1

print(int(result))