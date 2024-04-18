/*
  문제 요약: 주어진 문자열의 길이별 부분 문자열의 개수 출력하기

  1. 2중 포문으로 구현
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim();

const print = console.log;

const solution = (input) => {
	let ans = [];

	for (let i = 1; i <= input.length; i++) {
		for (let j = 0; j < input.length; j++) {
			let str = input.slice(j, j + i);
			if (str.length === i) {
				ans.push(str);
			}
		}
	}
	let set = new Set(ans)
	print(set.size);
};

solution(input);
