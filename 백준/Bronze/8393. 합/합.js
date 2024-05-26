const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = +input[0]
	let sum = 0;

	for(let i=1; i<=n; i++) {
		sum += i
	}

	print(sum)
};

solution(input);
