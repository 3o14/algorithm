import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
visited = [False for _ in range(n+1)]
graph = [[]*n for _ in range(n+1)]
cnt = 0
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
def bfs(S):
    queue = deque([S])
    visited[S] = True
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if not (visited[i]):
                queue.append(i)
                visited[i] = True
for j in range(1, n+1):
    if visited[j] == False:
        bfs(j)
        cnt += 1
print(cnt)