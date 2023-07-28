import sys
from collections import deque
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
def bfs() :
    while queue:
        a, b = queue.popleft()
        for l in range(4):
            nx, ny = a + dx[l], b + dy[l]
            if 0 <= nx < c and 0 <= ny < r and maze[nx][ny] == 1:
                maze[nx][ny] = maze[a][b] + 1
                queue.append([nx, ny])
c, r = map(int, input().split())
maze = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(c)]
queue = deque([])
queue.append([0, 0])
bfs()
print(maze[c-1][r-1])