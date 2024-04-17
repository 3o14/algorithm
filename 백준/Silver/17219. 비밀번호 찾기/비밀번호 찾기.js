/*
  문제 요약: 사이트마다 비밀번호를 저장해뒀다가 특정 사이트의 비밀번호 출력하기

    1. 정보를 해시에 저장해두고
	2. key값으로 찾아낸다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const [N, M] = input.shift().split(" ");
	let map = new Map();
	for (let i = 0; i < N; i++) {
		const [site, pw] = input[i].split(" ");
		map.set(site, pw);
	}

	for (let j = N; j < Number(N) + Number(M); j++) {
		print(map.get(input[j]));
	}
};

solution(input);
