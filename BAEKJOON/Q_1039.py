from _collections import deque

A, B = input().split()

K = len(A)
B = int(B)
q = deque.append(A)

for i in range(B):
    node = q.popleft()
    