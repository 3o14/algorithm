/*
    문제 요약: 간선으로 연결된 노드 무리를 네트워크라고 함. 이 네트워크 개수를 구하기
    
    주어진 그래프를 탐색하다 1일 경우 해당 노드와 연결된 노드를 다시 탐색한다.
    (1, 2)가 연결되어 있을 경우 2번 행을 다시 1부터 열 길이만큼 탐색해서 1이면 queue에 넣는다.
    queue의 노드를 하나씩 같은 방식으로 탐색한다.
    
    모든 탐색이 끝나고 방문하지 않은 노드들의 개수를 ans에 더해준다.
    (간선이 없는 노드들은 하나의 네트워크이기 때문에)
    
    ans를 반환한다.
*/

function solution(n, computers, ans=0) {
    // 혼자 있는 정점을 세기 위해 노드 방문 체크용 배열
    let visit = new Array(computers.length).fill(false)
    
    const bfs = (i, j) => {
        const queue = [[i, j]]
        // 노드 방문 체크
        visit[i] = true
        visit[j] = true
        // 확인한 간선 0으로 바꿔주기
        computers[i][j] = 0
        computers[j][i] = 0
        
        while(queue.length > 0) {
            const node = queue.shift()
            const [r, c] = node
            
            for(let i=0; i<computers[0].length; i++) {
                if(c !== i && computers[c][i] === 1) {
                    queue.push([c, i])
                    visit[c] = true
                    visit[i] = true
                    computers[c][i] = 0
                    computers[i][c] = 0
                }
            }
        }
    }
    
    for(let i=0; i<computers.length; i++) {
        for(let j=0; j<computers[0].length; j++) {
            if(i !== j && computers[i][j] === 1) {
                bfs(i, j)
                ans++
            }
        }
    }
    
    visit.forEach((e) => {
        if(!e) ans++
    })
    return ans
}