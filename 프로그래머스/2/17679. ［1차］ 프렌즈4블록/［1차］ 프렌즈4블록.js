/*
    문제 요약: (2*2)로 네 칸이 모이면 사라지는 게임에서 몇 개를 없앨 수 있는지 출력하기.
    
    그래프 전체를 하나씩 탐색하면서 시계방향으로 돌아본다.
    시계방향으로 다 돌아가지면(네 칸이 모이면) 큐에 넣는다.
    
    그래프 한 번 탐색이 끝나면 큐에 있는 요소들을 전부 삭제시킨다.
    
    빈값을 아래로 떨어트린다.
    
    그래프 탐색이 끝나고 큐 길이가 0일 떄까지 반복하기
*/

function solution(m, n, board, ans=0) {
    let queue = []
    const dr = [0, 1, 0, -1], dc = [1, 0, -1, 0]
    
    for(let i=0; i<m; i++) {
        board[i] = [...board[i]]
    }
    
    // 4개가 모여 삭제할 수 있으면 true 반환하는 함수
    const canDelete = (r, c) => {
        const moji = board[r][c]
        if(moji === '-') return false
        for(let i=0; i<dr.length; i++) {
            r += dr[i]
            c += dc[i]
            if(r >= 0 && r < m && c >= 0 && c < n && board[r][c] === moji) {
                if(i === 3) return true       
            } else return false
        }
        return false
    }
    
    // 블록을 아래로 정렬시키는 함수
    const setDownGraph = () => {
        for(let j=0; j<n; j++) {
            let stack = []
            for(let i=0; i<m; i++) {
                if(board[i][j] !== '-') {
                    stack.push(board[i][j])
                    board[i][j] = '-'
                }
            }
            
            for(let i=m-1; i>=0; i--) {
                board[i][j] = stack[stack.length-1] ? stack.pop() : '-'
            }
        }
    }
    
    // 더 삭제할 블록이 없을 때까지 반복
    while(true) {
         // 그래프 전체 탐색
        for(let i=0; i<m; i++) {
            for(let j=0; j<n; j++) {
                if(canDelete(i, j)) { // 삭제할 블록이 있으면
                    let r = i, c = j
                    for(let d=0; d<dr.length; d++) { // 4개 전부 큐에 넣어준다.
                        r += dr[d]
                        c += dc[d]
                        queue.push([r, c])
                    }
                }
            }
        }
        
        // 큐에 아무것도 담기지 않으면(삭제할 블록이 없으면) 종료
        if(queue.length < 1) return ans 

        // 큐에 있는 삭제할 블록들 삭제하기
        while(queue.length > 0) {
            const [r, c] = queue.pop()
            if(board[r][c] !== '-') {
                board[r][c] = '-'
                ans += 1    
            }
        }

        // 삭제한 후 블록 재정렬
        setDownGraph()
    }
   
}