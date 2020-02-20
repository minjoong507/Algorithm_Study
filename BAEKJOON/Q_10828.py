import sys

input = sys.stdin.readline
command_count = int(input())

stack = []
def solve(command_input):
    command = command_input.split()[0]
    if len(command_input.split()) > 1:
        number = command_input.split()[1]

    if command == 'push':
        stack.append(int(number))

    elif command == 'pop':
        if not stack:
            print('-1')
        else:
            print(stack.pop())

    elif command == 'size':
        print(len(stack))

    elif command == 'empty':
        if not stack:
            print('1')
        else:
            print('0')

    elif command == 'top':
        if not stack:
            print('-1')
        else:
            print(stack[-1])

for i in range(command_count):
    solve(input())