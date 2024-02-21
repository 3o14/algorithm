// 단순히 1부터 n까지 돌면서 소수찾으니 시간초과 나서 아래처럼 품
function solution(n, ans=0) {
    let primes = new Array(n+1).fill(true)
    for(let i=2; i<=Math.sqrt(n) ;i++) {
        for(let j=i*i; j<=n; j+=i) {
            primes[j] = false
        }
    }
    primes.forEach((e, i) => {
        if(i>=2&&e) ans++
    })
    return ans
}