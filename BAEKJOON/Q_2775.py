#피보나치 함수
def Fibo(floor, num):
    result = 0
    if floor == 0:
        result = num
        return result
    else:
        for i in range(1, num+1):
            result += Fibo(floor-1, i)
        return result

for i in range(int(input())):
    # 층,호수 번호 받기
    room_floor = int(input())
    room_number = int(input())
    print(Fibo(room_floor, room_number))
