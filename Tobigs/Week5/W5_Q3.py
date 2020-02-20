A = list(input())

def solve(code):
    if len(code) == 1 and code[0] == 'a' or code[0] == 'b':
        return True

    elif code[0] == 'o' and code[1] == 'n' and code[2] == 'e' and code[3] == '(' and code[-1] == ')':
        return solve(code[4:len(code)-1])

    elif code[0] == 't' and code[1] == 'w' and code[2] == 'o' and code[3] == '(' and code[-1] == ')':
        for i in range(4, len(code)-1):
            if code[i] == ',':
                return solve(code[4:i]), solve(code[i+1:len(A)-1])
            else:
                continue
        return False
    else:
        return False

if solve(A):
    print("Syntax Error")
else:
    print("No Error")


# A = 'two(two(b,one(two(two(two(a,b),a),two(two(one(a),a),one(one(b)))),a)'
# stack = []
#
# def check(word):
#     for i in word:
#         print(i)
#         if i == 't' or i == 'w' or i == 'o' or i == 'n' or i == 'e' or i == 'a' or i == 'b' or i == '(' or i == ')' or i == ',':
#             stack.append(i)
#         else:
#             return False
# check(list(A))
# print(stack)

