function solution(prices, ans=[]) {
    prices.forEach((e, i) => {
        let min = 1 // 항상 1초간은 가격 안떨어지기 때문에 1로 시작
        
        // 현재 주식 가격부터 가격 떨어지는지 확인
        for(let j=i+1; j<prices.length-1; j++) {
            // 가격이 떨어지지 않으면
            if(e <= prices[j]) {
                min += 1
            } else break // 떨어지면 그만 보기
        }
        ans.push(i === prices.length-1 ? 0 : min) // 마지막 요소이면 0, 아니면 min 반환
    })
    
    return ans
}