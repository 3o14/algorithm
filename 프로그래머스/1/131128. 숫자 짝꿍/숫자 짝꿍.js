function solution(X, Y, ans='') {
    const xArr = new Array(10).fill(0)
    const yArr = new Array(10).fill(0)
    
    X = [...X].forEach((e) => {
        xArr[e] += 1
    })
    
    Y = [...Y].forEach((e) => {
        yArr[e] += 1
    })
    
    for(let i=9; i>=0; i--) {
        if(xArr[i] !== 0 && yArr[i] !== 0) {
            ans += i.toString().repeat(Math.min(xArr[i], yArr[i]))
        }
    }
    
    if(ans[0] === '0' && ans[ans.length-1] === '0') return '0'
    
    return ans ? ans : '-1'
}