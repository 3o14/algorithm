/*
  문제 요약: 모눈종이에 직사각형 몇개를 그렸을 때 남는 영역의 개수와 크기를 각각 출력하기

    1. 직사각형 부분을 1로 채운다.
	2. 다시 그래프 전체를 돌다가 0을 만나면 bfs를 돌면서 0인 영역의 개수와 그 넓이를 구한다.
*/

const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input, ans = []) => {
	const [N, M, TC] = input.shift().split(" ").map(Number);
	const dr = [0, 1, -1, 0],
		dc = [1, 0, 0, -1];

	const map = Array.from(Array(N), () => Array(M).fill(0));

	for (let i = 0; i < TC; i++) {
		const [sc, sr, ec, er] = input[i].split(" ").map(Number);

		for (let r = sr; r < er; r++) {
			for (let c = sc; c < ec; c++) {
				map[r][c] = 1;
			}
		}
	}

	let cnt = 0;
	for (let i = 0; i < N; i++) {
		for (let j = 0; j < M; j++) {
			if (map[i][j] == 0) {
				let sum = 1;
				cnt += 1;
				let que2 = [[i, j]];
				map[i][j] = 5;

				while (que2.length > 0) {
					let [r, c] = que2.shift();

					for (let k = 0; k < 4; k++) {
						let nr = r + dr[k];
						let nc = c + dc[k];

						if (nr < N && nr >= 0 && nc < M && nc >= 0 && map[nr][nc] == 0) {
							que2.push([nr, nc]);
							sum += 1;
							map[nr][nc] = 5;
						}
					}
				}
				ans.push(sum);
			}
		}
	}

	print(cnt);
    print(ans.sort((a, b) => a - b).join(' '));
};

solution(input);
