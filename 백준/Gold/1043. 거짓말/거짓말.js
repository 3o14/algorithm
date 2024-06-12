const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	거짓말
	문제 요약: 지민이가 아무도 모르게 거짓말을 최대로 많이할 수 있는 파티의 개수를 출력하기.

	전체 로직: 진실을 아는 사람을 기준으로 bfs를 돌렸을 때 방문하지 않은 파티의 개수 구하기

	1. que에 진실을 아는 사람을 넣는다.
	2. 사람 한 명을 확인할 때마다 파티 전부를 순회한다. (while문)
	3. 파티를 순회하면서 파티가 true이면서 진실을 아는 자가 포함되어 있으면
		- 해당 파티 멤버 전원을 que에 푸시한다.
		- 해당 파티를 false로 만든다.
	4. True인 파티의 개수를 출력한다.
*/

const solution = (input) => {
	// 사람 수 n, 파티의 수 m
	const [n, m] = input.shift().split(" ").map(Number);
	const visit = new Array(m).fill(true); // 거짓말칠수 있는 파티는 참
	const party = Array.from(new Array(m), () => []);

	// 진실을 아는 사람들 배열 trueQue
	const [trueCnt, ...trueArr] = input.shift().split(" ").map(Number);

	// 진실을 아는 사람이 아무도 없으면 모든 파티의 개수를 출력하면 됨
	if (!trueCnt) return print(m);

	for (let i = 0; i < m; i++) {
		const [cnt, ...arr] = input[i].split(" ").map(Number);
		party[i] = arr;
	}

	// bfs
	let que = trueArr;

	while (que.length > 0) {
		const person = que.pop();

		for (let i = 0; i < m; i++) {
			if (!visit[i]) continue;
			if (party[i].includes(person)) {
				party[i].forEach((v) => que.push(v));
				visit[i] = false;
			}
		}
	}

	print(visit.filter(v => v).length)
};

solution(input);
