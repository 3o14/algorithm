// S(시작점)를 찾는다.
// routes를 정보를 토대로 움직인다.
// '방향'대로 '몇번' 반복 이동하다가 X를 만나거나 범위를 벗어나면 반복을 그만둔다.
// routes 순회가 끝났을때 마지막 지점이 도착 지점

function solution(park, routes) {
    const dir = {
        E: [0, 1],
        S: [1, 0],
        W: [0, -1],
        N: [-1, 0]
    }
    let r=-1, c=-1
    
    // 1. 시작 지점 S를 찾는다.
    for(let i=0; i<park.length; i++) {
        const row = [...park[i]]
        for(let j=0; j<row.length; j++) {
            if(park[i][j] === 'S') {
                r = i, c = j
            }
        }
    }
    
    // 3. 로봇을 이동시키는 move 함수
    const move = (r, c, d, n) => {
        let nr = r, nc = c
        
        // 이동 횟수만큼 반복
        for(let i=0; i<n; i++) {
            nr += dir[d][0]
            nc += dir[d][1]
            
            // 범위를 벗어나거나 장애물 'X'를 만나면 원래 좌표를 반환시킨다. (이번 명령은 무시됨을 의미)
            if(nr >= park.length || nr < 0 || nc >= park[0].length || nc < 0) return [r, c]
            if(park[nr][nc] === 'X') return [r, c]
        }
        
        // 명령을 무사히 완수하면 이동한 좌표를 반환한다.
        return [nr, nc]
    }
    
    // 2. routes를 돌면서 로봇을 이동시킨다.
    for(let k=0; k<routes.length; k++) {
        const [d, n] = routes[k].split(' ') // (예) ['E', '5']
        let [row, col] = move(r, c, d, n) // 3. 로봇을 이동시키는 move 함수
        r = row, c = col
    }
    
    return [r, c]
}