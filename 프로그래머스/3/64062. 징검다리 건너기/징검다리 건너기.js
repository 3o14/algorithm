/*
    디딤돌을 1씩 다 빼보는게 아니라 (시간 초과)
    디딤돌이 가질 수 있는 수를 큰 수부터 이분 탐색으로 하나씩 디딤돌 수에 다 빼보고
    0 이하인 수가 k연속인지 검사한다. k 연속으로 0 이하일 경우
    왼쪽 수들을 다시 탐색, k 연속이 아닐 경우는 오른쪽을 다시 탐색
*/

function solution(stones, k) {
    let left = 1, right = 200000000
    
    while (left <= right) {
        let count = 0
        let mid = Math.floor((left + right) / 2)
        
        for(let i=0; i<stones.length; i++) {
            if(stones[i] <= mid) {
                count += 1
            } else {
                count = 0
            }
            
            if(count === k) break
        }
        
        if(count === k) right = mid - 1
        else left = mid + 1
    }
    
    return left
}