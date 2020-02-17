from _collections import deque
MAX = 10000

def solve(Start, End):
    result = [""] * MAX
    q = deque()
    q.append(Start)
    while q:
        node = q.popleft()

        if node == End:
            return result[node]
        else:
            if 0 <= node * 2 < MAX and result[node*2] == "":
                q.append(node*2)
                result[node*2] = result[node] + 'D'

            elif node * 2 >= MAX and result[divmod(node*2, MAX)[1]] == "":
                new_node = divmod(node*2, MAX)[1]
                q.append(new_node)
                result[new_node] = result[node] + 'D'

            if 0 <= node - 1 < MAX and result[node-1] == "":
                q.append(node-1)
                result[node-1] = result[node] + 'S'

            elif node == 0 and result[9999] == "":
                q.append(9999)
                result[9999] = result[node] + 'S'

            d1 = divmod(node, 1000)[0]
            d2 = divmod(node - (d1*1000), 100)[0]
            d3 = divmod(node - (d1*1000) - (d2 * 100), 10)[0]
            d4 = divmod(node, 10)[1]

            L_num = d2*1000 + d3*100 + d4*10 + d1
            R_num = d4*1000 + d1*100 + d2*10 + d3

            if result[L_num] == "":
                q.append(L_num)
                result[L_num] = result[node] + 'L'

            if result[R_num] == "":
                q.append(R_num)
                result[R_num] = result[node] + 'R'


for i in range(int(input())):
    Start, End = map(int, input().split())
    print(solve(Start, End))