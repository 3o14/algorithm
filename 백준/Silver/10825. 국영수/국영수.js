/*
	국영수
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	input.shift();
	let students = input.map((v) => v.split(" "));
	students.sort()
	students.sort((a, b) => {
		if (a[1] === b[1]) {
			if (a[2] === b[2]) {
				return b[3] - a[3];
			}
			return a[2] - b[2];
		}
		return b[1] - a[1];
	});

	print(students.map((e) => e[0]).join("\n"));
};

solution(input);
