/*
	먹을 것인가 먹힐 것인가
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	let idx = 0;
	const T = +input[idx++];
	for (let tc = 0; tc < T; tc++) {
		idx++;
		let arrA = input[idx++].split(" ").map(Number);
		let arrB = input[idx++].split(" ").map(Number);
		let count = 0;
		arrA.sort((a, b) => b - a);
		arrB.sort((a, b) => b - a);
		for (let i = 0; i < arrA.length; i++) {
			for (let j = 0; j < arrB.length; j++) {
				if (arrA[i] > arrB[0]) {
					count += arrB.length;
					break;
				}
				if (arrA[i] > arrB[j]) {
					count++;
				}
			}
		}
		print(count);
	}
};

solution(input);
