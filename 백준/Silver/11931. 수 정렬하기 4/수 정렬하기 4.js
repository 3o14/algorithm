/*
	수 정렬하기4
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	input.shift();
	input = input.sort((a, b) => b - a).join("\n")
	print(input)
};

solution(input);
