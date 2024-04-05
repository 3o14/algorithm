/*
    문제 요약: 과일 박스에 K개를 담되 종류를 최소로 했을때, 종류 개수를 반환하기
    
    1. 종류 별로 Map에 정리하고
    2. 긴 것부터 담다가
    3. K개 넘으면 종류 개수 반환
*/

function solution(k, tangerine) {
    let ans = 0, sum = 0
    let box = new Map()
    
    for(let f of tangerine) {
        box.set(f, box.get(f) ? box.get(f)+1 : 1)
    }
    
    box = new Map([...box].sort((a, b) => b[1] - a[1]))
    
    for(let [key, value] of box) {
        sum += value
        ans += 1
        if(sum >= k) return ans
    }
}