// 부분 집합
function solution(numbers, target, ans=0) {
    let result = []
    
    const dfs = (sum, depth) => {
        if(depth === numbers.length) {
            if(sum === target) ans += 1
        } else {
            dfs(sum + numbers[depth], depth+1) // 더하기
            dfs(sum - numbers[depth], depth+1) // 빼기
        }
    }
    
    dfs(0, 0)
    return ans
}