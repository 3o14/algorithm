def solution(t, p):
    answer = 0
    len_p = len(p)
    len_t = len(t)
    
    list(t)
    p = int(p)
    for i in range(0, len_t):
        word = ""
        if len_t - i < len_p :
            # print("범위초과")
            break;
            
        n = i
        for j in range(0, len_p):
            word += t[n]
            n += 1
        
        # print(word)
        num = int(word)
        if num <= p :
            answer += 1
            # print("count++")

    return answer

# for문으로 p의 길이만큼 문자를 따내서 숫자로 변환
# 그 숫자와 p 크기 비교 후 카운트