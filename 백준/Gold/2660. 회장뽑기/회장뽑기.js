/*
	회장 뽑기
	관계의 수가 간선 하나당 1일 때 모두와 가장 친한 사람을 회장으로 뽑는 문제이다.

	모든 정점에서 모든 정점으로의 최단거리를 구하는 플로이드 워셜 알고리즘 사용하기

*/

const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = +input.shift();
	const graph = Array.from(new Array(n), () => Array(n).fill(n));
	const dist = Array(n).fill(0);

	// 각 정점 자기 자신을 제외시키는 작업
	for (let i = 0; i < n; i++) {
		for (let j = 0; j < n; j++) {
			if (i === j) graph[i][j] = 0;
		}
	}

	// 친구 관계 (거리가 1인 값) 입력받기
	for (let i = 0; i < input.length; i++) {
		const [a, b] = input[i].split(" ");
		if (a === b) break;
		graph[a - 1][b - 1] = 1;
		graph[b - 1][a - 1] = 1;
	}

	// 플로이드 워셜
	for (let k = 0; k < n; k++) {
		for (let i = 0; i < n; i++) {
			for (let j = 0; j < n; j++) {
				graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
			}
		}
	}

	// 각 사람의 점수 계산하기 (가진 관계 중 제일 큰 값이 점수임)
	for (let i = 0; i < n; i++) dist[i] = Math.max(...graph[i]);

	// 모든 사람 중 가장 적은 값이 회장이다.
	const score = Math.min(...dist);
	const ans = [];
	dist.forEach((v, i) => {
		if (v === score) ans.push(i+1);
	});

	print(score, ans.length)
	print(ans.join(" "))
};

solution(input);
