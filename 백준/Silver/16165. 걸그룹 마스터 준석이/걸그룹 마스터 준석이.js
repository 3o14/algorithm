/*
  문제 요약: 걸그룹 이름이나 그룹명을 입력받아 저장한 후 그룹명으로 멤버를 출력하거나 이름으로 그룹명을 출력하기

  1. 입력받은 값을 {key: 그룹명, value: 멤버[]} 로 해시에 저장한다.
  2. 퀴즈를 풀때 0이면 key를 기준으로 찾고
  3. 1이면 value를 기준으로 찾는다.
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	let map = new Map();
	const [N, M] = input.shift().split(" ");

	let idx = 0;
	for (let i = 0; i < N; i++) {
		let group = input[idx++];
		let cnt = Number(input[idx++]);
		map.set(group, input.slice(idx, idx + cnt));
		idx += cnt;
	}
	for (let i = 0; i < M; i++) {
		let quiz = input[idx++];
		let type = input[idx++];
		if (type == 0) {
			print(map.get(quiz).sort().join("\n"));
		}
		if (type == 1) {
			for (let [group, members] of map) {
				for (let member of members) {
					if (member == quiz) {
						print(group);
					}
				}
			}
		}
	}
};

solution(input);
