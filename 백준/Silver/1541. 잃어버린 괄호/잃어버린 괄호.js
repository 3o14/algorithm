/*
	잃어버린 괄효
	문제 요약: 괄호를 적절히 쳐서 식의 값을 최소로 만들기

	1. -를 기준으로 나누어서 더한 값을 빼주면 된다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()

const print = console.log;

const solution = (input) => {
	input = input.split("-")
	for(let i=0; i<input.length; i++) {
		input[i] = input[i].split("+").reduce((acc, cur) => acc + parseInt(cur), 0);
	}
	let ans = input[0]
	for(let i=1; i<input.length; i++) {
		ans -= input[i];
	}

	print(ans)
};

solution(input);
