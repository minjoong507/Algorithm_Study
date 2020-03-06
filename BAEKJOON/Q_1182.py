import sys

def dfs(index, d):
    global result
    if(index >= N):
        if(S == d):
            result += 1
            return
    else:
        # 원소를 포함하는 경우
        dfs(index+1, d+numbers[index])
        # 원소를 포함하지 않는 경우
        dfs(index+1, d)



N, S = map(int, input().split())
numbers = list(map(int, sys.stdin.readline().split()))

result = 0
dfs(0, 0)
print(result-1 if S == 0 else result)

