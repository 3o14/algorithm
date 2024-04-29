/*
  문제 요약: 적록색약이 있는 사람이 보는 구역의 개수와 정상인의 눈에 보이는 구역의 개수를 각각 출력하기

	1. 정상인 기준 R, G, B 구역별 bfs 탐색
	2. 색약인 기준 RG, B 구역별 bfs 탐색 (G를 R로 바꿔서 탐색)
	3. 각각의 구역의 개수를 출력
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const N = Number(input.shift());
	const dr = [-1, 1, 0, 0];
	const dc = [0, 0, -1, 1];
	const map = input.map((row) => row.split(""));
	let cnt1 = 0, cnt2 = 0;

	const map2 = map.map((row) => row.slice());

	const bfs = (map, r, c, color) => {
		const que = [[r, c]];
		map[r][c] = "X";

		while (que.length) {
			const [r, c] = que.shift();

			for (let i = 0; i < 4; i++) {
				const nr = r + dr[i];
				const nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] === color) {
					que.push([nr, nc]);
					map[nr][nc] = "X";
				}
			}
		}
	};

	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			if (map[i][j] !== "X") {
				bfs(map, i, j, map[i][j]);
				cnt1++;
			}
		}
	}

	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			if (map2[i][j] === "G") map2[i][j] = "R";
		}
	}

	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			if (map2[i][j] !== "X") {
				bfs(map2, i, j, map2[i][j]);
				cnt2++;
			}
		}
	}

	print(cnt1, cnt2);
};

solution(input);
