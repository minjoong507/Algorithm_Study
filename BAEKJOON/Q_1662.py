import sys

line = sys.stdin.readline().strip()

def solve(line):
    stack = list(line)
    length = 0
    temp = []

    while stack:
        node = stack.pop()
        if node == ')':
            temp.append(node)
        elif node == '(':
           while temp[-1] != ')':
               temp.pop()
               length += 1

            temp.pop()
        else:
            temp.append(node)

