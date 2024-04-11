function solution(want, number, discount) {
    let ans = 0
    for(let i=0; i<discount.length; i++) {
        let copy = number.slice()
        for(let j=i; j<i+10; j++) {
            let idx = want.indexOf(discount[j])
            if(idx >= 0) {
                copy[idx] -= 1
            }
        }
        if(copy.filter(e => e <= 0).length === number.length) {
            ans += 1
        }
    }
    
    return ans
}