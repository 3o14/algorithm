const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	Strfry
	문제 요약: 각각 두 개의 문자열을 입력받고 두 개의 구성요소가 모두 같은지 확인하기
*/

const solution = (input) => {
	const n = +input.shift();

	const check = (str1, str2) => {
		const len = str1.length
		for (let a = 0; a < len; a++) {
			const word = str1.pop();
			let flag = false;
			for (let b = 0; b < str2.length; b++) {
				if (word === str2[b]) {
					flag = true;
					str2.splice(b, 1);
					break;
				}
			}
			if (!flag) return false;
		}

		return true;
	};

	for (let i = 0; i < n; i++) {
		let [str1, str2] = input[i].split(" ");

		str1 = str1.split("");
		str2 = str2.split("");

		if (str1.length !== str2.length) {
			print("Impossible");
			continue;
		}
		print(check(str1, str2) ? "Possible" : "Impossible");
	}
};

solution(input);
