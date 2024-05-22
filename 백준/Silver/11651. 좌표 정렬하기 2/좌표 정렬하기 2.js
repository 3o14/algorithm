/*
	좌표 정렬하기2
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = input.shift();
	input = input.map(e => e.split(" ").map(Number));
	input = input.sort((a, b) => {
		if(a[1] === b[1]) {
			return a[0] - b[0];
		}
		return a[1] - b[1]
	})

	print(input.map(e => e.join(" ")).join("\n"));
};

solution(input);
