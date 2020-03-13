import math

A, B = map(int,input().split())

result = math.factorial(A) // math.factorial(A - B) // math.factorial(B)

print("%d" % result)