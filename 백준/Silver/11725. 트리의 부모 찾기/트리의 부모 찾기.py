from collections import deque

n = int(input())
tree = [[]*n for _ in range(n+1)]
queue = deque([])
visited = [False for _ in range(n+1)]
result = [[]*n for _ in range(n+1)]

for i in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

queue.append(1)
visited[1] = True

def bfs():
    while queue:
        a = queue.popleft()
        for i in tree[a]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                result[i] = a

bfs()

for i in result:
    if i:
        print(i)