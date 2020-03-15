def solve(x):

    # room[0][i]는 i칸에 사자가 왼쪽
    # room[1][i]는 i칸에 사자가 오른쪽
    # room[0][i]는 i칸에 사자가 없을경우
    max_val = x+1
    room = [[0 for i in range(max_val)] for i in range(3)]
    for i in range(3):
        room[i][1] = 1
    for step in range(2, max_val):
        # 해당 칸에 사자가 왼쪽에 있으려면? 이전칸에 사자가 없거나 오른쪽에 있어야함
        # 이와 같이 생각해서 다음 식을 작성
        room[0][step] = (room[2][step-1] + room[1][step-1]) % 9901

        room[1][step] = (room[2][step-1] + room[0][step-1]) % 9901

        room[2][step] = (room[2][step-1] + room[1][step-1] + room[0][step-1]) % 9901

    print((room[0][x] + room[1][x] + room[2][x]) % 9901)


N = int(input())
solve(N)
