Tobigs = list(map(int, input().split()))
A = list(map(int, input().split()))
B = list(map(int, input().split()))

extra_conflict_list = []


def compute_area(a):
    x1 = a[:2]
    x2 = a[2:]
    return (x2[0] - x1[0]) * (x2[1] - x1[1])


def double_conflict_area(a, b):
    conflict_list = []
    x1 = a[:2]
    x2 = a[2:]
    x3 = b[:2]
    x4 = b[2:]

    if x1[0] <= x3[0] < x2[0] and x1[1] <= x3[1] < x2[1]:
        if x3[0] <= x4[0] < x2[0] and x3[1] <= x4[1] < x2[1]:
            return conflict_area(Tobigs, b)
        else:
            conflict_list = x3 + x2
            return conflict_area(Tobigs, conflict_list)

    elif x1[0] <= x4[0] < x2[0] and x1[1] <= x4[1] < x2[1]:
        conflict_list = x1 + x4
        return conflict_area(Tobigs, conflict_list)
    else:
        return 0

def conflict_area(a, b):
    conflict_list = []
    x1 = a[:2]
    x2 = a[2:]
    x3 = b[:2]
    x4 = b[2:]

    if x1[0] <= x3[0] < x2[0] and x1[1] <= x3[1] < x2[1]:
        if x3[0] <= x4[0] < x2[0] and x3[1] <= x4[1] < x2[1]:
            return compute_area(b)
        else:
            conflict_list = x3 + x2
            return compute_area(conflict_list)

    elif x1[0] <= x4[0] < x2[0] and x1[1] <= x4[1] < x2[1]:
        conflict_list = x1 + x4
        return compute_area(conflict_list)
    else:
        return 0


print(compute_area(Tobigs) - conflict_area(Tobigs, A) - conflict_area(Tobigs, B) + double_conflict_area(A, B))

print(compute_area(Tobigs))
print(conflict_area(Tobigs,A))
print(conflict_area(Tobigs,B))
print(double_conflict_area(A,B))