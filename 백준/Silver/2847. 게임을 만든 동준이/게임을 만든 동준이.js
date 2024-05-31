/*
	게임을 만든 동준이
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = input.shift()
	let ans = 0
	input = input.map(Number)
	input.reverse()
	
	let cur = input[0]
	for(let i=1; i<n; i++) {
		if(cur <= input[i]) {
			ans += input[i] - cur + 1
			input[i] = cur - 1
		}
		cur = input[i]
	}
	print(ans)
};

solution(input);
