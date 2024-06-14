const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	트리
	문제 설명: 주어진 그래프 정보를 보고 트리가 몇 개 존재하는지 개수 출력하기
	
	트리는 그래프 중에서 사이클이 존재하지 않는 그래프를 말한다.
	요는 사이클을 형성하는지 않는지를 검증하기이다. -> 직전에 방문한 노드가 아니면서 이미 방문한 적이 있는 노드에 방문하면 사이클이 형성됨
*/

const solution = (input) => {
	let idx = 0;
	let treeCnt = [];
	while (true) {
		const [n, edge] = input[idx++].split(" ").map(Number);
		if (n === 0 && edge === 0) break;

		// 그래프 생성
		let graph = Array.from(new Array(n + 1), () => []);
		let visit = new Array(n + 1).fill(false);
		treeCnt.push(0);

		// 간선 정보 입력받기
		for (let i = 0; i < edge; i++) {
			const [start, end] = input[idx++].split(" ").map(Number);

			graph[start].push(end);
			graph[end].push(start);
		}

		// 사이클이 있는지 dfs 탐색
		const dfs = (v, prev, visited) => {
			visited[v] = true;
			for (let next of graph[v]) {
				if (!visited[next]) {
					if (dfs(next, v, visited)) return true;
				} else if (next !== prev) return true;
			}

			return false;
		};

		// 그래프 노드 하나씩 탐색
		for (let i = 1; i <= n; i++) {
			// 아직 탐색하지 않은 노드만 탐색
			if (!visit[i]) {
				const isTree = dfs(i, 0, visit);
				if (!isTree) treeCnt[treeCnt.length - 1]++;
			}
		}
	}

	let ans = [];
	treeCnt.forEach((n, i) => {
		if (n > 1) ans.push(`Case ${i + 1}: A forest of ${n} trees.`);
		if (n === 1) ans.push(`Case ${i + 1}: There is one tree.`);
		if (n === 0) ans.push(`Case ${i + 1}: No trees.`);
	});

	print(ans.join("\n"));
};

solution(input);
