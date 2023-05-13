function solution(k, m, score) {
    // 가장 낮은 점수 * 개수 = 한 상자 가격
    // 최대 이익 계산
    // m개만큼 가장 높은 수만 모아서 계산
    // 내림차순 sorting -> 인덱스 m만큼 slice -> 마지막 원소 * m
    
    let sales = 0; // 총 매출 담을 변수
    
    score.sort((a, b) => b - a);
    // console.log(score);
    
    for(let i = 0; i < Math.floor(score.length/m); i++) {
        const box = score.slice(m*i, (m*(i+1)));
        // console.log(m*i, (m*(i+1)));
        // console.log("box: ", box);
        sales += box.slice(-1)*m;
        // console.log("Sales: ", sales);
    }
    
    return sales;
}