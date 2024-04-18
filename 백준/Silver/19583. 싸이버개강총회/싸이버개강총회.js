/*
  문제 요약: 채팅 기록을 보고 스트리밍을 잘 들은 사람의 수 출력하기

  1. 개총 시작 전에 채팅한 사람을 map에 넣고 (key: user, value: false)
	2. 개총 종료 후에 채팅한 사람의 value를 true로 바꾼다.
	3. true인 사람을 세서 출력하기
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	let map = new Map();
	let ans = 0;
	let [start, end, live] = input
		.shift()
		.split(" ")
		.map((e) => Number(e.replace(":", "")));
	for (let i = 0; i < input.length; i++) {
		let [time, user] = input[i].split(" ");
		time = Number(time.replace(":", ""));
		if (time <= start) {
			map.set(user, false);
		}

		if (time >= end && time <= live && map.has(user)) {
			map.set(user, true);
		}
	}
	for (let bool of map.values()) {
		if (bool) ans++;
	}
	print(ans);
};

solution(input);
