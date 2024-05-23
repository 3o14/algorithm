/*
	빈도 정렬
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const [n, c] = input.shift().split(" ").map(Number);
	let arr = input[0].split(" ").map(Number);
	let ans = []
	let map = new Map();
	arr.forEach((e) => {
		map.set(e, (map.get(e) || 0) + 1);
	});
	arr = [...map].sort((a, b) => b[1] - a[1]);
	arr.forEach((e) => {
		for(let i=0; i<e[1]; i++) {
			ans.push(e[0]);
		}
	})
	print(ans.join(" "));
};

solution(input);
