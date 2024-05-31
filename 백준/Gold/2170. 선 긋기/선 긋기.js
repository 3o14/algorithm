/*
	선긋기
	문제 요약: 겹치는 부분을 제외하고 선의 총 길이를 구하는 문제

	1. 주어진 선들을 x 축을 기준으로 정렬한다.
	2. 현재 선의 x를 curX로 저장해둔다.
	3. 현재 선의 y가 다음 선의 x보다 크다면 겹치는 부분이 있으므로 curY를 다음 선의 y로 갱신한다.
	4. 현재 선의 y가 다음 선의 x보다 작다면 겹치는 부분이 없으므로 curX와 curY의 길이를 ans에 더해준다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = +input.shift();
	input = input
		.map((e) => e.split(" ").map(Number))
		.sort((a, b) => a[0] - b[0]);
	let ans = 0;
	let curX = input[0][0];
	let curY = input[0][1];

	for (let i = 1; i < n; i++) {
		if (curY >= input[i][0]) {
			curY = Math.max(curY, input[i][1]);
		}
		if (curY < input[i][0]) {
			ans += curY - curX;
			curX = input[i][0];
			curY = input[i][1];
		}
	}

	print(ans + curY - curX)
};

solution(input);
