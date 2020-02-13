for t in range(int(input())): # 테스트 케이스 만큼 루프 실행
    n, s, k = map(int, input().split()) # 세개의 인덱스를 받자.
    a = list(map(int, input().split())) # 레스토랑이 닫은 층을 넣음
    for i in range(k+1):
        if (s+i <= n) and s+i not in a: # 건물을 올라가는데 닫은 층을 제외하고 열린레스토랑에 도착하면 stop
            print(i)
            break
        if (s-i >= 1) and s-i not in a: # 건물을 내려가는데 닫은 층을 제외하고 열린 레스토렝에 도착하면 stop
            print(i)
            break