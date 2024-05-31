/*
	보물
	문제 요약: 두 정수 배열 A, B가 있을 때 A의 정렬만 마음대로 바꾸어서 각 요소를 곱한 값의 합이 최소가 되도록

	1. B를 정렬시킨다.
	2. A를 역정렬시킨다.
	3. A와 B의 각 요소를 곱한 값을 더한다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const n = +input.shift();
	let ans = 0

	const arrA = input[0].split(" ").map(Number);
	const arrB = input[1].split(" ").map(Number);

	arrB.sort((a, b) => a - b);
	arrA.sort((a, b) => b - a);
	
	for(let i=0; i<n; i++) {
		ans += arrA[i] * arrB[i];
	}

	print(ans)
};

solution(input);
