function solution(n, computers, ans=0) {
    let arr = new Array(computers.length).fill(false)
    const bfs = (i, j) => {
        const queue = [[i, j]]
        arr[i] = true
        arr[j] = true
        computers[i][j] = 0
        computers[j][i] = 0
        
        while(queue.length > 0) {
            const node = queue.shift()
            const [r, c] = node
            
            for(let i=0; i<computers[0].length; i++) {
                if(c !== i && computers[c][i] === 1) {
                    queue.push([c, i])
                    arr[c] = true
                    arr[i] = true
                    computers[c][i] = 0
                    computers[i][c] = 0
                }
            }
        }
    }
    
    for(let i=0; i<computers.length; i++) {
        for(let j=0; j<computers[0].length; j++) {
            if(i !== j && computers[i][j] === 1) {
                // console.log(i,j)
                bfs(i, j)
                ans++
            }
        }
    }
    
    arr.forEach((e) => {
        if(!e) ans++
    })
    return ans
}