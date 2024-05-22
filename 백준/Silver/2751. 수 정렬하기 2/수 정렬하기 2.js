/*
	수 정렬하기 2
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = input.shift();
	print(input.map(Number).sort((a, b) => a - b).join("\n"))
};


solution(input);
