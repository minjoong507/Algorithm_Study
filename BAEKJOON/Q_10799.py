import sys

input = sys.stdin.readline

def solve(command):
    stack = []
    total = 0
    previous_i = 0
    for i in command:
        if i == '(':
            stack.append(i)
        elif i == ')':
            stack.pop()
            if previous_i == ')':
                total += 1
            else:
                total += len(stack)
        previous_i = i
    return total

print(solve(input()))