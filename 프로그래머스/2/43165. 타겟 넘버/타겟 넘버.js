// 부분 집합
function solution(numbers, target, ans=0) {
    let visit = new Array(numbers.length).fill(false)
    let result = []
    
    const dfs = (depth) => {
        if(depth === numbers.length) {
            let sum = 0
            numbers.forEach((e, i) => {
                sum += visit[i] ? numbers[i] : -numbers[i]
            })
            if(sum === target) ans += 1
        } else {
            visit[depth] = true
            dfs(depth+1)
            visit[depth] = false
            dfs(depth+1)
        }
    }
    
    dfs(0)
    
    return ans
}