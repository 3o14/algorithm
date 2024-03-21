function solution(targets, ans=1) {
    targets.sort((a, b) => b[0] - a[0])
    
    let point = targets[0][0]
    
    for(let i=1; i<targets.length; i++) {
        const [start, end] = targets[i]
        
        if(end <= point) {
            ans += 1
            point = start
        }
    }
    
    return ans
}