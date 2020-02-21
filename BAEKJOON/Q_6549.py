import sys

while True:
    data = list(map(int, sys.stdin.readline().split()))
    if data[0] == 0:
        break
    tower = data[1:]
    for i, height in enumerate(tower):
        