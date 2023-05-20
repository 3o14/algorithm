def solution(survey, choices):
    answer = ''
    
    mbti = {
        "RT": 0,
        "CF": 0,
        "JM": 0,
        "AN": 0,
    }
    
    for i in range(len(survey)) :
        if survey[i] in mbti:
            mbti[survey[i]] += choices[i] - 4
        else :
            survey[i] = survey[i][::-1]
            mbti[survey[i]] -= choices[i] - 4
        
    print(mbti)
    for e in mbti:
        list(e)
        if mbti[e] > 0 :
            answer += e[1]
        else :
            answer += e[0]
        
    return answer