const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	BOJ 1167. 트리의 지름

	그래프의 모든 정점을 순회하면서 dfs로 더 갈 길이 없을 때까지 탐색.
	가장 비용이 큰 길을 찾으면 그 비용을 출력한다.
*/

const solution = (input) => {
	const n = parseInt(input.shift());
	let visit = new Array(n + 1).fill(false);
	const graph = Array.from(new Array(n + 1), () => []); // 3차원 배열이 될 예정

	input.forEach((e) => {
		const [v, ...edges] = e.split(" ").map(Number);

		for (let i = 0; i < edges.length - 1; i += 2) {
			graph[v].push([edges[i], edges[i + 1]]);
		}
	});

	// 입력받기 끝

	let max = [0, 0]; // 노드, 거리
	const dfs = (v, distance) => {
		visit[v] = true;

		if (distance > max[1]) max = [v, distance];
		for (let [next, nextDistance] of graph[v]) {
			if (visit[next]) continue;
			dfs(next, distance + nextDistance);
		}
	};

	dfs(1, 0);
	max[1] = 0;
	visit = new Array(n + 1).fill(false);

	dfs(max[0], 0);
	print(max[1]);
};

solution(input);
