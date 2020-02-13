N = int(input())
arr = list(map(int, input().split()))
freq0 = 0
freq1 = 0
freq2 = 0

for a in arr:
    if a % 3 == 0: # 3의 배수인 것 들 끼리는 어떻게 조합해도 3의 배수가 나옴
        freq0 += 1
    elif a % 3 == 1:
        freq1 += 1
    else:
        freq2 += 1

ans = freq0 * (freq0-1)//2 + freq1 * freq2 # freq1, freq2의 각 조합을 서로 더해야 3의배수가 나옴


print(int(ans))