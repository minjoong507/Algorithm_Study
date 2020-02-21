import sys
from _collections import deque

stack = []
result = []
State = 0
count = 1

for i in range(int(input())):
    command_input = int(input())
    while count <= command_input:
        stack.append(count)
        count += 1
        result.append('+')
    if stack[-1] == command_input:
        stack.pop()
        result.append('-')
    else:
        State = 1
        break

if State == 1:
    print('NO')
else:
    for k in result:
        print(k)

