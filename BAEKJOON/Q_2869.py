speed, back, distance = map(int, input().split())
day = (distance - back) / (speed - back)

if day == int(day):
    print(int(day))
else:
    print(int(day)+1)