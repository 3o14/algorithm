/*
	시리얼 번호
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = input.shift();
    input.sort();
	input.sort((a, b) => {
		if (a.length !== b.length) {
			return a.length - b.length;
		}
		let aSum = a.split("").filter(e => !isNaN(e)).reduce((acc, cur) => acc + +cur, 0);
		let bSum = b.split("").filter(e => !isNaN(e)).reduce((acc, cur) => acc + +cur, 0);

		if (aSum !== bSum) {
			return aSum - bSum;
		}
	})

	print(input.join("\n"));
};

solution(input);
