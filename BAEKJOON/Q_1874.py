import sys

input = sys.stdin.readline
command_count = int(input())
stack = []
def solve(command_input):
    print(stack)
    if len(stack) > int(command_input):
        while len(stack) > int(command_input):
            print('-')
            stack.pop()

    elif len(stack) < int(command_input):
        while len(stack) < int(command_input):
            print('+')
            stack.append(0)
        print('-')
        stack.pop()
    else:
        print('-')
        stack.pop()




for i in range(command_count):
    solve(input())