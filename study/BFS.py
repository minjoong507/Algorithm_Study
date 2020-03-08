

def BFS(Start, Target):
    time = 0
    X = [Start]
    while True:
        for i in range(len(X)):
            node = X.pop(0)

            if node == Target:
                print("got it!")
                return time
            else:
                X.append(node + 1)
                X.append(node - 1)
                X.append(node * 2)
        time += 1

print(BFS(5,17))

