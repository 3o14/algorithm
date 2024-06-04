/*
	연결 요소의 개수
	문제 요약: 간선 정보를 입력받고 연결 요소의 개수를 출력하기
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const [n, m] = input.shift().split(" ").map(Number);
	const arr = input.map((e) => e.split(" ").map(Number))
	const graph = Array.from(new Array(n + 1), () => []);
	const visit = Array(n + 1).fill(false);
	let ans = 0

	arr.map(([u, v]) => {
		graph[u].push(v)
		graph[v].push(u)
	})

	const dfs = (start) => {
		for(const v of graph[start]) {
			if(!visit[v]) {
				visit[v] = true
				dfs(v)
			}
		}
	};

	for(let i=1; i<=n; i++) {
		if(!visit[i]) {
			dfs(i)
			ans++
		}
	}

	print(ans)
};

solution(input);
