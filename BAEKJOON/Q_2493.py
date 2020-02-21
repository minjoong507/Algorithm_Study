MAX = 500000
case = int(input())

if case < 1 or case > MAX:
    exit(0)

result = [0] * case
tower = list(map(int, input().split()))
stack = []
tower_sequence = []

for i in range(len(tower)):
    if not stack:
        stack.append(tower[i])
        tower_sequence.append(i+1)
    else:
        while stack:
            top = stack.pop()
            order = tower_sequence.pop()
            if top > tower[i]:
                result[i] = order
                stack.append(top)
                tower_sequence.append(order)
                break
        stack.append(tower[i])
        tower_sequence.append(i+1)

for i in result:
    print(i, end=' ')