for i in range(int(input())):
    H, W, N = map(int, input().split())
    a, b = divmod(N, H)
    if b == 0:
        print(H * 100 + a)
    else:
        print(b * 100 + a + 1)

