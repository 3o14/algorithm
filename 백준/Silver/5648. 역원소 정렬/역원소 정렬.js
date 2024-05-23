/*
	역원소 정렬
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	input = input
		.filter((e) => e !== "")
		.map((e) => e.split(" ").join(" "))
		.join(" ")
		.split(" ");
	const n = input.shift();
	for (let i = 0; i < n; i++) {
		input[i] = input[i].split("").reverse().join("");
	}
	print(
		input
			.map(Number)
			.sort((a, b) => a - b)
			.join("\n")
	);
};

solution(input);
