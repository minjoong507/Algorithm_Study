from _collections import deque

MAX = 1000

def bfs(Target):
    qu = deque()
    qu.append([1,0])
    while qu:
        node = qu.popleft()
        if node[0] == Target:
            return
        else:
            for i in ([[node[0]+node[1],node[1]], [node[0],node[0]], [node[0]-1, node[1]]]):

