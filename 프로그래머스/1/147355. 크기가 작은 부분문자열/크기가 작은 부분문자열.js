function solution(t, p, ans=0) {
    [...t].forEach((e, i) => {
        const word = t.slice(i, i+p.length)
        if(word.length === p.length) {
            ans += +word <= +p ? 1 : 0
        }
    })
    
    return ans
}