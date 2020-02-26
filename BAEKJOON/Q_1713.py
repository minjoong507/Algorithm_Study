MAX_length = int(input())
# if MAX_length < 1 and MAX_length > 20:
#     exit(0)

vote_time = int(input())
# if vote_time > 1000:
#     exit(0)

student_num = list(map(int, input().split()))
# if vote_time != len(student_num) or max(student_num) >100:
#     exit(0)

candidate = []
vote = []

for i in student_num:
    if len(candidate) == 0:
        candidate.append(i)
        vote.append(1)

    elif len(candidate) < MAX_length:
        if i in candidate:
            vote[candidate.index(i)] += 1

        else:
            candidate.append(i)
            vote.append(1)

    elif len(candidate) == MAX_length:
        if i in candidate:
            vote[candidate.index(i)] += 1

        else:
            for j in range(len(vote)):
                if min(vote) == vote[j]:
                    del candidate[j]
                    del vote[j]
                    break
            candidate.append(i)
            vote.append(1)
    # print('input: '+ str(i))
    # print(candidate)
    # print(vote)
for i in sorted(candidate):
    print(i, end=" ")

# candidate_vote = {}
#
# for i in student_num:
#     if len(candidate_vote) == 0:
#         candidate_vote[i] = 1
#
#     elif len(candidate_vote) < MAX_length:
#         if i in candidate_vote.keys():
#             candidate_vote[i] += 1
#         else:
#             candidate_vote[i] = 1
#     else:
#         if i in candidate_vote.keys():
#             candidate_vote[i] += 1
#
#         else:
#

