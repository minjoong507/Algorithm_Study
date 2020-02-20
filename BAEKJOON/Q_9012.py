import sys

input = sys.stdin.readline
command_count = int(input())
def solve(command_input):
    stack = []
    for i in command_input:
        if i == '(':
            if len(stack) == 0:
                stack.append(i)
            else:
                if stack[-1] == '(':
                    stack.append(i)
        elif i == ')':
            if len(stack) == 0:
                return False
            if stack[-1] == '(':
                stack.pop()

    if len(stack) == 0:
        return True
    else:
        return False


for i in range(command_count):
    if solve(input()):
        print('YES')
    else:
        print('NO')