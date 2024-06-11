/*
	DFS와 BFS
	문제 요약: 가능한 정점 중 번호가 작은 것을 먼저 방문하는 식으로 각 BFS, DFS로 실행한 결과 출력하기

	인접행렬 그래프로 간선을 표현한다. -> 정점 번호가 적은 것부터 먼저 탐색하기 쉽도록
	(인접리스트로 표현하면 매번 정렬을 해야하기 때문에 비효율적임)
*/

const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	// n: 정점 개수, m: 간선 개수, start: 시작 지점
	const [n, m, start] = input.shift().split(" ").map(Number);

	// 적은 정점 부터 순회하기 편하도록 인접행렬로 입력 받기
	const graph = Array.from(new Array(n + 1), () => Array(n + 1).fill(false));
	for (let i = 0; i < m; i++) {
		const [a, b] = input[i].split(" ").map(Number);

		graph[a][b] = true;
		graph[b][a] = true;
	}

	let ans_dfs = [];

	const visit_dfs = new Array(n + 1).fill(false);
	const dfs = (v) => {
		visit_dfs[v] = true;
		ans_dfs.push(v);

		for (let i = 0; i < n + 1; i++) {
			if (graph[v][i] && !visit_dfs[i]) dfs(i);
		}
	};

	let ans_bfs = [start];
	const visit_bfs = new Array(n + 1).fill(false);
	const bfs = (v) => {
		const que = [];
		visit_bfs[v] = true;
		que.push(v);

		while (que.length > 0) {
			const n = que.shift();

			for (let i = 0; i < graph[n].length; i++) {
				if (graph[n][i] && !visit_bfs[i]) {
					visit_bfs[i] = true;
					que.push(i);
					ans_bfs.push(i);
				}
			}
		}
	};

	dfs(start);
	print(ans_dfs.join(" "));

	bfs(start);
	print(ans_bfs.join(" "));
};

solution(input);
