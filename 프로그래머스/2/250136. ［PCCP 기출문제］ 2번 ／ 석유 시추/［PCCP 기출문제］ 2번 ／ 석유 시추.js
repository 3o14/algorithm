function solution(land) {
    let max = 0
    let oilMap = new Map()
    
    for(let c=0; c<land[0].length; c++) {
        for(let r=0; r<land.length; r++) {
            let colSet = new Set()
            let oilSum = 0 // 이번 열에서 얻을 수 있는 석유량을 담을 변수
            
            if(land[r][c] === 1) { // 석유가 있으면
                const dr = [0, 1, 0, -1], dc = [1, 0, -1, 0]
                let queue = [[r, c]]
                
                // bfs 탐색
                while(queue.length > 0) {
                    let [curR, curC] = queue.shift()
                    if(land[curR][curC] === 1) {
                        oilSum += 1
                        land[curR][curC] = 0
                        if(!colSet.has(curC)) colSet.add(curC) // colSet에 표시

                        // 사방 탐색
                        for(let i=0; i<dr.length; i++) {
                            let nr = curR + dr[i]
                            let nc = curC + dc[i]
                            if(nc < land[0].length && nc >= 0 && nr < land.length && nr >= 0 && land[nr][nc] === 1) {
                                queue.push([nr, nc])
                            }
                        }
                    }
                }
                
            }
            if(oilSum > 0) {
                    for(let idx of colSet) {
                        oilMap.set(idx, oilMap.has(idx) ? oilMap.get(idx) + oilSum : oilSum)
                    }
                }
        }
         
   }
    return Math.max(...oilMap.values())
}