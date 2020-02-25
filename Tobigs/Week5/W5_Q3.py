A = list(input())

def solve(code):
    stack = []
    for i in code:
        if i != ')':
            stack.append(i)
        else:
            is_two = False
            while True:
                matched = False
                if len(stack) == 0:
                    print('Syntax Error')
                    exit(0)

                else:
                    node = stack.pop()

                    if node == 'a':
                        pass
                    elif node == 'b':
                        pass
                    elif node == 'o':
                        pass
                    elif node == 'n':
                        pass
                    elif node == 'e':
                        pass
                    elif node == 't':
                        pass
                    elif node == 'w':
                        pass
                    elif node == '(':
                        if is_two and stack[-1] == 'o':
                            matched = True
                            break
                        elif not is_two and stack[-1] == 'e':
                            matched = True
                            break
                        else:
                            matched = False
                            break
                    elif node == ',':
                        is_two = True
                    else:
                        print('Syntax Error')
                        exit(0)
            if not matched:
                print('Syntax Error')
                exit(0)
    print('No Error')

solve(A)

