user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id = ["fr*d*", "*rodo", "******", "******"]
result = []
answer = 0


def solution(user_id, banned_id):
    global result, answer

    for ban in banned_id:
        temp = []
        for usr in range(len(user_id)):
            ismatch = True

            if len(ban) == len(user_id[usr]):
                for i, j in enumerate(ban):
                    if user_id[usr][i] == j or j == '*':
                        continue
                    else:
                        ismatch = False
                        break
                if ismatch:
                    temp.append(usr)
        result.append(temp)
    print(result)

    return answer

solution(user_id, banned_id)


def dfs(ans, step):
    global result, answer
    if step == len(result):
        if len(ans) == len(set(ans)):
            answer += 1

    if step<len(result):
        