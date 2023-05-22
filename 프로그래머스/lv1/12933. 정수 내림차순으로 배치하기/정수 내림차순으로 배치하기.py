def solution(n):
    answer = list(map(int, str(n)))
    return int("".join(map(str, sorted(answer, reverse=True))))