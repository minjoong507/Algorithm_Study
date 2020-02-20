def solve(A):
    if len(A) % 2 == 0:
        front = list(A[:len(A) // 2])
        back = list(A[len(A) // 2:][::-1])
        for i in range(len(front)):
            if front[i] == '?' and back[i] == '?':
                front[i] = 'a'
                back[i] = 'a'
            elif front[i] == '?' and back[i] != '?':
                front[i] = back[i]
            elif front[i] != '?' and back[i] == '?':
                back[i] = front[i]
            elif front[i] == back[i]:
                pass
            else:
                print("NO")
                return
        print(''.join(front + back[::-1]))
        return
    else:
        front = list(A[:len(A) // 2])
        back = list(A[len(A) // 2 + 1:][::-1])
        middle = A[len(A)//2]
        if middle == '?':
            middle = 'a'

        for i in range(len(front)):
            if front[i] == '?' and back[i] == '?':
                front[i] = 'a'
                back[i] = 'a'
            elif front[i] == '?' and back[i] != '?':
                front[i] = back[i]
            elif front[i] != '?' and back[i] == '?':
                back[i] = front[i]
            elif front[i] == back[i]:
                pass
            else:
                print("NO")
                return
        print(''.join(front + list(middle) + back[::-1]))
        return

solve(input())
