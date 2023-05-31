from collections import deque
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
def bfs(queue, maps, n, m) :
    while queue:
        a, b = queue.popleft()
		
        for l in range(4):
            nx, ny = a + dx[l], b + dy[l]

            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1:
                maps[nx][ny] = maps[a][b] + 1
                queue.append([nx, ny])
                
def solution(maps):
    answer = 0
    queue = deque([])
    n, m = len(maps), len(maps[0])
    queue.append([0, 0])
    bfs(queue, maps, n, m)

    if maps[-1][-1] == 1 :
        return -1
    
    return maps[-1][-1] if maps[-1][-1] else -1