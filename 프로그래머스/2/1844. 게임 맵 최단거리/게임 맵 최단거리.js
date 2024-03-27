/*
    문제 요약: 벽을 피해 (n, n)에 도달할 수 있는 최단 거리 출력하기
    
    이전 값을 누적시켜가며 bfs 그래프 탐색
*/

function solution(maps) {
    const dr = [0, 0, 1, -1], dc = [1, -1, 0, 0]
    
    let queue = [[0, 0]]
    while(queue.length > 0) {
        const [r, c] = queue.shift()
        
        for(let i=0; i<dr.length; i++) {
            let nr = r + dr[i]
            let nc = c + dc[i]
            
            if(nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length && maps[nr][nc] === 1) {
                queue.push([nr, nc])
                maps[nr][nc] = maps[r][c] + 1
            }
        }
    }
    
    return maps[maps.length-1][maps[0].length-1] <= 1 ? -1 : maps[maps.length-1][maps[0].length-1]
}