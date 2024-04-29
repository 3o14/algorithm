/*
  문제 요약: 토마토가 다 익기까지 며칠이 걸리는지 구하는 문제 (토마토 상자는 3차원 배열이다.)

	1. 토마토 상자 정보를 3차원 배열에 입력받는다.
	2. 익은 토마토의 위치를 찾아 큐에 넣는다. (이때 x, y, z와 함께 일수도 같이 넣기) (이떄 안익은 토마토 개수도 세기)
	3. 큐에서 하나씩 꺼내면서 익은 토마토의 상하좌우위아래를 확인하는데,
	4. 안익은 토마토가 있으면 익은 토마토로 바꾸고 안익은 토마토 개수를 -1 한다.
	5. days를 출력하되 안익은 토마토가 0이 아니면 -1을 출력한다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const [M, N, H] = input.shift().split(" ").map(Number);
	const boxes = Array.from(Array(H), () =>
		Array.from(Array(N), () => Array.from(Array(M).fill(0)))
	);
	const que = [];
	const dx = [-1, 1, 0, 0, 0, 0];
	const dy = [0, 0, -1, 1, 0, 0];
	const dz = [0, 0, 0, 0, -1, 1];

	for (let i = 0; i < H; i++) {
		for (let j = 0; j < N; j++) {
			boxes[i][j] = input.shift().split(" ").map(Number);
		}
	}

	let notYetTomato = 0;
	for (let i = 0; i < H; i++) {
		for (let j = 0; j < N; j++) {
			for (let k = 0; k < M; k++) {
				if (boxes[i][j][k] === 0) notYetTomato++;
				if (boxes[i][j][k] === 1) que.push([i, j, k, 0]);
			}
		}
	}

	let idx = 0;
	let ans = 0;
	while (que.length > idx) {
		const [z, x, y, days] = que[idx++];

		// 상 하 좌 우 위 아래 6방향 탐색
		for (let i = 0; i < 6; i++) {
			const nx = x + dx[i];
			const ny = y + dy[i];
			const nz = z + dz[i];

			if (
				nz >= 0 &&
				nz < H &&
				nx >= 0 &&
				nx < N &&
				ny >= 0 &&
				ny < M &&
				!boxes[nz][nx][ny]
			) {
				boxes[nz][nx][ny] = 1; // 토마토 익힘
				que.push([nz, nx, ny, days + 1]); // 큐에 해당 위치와 하루 증가한 값 담기
				notYetTomato--; // 안 익은 토마토 개수 감소
			}
		}
		ans = days;
	}
	print(notYetTomato ? -1 : ans);
};

solution(input);
