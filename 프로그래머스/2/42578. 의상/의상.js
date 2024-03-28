/*
    문제 요약: [옷이름, 옷종류]로 이루어진 리스트가 주어질 때, 옷을 매일 다르게 입을 수 있는 조합의 개수 출력하기
    
    옷 종류별로 몇개인지 해시에 담아두고
    조합 계산하기 => A종류의 옷 개수 * B종류의 옷 개수 * ... - 아무것도 안 입는 경우(1)
*/

function solution(clothes, ans=1) {
    let map = {}
    
    for(let c of clothes) {
        map[c[1]] = ( map[c[1]] || 1 ) + 1
    }
    
    for(let i in map) {
        ans *= map[i]
    }
    
    return ans - 1
}