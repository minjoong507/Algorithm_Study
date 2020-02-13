N = int(input())
a, b, x = [None]*N, [None]*N, [None]*N # 바꾸는 횟수 만큼의 리스트 크기 생성
for i in range(N):
    a[i], b[i], x[i] = map(int, input().split()) # 각 리스트에 담기
scores = [] # 점수를 담을 리스트
for i in range(3): # 종이컵 세개중 동전 위치를 제각각 설정
    y = [0,0,0]
    y[i] = 1
    score = 0
    for j in range(N):
        y[a[j]-1], y[b[j]-1] = y[b[j]-1], y[a[j]-1]
        score += (y[x[j]-1] == 1)
    scores.append(score)
print(max(scores)) # 그 나온결과중 최댓값을 출력