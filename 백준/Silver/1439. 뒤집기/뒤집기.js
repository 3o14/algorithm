/*
	뒤집기
	문제 요약: 0과 1로 이루어진 문자열을 모두 같은 문자로 만들려고 할때 최소로 뒤집는 횟수를 구하는 문제

	1. 각 문자열을 0과 1로 나누어서 그룹을 나눈다.
	2. 0그룹의 개수와 1그룹의 개수를 각각 구해서 map에 저장한다.
	3. 그룹이 하나 이하일 경우에는 0을 출력하고, 그 이상일 경우에는 map의 value값 중 최소값을 출력한다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()

const print = console.log;

const solution = (input) => {
	input = input.split('').map(Number);
	let prev = input[0]
	let map = new Map();

	map.set(prev, 1)

	for(let i=1; i<input.length; i++) {
		if(prev !== input[i]) {
			map.set(input[i], map.get(input[i]) + 1 || 1)
			prev = input[i]
		}
	}

	print(map.size === 1 ? 0 : Math.min(...map.values()))
};

solution(input);
