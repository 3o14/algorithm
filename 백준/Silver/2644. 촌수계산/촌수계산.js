/*
	촌수 계산
  문제 요약: 부모 자식 관계가 주어질 때 촌수를 계산하는 문제

	1. 부모 자식 관계를 나타내는 배열을 만들어준다.
	2. 촌수를 계산할 두 사람을 입력받는다.
	3. DFS를 이용하여 촌수를 계산한다.
		- 시작점과 끝점이 같으면 촌수를 출력한다.
		- 시작점과 연결된 노드를 탐색하며 방문하지 않은 노드를 방문한다.
	4. 출력한다.

*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const N = parseInt(input.shift());
	const [a, b] = input.shift().split(" ").map(Number);
	const M = parseInt(input.shift());
	const graph = Array.from(Array(N + 1), () => []);
	const visited = Array(N + 1).fill(false);

	for (let i=0; i<M; i++) {
		const [a, b] = input[i].split(" ").map(Number);
		graph[a].push(b);
		graph[b].push(a);
	}

	const dfs = (start, end, cnt) => {
		visited[start] = true;
		if (start === end) {
			print(cnt);
			return;
		}


		for (let i=0; i<graph[start].length; i++) {
			const next = graph[start][i];
			if (!visited[next]) {
				dfs(next, end, cnt + 1);
			}
		}
	}

	dfs(a, b, 0);

	if (!visited[b]) {
		print(-1);
	}
};

solution(input);
