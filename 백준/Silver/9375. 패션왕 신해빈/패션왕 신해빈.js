/*
  문제 요약: 옷의 조합의 수 출력하기.

  1. 옷 종류별로 해시에 담고 (초기값=1)
	2. 곱해서 조합의 값을 낸다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const N = input.shift();
	for (let tc = 0; tc < N; tc++) {
		const M = input.shift();
		let map = {};
		let ans = 1;

		for (let i = 0; i < M; i++) {
			const [item, type] = input.shift().split(" ");
			map[type] = (map[type] || 1) + 1;
		}

		for (let type in map) {
			ans *= map[type];
		}

		print(ans - 1);
	}
};

solution(input);
