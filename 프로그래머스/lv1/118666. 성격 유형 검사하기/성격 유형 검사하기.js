function solution(survey, choices) {
    let answer = "";
    let mbti = {
        "RT": 0,
        "CF": 0,
        "JM": 0,
        "AN": 0,
    }
    
    for(let i = 0; i < survey.length; i++){
        if(survey[i] in mbti){
            mbti[survey[i]] += choices[i] - 4;
        }else {
            survey[i] = survey[i].split("").reverse().join("");
            mbti[survey[i]] += -(choices[i] - 4);
        }
        console.log(mbti);
    }
    
    
    for(e in mbti){
        e.split("");
        console.log(e, mbti[e]);
        if (mbti[e] > 0) answer += e[1];
        else answer += e[0]
    }
    
    return answer;
}