
class Queue {
  constructor() {
    this.queue = [];
  }

  enqueue(item) {
    this.queue.push(item);
  }

  dequeue() {
    if (this.queue.length === 0) {
      return null; // 큐가 비어있을 경우 null 반환
    }
    return this.queue.shift();
  }
  isEmpty() {
    return this.queue.length === 0;
  }
}

const bfs = (queue, maps, n, m) => {
    const dx = [-1, 1, 0, 0], dy = [0, 0, -1, 1];
    
    while (!queue.isEmpty()) {
        let arr = queue.dequeue(); // a: arr[0], b: arr[1]

        for(let i = 0; i < 4; i++) {
            let nx = arr[0] + dx[i], ny = arr[1] + dy[i];
            // console.log(nx, ny);
            
            if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && maps[nx][ny] === 1) {
                maps[nx][ny] = maps[arr[0]][arr[1]] + 1;
                queue.enqueue([nx, ny]);    
            }
        }
    }
}

function solution(maps) {
    var answer = 0;
    const n = maps.length, m = maps[0].length;
    const queue = new Queue();
    
    queue.enqueue([0, 0]);
    
    bfs(queue, maps, n, m);

    return maps[maps.length - 1][maps[0].length - 1] === 1 ? -1 : maps[maps.length - 1][maps[0].length - 1]
}