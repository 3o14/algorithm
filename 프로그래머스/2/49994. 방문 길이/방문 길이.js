/*
    문제 요약: 이미 갔던 길을 제외하고 총 이동한 거리 출력하기
    
    set에 이동한 위치를 (시작점-출발점) 형식으로 넣는다. (set -> 중복 제거)
    
*/

function solution(dirs) {
    let set = new Set()
    let now = [0, 0]
    
    const move = {
        D: [1, 0],
        U: [-1, 0],
        R: [0, 1],
        L: [0, -1],
    }
    
    for(let dir of dirs) {
        let nr = now[0] + move[dir][0]
        let nc = now[1] + move[dir][1]
        
        if(nr < -5 || nr > 5 || nc < -5 || nc > 5) continue
        
        // 시작점-출발점 을 함께 Set하기
        set.add(`${now[0]}${now[1]}${nr}${nc}`)
        set.add(`${nr}${nc}${now[0]}${now[1]}`)

        now = [nr, nc]
    }
    
    return set.size/2
}