from _collections import deque

kk = "{{2},{2,1},{2,1,3},{2,1,3,4}}"


def solution(s):
    answer = []
    result = []
    stack = deque(list(s))
    while len(stack) > 0:
        node = stack.popleft()
        temp = []
        if node == '{':

            tmp = ""
            while tmp != '}':
                tmp = stack.popleft()
                if tmp != '{' and tmp != '}' and tmp != ',':
                    temp.append(tmp)
            result.append(temp)

    for


    return answer

solution(kk)