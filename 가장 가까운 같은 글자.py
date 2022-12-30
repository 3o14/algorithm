def solution(s):
    answer = []
    word = {}
    
    for i, w in enumerate(list(s)):
        if w not in word:
            answer.append(-1)
            word[w] = i
        else:
            answer.append(i - word[w])
            word[w] = i
    return answer