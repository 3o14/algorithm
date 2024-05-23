/*
	단어 정렬
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	input.shift();
	input.sort();
	const set = new Set(input);
	input = [...set];
	input.sort((a, b) => a.length - b.length);
	print(input.join("\n"))
};

solution(input);
