/*
    문제 요약: 요격 시스템과 같은 문제
*/

function solution(routes, ans=1) {
    routes.sort((a, b) => b[0] - a[0])
    
    let point = routes[0][0]
    
    for(let i=1; i<routes.length; i++) {
        const [start, end] = routes[i]
        
        if(end < point) {
            ans++
            point = start
        }
    }
    
    return ans
}