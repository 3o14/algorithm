function solution(prices, ans=[]) {
    prices.forEach((e, i) => {
        let min = 1
        for(let j=i+1; j<prices.length-1; j++) {
            if(e <= prices[j]) {
                min += 1
            } else break
        }
        ans.push(i === prices.length-1 ? 0 : min)
    })
    
    return ans
}