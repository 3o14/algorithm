/*
    문제 요약: 롤 케이크위 토핑 종류를 공평하게 나누는 방법의 수 출력하기.
    
    1. 나의 토핑을 담는 map(key:종류, value:개수)과 동생의 토핑 map을 각각 만들고
    2. 인덱스 1부터 한칸씩 옮기면서 공평한지 확인하기
    3. 공평하면 ans+=1 하고 전부 확인하면 ans 출력
*/
function solution(topping, ans=0) {
    let mine = new Map()
    let brother = new Map()
    
    mine.set(topping[0], 1)
    for(let i=1; i<topping.length; i++) {
        brother.set(topping[i], brother.get(topping[i]) ? brother.get(topping[i])+1 : 1)
    }
    
    let idx = 1
    while(idx < topping.length) {
        // 토핑 같은지 확인
        if(mine.size === brother.size) ans++
        // 내거에 토핑 하나 더하기
        mine.set(topping[idx], mine.get(topping[idx]) ? mine.get(topping[idx])+1 : 1)
        // 동생거에서 토핑 하나 빼기
        if(brother.has(topping[idx])) {
            brother.set(topping[idx], brother.get(topping[idx])-1)
        }
        if(brother.get(topping[idx]) === 0) brother.delete(topping[idx])
        
        // 다음
        idx++
    }
    
    return ans
}