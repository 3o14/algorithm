const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(filePath)
	.toString()
	.trim()
	.split("\n");

const print = console.log;

/*
	트리 순회

	인접리스트로 각 노드의 왼쪽 자식과 오른쪽 자식 정보를 입력하고
	각각 전위, 중위, 후위 순회를 수행한 결과를 출력한다.
*/

const solution = (input) => {
	const n = +input.shift();
	const graph = new Map();
	const ans = Array.from(new Array(3), () => "");

	for (let i = 0; i < n; i++) {
		const [node, left, right] = input[i].split(" ");
		graph.set(node, [left, right]);
	}

	const preOrder = (node) => {
		if (node === ".") return;
		const [left, right] = graph.get(node);

		ans[0] += node;
		preOrder(left);
		preOrder(right);
	};

	const inOrder = (node) => {
		if (node === ".") return;
		const [left, right] = graph.get(node);

		inOrder(left);
		ans[1] += node;
		inOrder(right);
	};

	const postOrder = (node) => {
		if (node === ".") return;
		const [left, right] = graph.get(node);

		postOrder(left);
		postOrder(right);
		ans[2] += node;
	};

	preOrder("A");
	inOrder("A");
	postOrder("A");

	print(ans.join("\n"));
};

solution(input);
