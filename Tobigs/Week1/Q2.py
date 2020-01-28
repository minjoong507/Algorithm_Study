left1, bottom1, right1, top1 = map(int, input().split())
left2, bottom2, right2, top2 = map(int, input().split())
left3, bottom3, right3, top3 = map(int, input().split())

if left1 > right1 or left2 > right2 or left3 > right3 or bottom1 > top1 or bottom2 > top2 or bottom3 > top3:
    print(0)
else:
    ret = (right1 - left1) * (top1 - bottom1)
    ret -= max((min(right1, right2) - max(left1, left2)), 0) * max((min(top1, top2) - max(bottom1, bottom2)), 0)
    ret -= max((min(right1, right3) - max(left1, left3)), 0) * max((min(top1, top3) - max(bottom1, bottom3)), 0)
    ret += max((min(right1, min(right2, right3)) - max(left1, max(left2, left3))), 0) * max((min(top1, min(top2, top3)) - max(bottom1, max(bottom2, bottom3))), 0)
    print(ret)
