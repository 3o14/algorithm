/*
	결혼식
	문제 요약: 상근이의 결혼식에 초대할 사람의 수를 구하는 문제 (상근이의 친구, 친구의 친구까지만 초대)

	bfs 사용
	1. 상근이는 1이므로, 1과 연결된 숫자를 큐에 담고 방문처리를 한다.
	2. 큐에 담은 숫자의 친구들의 방문처리를 한다.
	3. 총 방문처리된 개수를 구한다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = +input.shift();
	const m = +input.shift();

	const graph = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));
	const visited = new Array(n + 1).fill(false);

	// 인정행렬로 상근이 친구들 정보 입력받기
	for (let i = 0; i < m; i++) {
		const [a, b] = input[i].split(" ").map(Number);
		graph[a][b] = 1;
		graph[b][a] = 1;
	}

	const que = [];

	// 1. 상근이는 1이므로, 1과 연결된 숫자를 큐에 담고 방문처리를 한다.
	graph[1].forEach((e, i) => {
		if (e === 1) {
			que.push(i);
			visited[i] = true;
		}
	});

	// 2. 큐에 담은 숫자의 친구들의 방문처리를 한다.
	// 상근이 친구의 친구까지만 초대하므로 두번째 친구부터는 큐에 넣지 않음
	while (que.length > 0) {
		const v = que.shift();
		graph[v].forEach((e, i) => {
			if (e === 1 && !visited[i]) {
				visited[i] = true;
			}
		});
	}

	// 3. 총 방문처리된 개수를 구한다.
	const ans = visited.filter((e) => e === true).length - 1;
	print(ans > 0 ? ans : 0);
};

solution(input);
