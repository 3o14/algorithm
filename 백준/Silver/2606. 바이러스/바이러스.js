/*
  문제 요약: 컴퓨터들이 네트워크로 연결되어 있을 때, 1번 컴퓨터와 연결된 컴퓨터의 수를 구하는 문제.

	1. 간선 정보를 map 그래프에 입력받는다.
	2. 노드 방문 여부를 체크할 visited 배열을 만든다.
	3. dfs를 통해 1번 컴퓨터와 연결된 컴퓨터들을 모두 방문하고 카운트를 센다.
	4. 결과값을 출력.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const N = parseInt(input.shift());
	const M = parseInt(input.shift());
	const map = Array.from(Array(N + 1), () => Array());
	const visited = Array(N + 1).fill(false);
	let ans = 0;

	for (let i = 0; i < M; i++) {
		const [a, b] = input[i].split(" ").map(Number);
		map[a].push(b);
		map[b].push(a);
	}

	const dfs = (node, map) => {
		visited[node] = true;
		for (let i = 0; i < map[node].length; i++) {
			const next = map[node][i];
			if (!visited[next]) {
				ans++;
				dfs(next, map);
			}
		}
	};

	dfs(1, map);

	print(ans);
};

solution(input);
