def solution(ingredient):
    s = []
    cnt = 0
    for i in ingredient:
        s.append(i)
        # [-4:] -> 끝에서 네번째 원소부터 끝까지
        if s[-4:] == [1, 2, 3, 1]:
            cnt += 1
            for i in range(4):
                s.pop()
    return cnt