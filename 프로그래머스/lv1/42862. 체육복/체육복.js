function solution(n, lost, reserve) {
    let answer = 0;
    
    // 학생 객체 생성
    let stu = {}
    
    // 모든 학생은 체육복 하나씩 소지
    for (let i = 1; i < n+1; i++) {
        stu[i] = 1;
    }
    
    // lost 빼고 reserve 넣고
    reserve.forEach(e => stu[e]++);
    lost.forEach(e => stu[e]--);    
    
    console.log(stu);
    
    // 체육복 빌려주기
    for(let i = 1; i < n+1; i++) {
        if(stu[i] === 0 && stu[i-1] > 1) {
            stu[i]++;
            stu[i-1]--;
        }else if(stu[i] === 0 && stu[i+1] > 1 ) {
            stu[i]++;
            stu[i+1]--;
        }
    }
    for(let i = 1; i < n+1; i++) {
        if(stu[i] >= 1) {
            answer++;
        }
    }
    
    return answer;
}