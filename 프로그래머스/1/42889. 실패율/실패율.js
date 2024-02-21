const getCount = (num, arr) => {
    let result = 0
    let idx = arr.indexOf(num)
    while(idx != -1) {
        idx = arr.indexOf(num, idx+1)
        result++    
    }
    return result
}

function solution(N, stages, ans=[]) {
    let fail_percent = new Array(N).fill(0)
    
    let i = 0
    let prevCnt = 0
    while(i < N+1) {
        const curCnt = getCount(i+1, stages)
        const percent_below = stages.length - prevCnt
        fail_percent[i] = percent_below > 0 ? curCnt/percent_below : 0 
        prevCnt += curCnt
        i += 1
    }

    fail_percent = fail_percent.slice(0, fail_percent.length-1)
    
    fail_percent.forEach(() => {
        const max = Math.max(...fail_percent)
        const idx = fail_percent.indexOf(max)
    
        fail_percent[idx] = -1
        ans.push(idx+1)
    })
    
    return ans
}