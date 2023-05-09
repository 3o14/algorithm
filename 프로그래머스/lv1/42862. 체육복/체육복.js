function solution(n, lost, reserve) {
    let answer = 0;
    lost = lost.sort((a, b) => a - b);
    reserve = reserve.sort((a, b) => a - b);
    lost.map(e => {
        if(reserve.includes(e)){ // 여벌 체육복을 가져온 학생이 도난당했을 경우 제외
            reserve[reserve.indexOf(e)] = 0;
            lost[lost.indexOf(e)] = 0;
        }
    })
    console.log("--여벌 가진 애들이 도난당한 경우 제외 후의 lost: " ,lost);
    lost.map(e => {
        if(reserve.includes(e-1) && (e-1) !== 0) {
            console.log("if e: ", e);
            // 여벌 체육복을 가지고 있는 학생이면
            reserve[reserve.indexOf(e-1)] = 0; // 해당 학생 삭제
            lost[lost.indexOf(e)] = 0;
        }else if(reserve.includes(e+1)){
            console.log("elseif e: ", e);
            reserve[reserve.indexOf(e+1)] = 0;
            lost[lost.indexOf(e)] = 0;
        }
        console.log("lost array: ", lost);
        console.log("reserve arr: ", reserve);
    })
    lost = lost.filter(e => e > 0);
    console.log(lost)
    answer = n - lost.length
    return answer;
}