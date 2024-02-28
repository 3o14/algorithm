// 2로 나누어지면 순간이동, 나누어지지 않으면 한칸 점프
function solution(n, ans=0) {
    while(n > 0) {
        if(!n) break
        
        if(n%2 === 0) {
          n /= 2
        } else {
            ans += 1
            n -= 1
        }
    }
    
    return ans
}