import sys

input = sys.stdin.readline().rstrip()
stack = []
result = 0


if len(input) < 1 or len(input) > 30:
    Error = False
else:
    for i in list(input):
        if i == ')':
            temp = 0
            while stack:
                top = stack.pop()
                if top == '(':
                    if temp == 0:
                        stack.append(2)
                    else:
                        stack.append(temp * 2)
                    break
                elif top == '[':
                    print(0)
                    exit(0)
                else:
                    if temp == 0:
                        temp = int(top)
                    else:
                        temp = temp + int(top)
        elif i == ']':
            temp = 0
            while stack:
                top = stack.pop()
                if top == '[':
                    if temp == 0:
                        stack.append(3)
                    else:
                        stack.append(temp * 3)
                    break

                elif top == '(':
                    print(0)
                    exit(0)
                else:
                    if temp == 0:
                        temp = int(top)
                    else:
                        temp = temp + int(top)
        else:
            stack.append(i)
    for i in stack:
        if i == '(' or i == '[':
            print(0)
            exit(0)
        else:
            result += i
    print(result)


