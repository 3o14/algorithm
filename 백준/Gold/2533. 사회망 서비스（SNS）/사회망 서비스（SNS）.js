const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	사회망 서비스(SNS)

	특정 노드 v가 얼리 어답터일 때와 아닐 때를 구해보자.

	v가 얼리어답터일 때) v와 연결된 사람들은 얼리 어답터이거나 아니다.
	v가 얼리어답터가 아닐때) v와 연결된 모든 사람들은 얼리 어답터이다.
	
	루트 노드로부터 리프노드까지 재귀로 탐색하여 특정 노드가 얼리어답터일 때와 아닐때 해당 노드를 루트로 하는 트리에서 필요한 얼리 어답터의 수를 저장한다.
*/

const solution = (input) => {
	let n = parseInt(input.shift());
	let visit = new Array(n + 1).fill(false);
	let graph = Array.from(new Array(n + 1), () => []);
	let dp = Array.from(Array(n + 1), () => [0, 1]);

	for (let i = 0; i < input.length; i++) {
		const [start, end] = input[i].split(" ").map(Number);
		graph[start].push(end);
		graph[end].push(start);
	}

	const dfs = (v) => {
		visit[v] = true;

		for (let next of graph[v]) {
			if (!visit[next]) {
				dfs(next);
				dp[v][0] += dp[next][1];
				dp[v][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	};

	dfs(1);
	print(Math.min(dp[1][0], dp[1][1]));
};

solution(input);
