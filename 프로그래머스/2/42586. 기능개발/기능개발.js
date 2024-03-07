function solution(progresses, speeds, ans=[]) {
    for(let i=0; i<progresses.length; i++) {
        progresses[i] = 100 - progresses[i]
        progresses[i] = Math.ceil(progresses[i]/speeds[i])
    }
    
    let cnt=1
    for(let i=0; i<progresses.length; i++) {
        cnt = 1
        for(let j=i+1; j<progresses.length; j++) {
            if(progresses[i] >= progresses[j]) {
                cnt += 1
            } else {
                i = j-1
                break
            }
        }
        if(ans.length && ans.reduce((acc, prev) => acc+prev) === progresses.length) return ans
        ans.push(cnt)
    }
    
    return ans
}