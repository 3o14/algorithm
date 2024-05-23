/*
  접미사 배열
*/

const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const print = console.log;

const solution = (input) => {
	const str = input[0]
	let arr = []
	for(let i=0; i<str.length; i++) {
		arr.push(str.split("").splice(i, str.length).join(""))
	}
	print(arr.sort().join("\n"))
};

solution(input);
