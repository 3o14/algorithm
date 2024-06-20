const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	BOJ 14267. 회사 문화1

	내리 칭찬

	단방향그래프이기 때문에 연결리스트로 그래프 정보를 입력받되 한쪽 방향으로만 입력한다.
*/

const solution = (input) => {
	const [n, m] = input[0].split(" ").map(Number);
	const graph = Array.from(new Array(n + 1), () => []);

	const arr = input[1].split(" ").map(Number);
	const score = new Array(n + 1).fill(0);

	arr.forEach((e, i) => {
		// 해당 노드의 부하 정보를 입력
		if (e > 0) graph[e].push(i + 1);
	});

	// 시간 초과 코드 dfs
	// const dfs = (node, goodjob) => {
	// 	score[node] += goodjob;

	// 	for (let subNode of graph[node]) {
	// 		dfs(subNode, goodjob);
	// 	}
	// };

	// for (let i = 2; i <= m+1; i++) {
	// 	const [node, goodjob] = input[i].split(" ").map(Number);

	// 	dfs(node, goodjob);
	// }

	const bfs = (node) => {
		let que = [node];
		let idx = 0;

		while (que.length > idx) {
			const node = que[idx++];
			for (const next of graph[node]) {
				score[next] += score[node]
				que.push(next);
			}
		}
	};

	for (let i = 2; i <= m + 1; i++) {
		const [node, goodjob] = input[i].split(" ").map(Number);

		score[node] += goodjob;
	}

	bfs(1)
	
	print(score.slice(1).join(" "));
};

solution(input);
