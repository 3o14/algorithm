/*
	좌표 정렬하기
	x축 기준 먼저 정렬 후, y축 기준 정렬하기
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = input.shift();
	const arr = []
	for(let i=0; i<n; i++) {
		arr.push(input[i].split(" ").map(Number));
	}
	arr.sort((a, b) => {
		if(a[0] === b[0]) {
			return a[1] - b[1];
		}
		return a[0] - b[0]
	})

	print(arr.map(e => e.join(" ")).join("\n"))
};

solution(input);
