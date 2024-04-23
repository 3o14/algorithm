/*
  문제 요약: 장마철에 내리는 비의 양에 따라서 물에 잠기지 않는 안전한 영역의 개수의 최대값 출력하기
  즉, min부터 max값까지 전부 비를 내려봤을때 안전한 영역의 최대값을 구하기

	1. 그래프를 한번 순회해서 min값과 max값을 구한다.
	2. min~max값 이상인 값 조건으로 bfs를 돌리고 몇 개의 영역이 나오는지 구한다.
	3. ans를 최댓값으로 갱신하면서 2번 반복.
	4. ans 출력
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input, ans = 0) => {
	const N = +input.shift();
	let min = Number.MAX_VALUE;
	let max = Number.MIN_VALUE;

	const map = input.map((e) => e.split(" ").map(Number));

	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			const value = map[i][j];
			max = value > max ? value : max;
			min = value < min ? value : min;
		}
	}

	const dr = [0, 0, 1, -1];
	const dc = [1, -1, 0, 0];

	const bfs = (r, c, map, rain) => {
		const que = [[r, c]];

		while (que.length > 0) {
			const [r, c] = que.pop();

			for (let d = 0; d < 4; d++) {
				const nr = r + dr[d];
				const nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > rain) {
					que.push([nr, nc]);
					map[nr][nc] = 0
				}
			}
		}
	};

	for (let rain = min-1; rain <= max; rain++) {
		let cnt = 0;
		let copy = JSON.parse(JSON.stringify(map))
		for (let i = 0; i < N; i++) {
			for (let j = 0; j < N; j++) {
				if (copy[i][j] > rain) {
					bfs(i, j, copy, rain);
					cnt++;
				}
			}
		}
		ans = Math.max(cnt, ans)
	}

	print(ans)
};

solution(input);
