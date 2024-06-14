const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	방 번호

	새 숫자세트가 필요해질 때마다 배열 추가
	인덱스가 숫자이고 값은 boolean으로 사용 여부를 표시한다.
*/

const solution = (input) => {
	const nums = input.shift().split("").map(Number);
	const arr = new Array(10).fill(false);
	const setOfNum = [arr];

	// 숫자 하나씩 탐색
	for (let num of nums) {

		// 세트별로 숫자 남아있나 보기
		for (let i = 0; i < setOfNum.length; i++) {
			// 그 세트에 숫자가 남아있으면 그거 쓰고 다음 숫자 탐색
			if (!setOfNum[i][num]) {
				setOfNum[i][num] = true;
				break;
			}

			// 숫자 다 없는데 그 숫자가 6이나 9이면 섞어서 사용하기
			if ((setOfNum[i][num] && num === 6) || num === 9) {
				num = num === 6 ? 9 : 6;
				if (!setOfNum[i][num]) {
					setOfNum[i][num] = true;
					break;
				}
			}

			// 모든 숫자 세트를 다 탐색했는데도 사용할 수 있는 숫자가 없을 때
			if (i === setOfNum.length - 1 && setOfNum[i][num]) {
				// 새 세트 추가
				setOfNum.push(new Array(10).fill(false));
			}
		}
	}

	print(setOfNum.length);
};

solution(input);
