/*
  문제 요약: 회사 입출입 로그를 보고 남아있는 사람 출력하기

  1. map에 data 다 넣기
	2. true인 사람 이름 출력하기
	3. 역순 정렬
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input, ans = []) => {
	let N = input.shift();
	let map = new Map();

	for (let i = 0; i < N; i++) {
		const [name, status] = input[i].split(" ");

		map.set(name, status);
	}

	for (let [user, status] of map) {
		if (status === "enter") {
			ans.push(user);
		}
	}

	print(ans.sort().reverse().join("\n"));
};

solution(input);
