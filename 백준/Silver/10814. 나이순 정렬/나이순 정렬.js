/*
	나이순 정렬
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = input.shift();
	for(let i=0; i<n; i++) {
		input[i] = input[i].split(" ")
	}
	input.sort((a, b) => a[0] - b[0])
	print(input.map((el) => el.join(" ")).join("\n"));
};

solution(input);
