const fs = require("fs");
const array = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = array.shift();

const result = [];
const stack = [];

for (let i = 0; i < N; i++) {
  switch (array[i]) {
    case "pop":
      result.push(stack.pop() || -1);
      break;
    case "size":
      result.push(stack.length);
      break;
    case "empty":
      result.push(stack[0] ? 0 : 1);
      break;
    case "top":
      result.push(stack[stack.length - 1] || -1);
      break;

    default:
      stack.push(array[i].split(" ")[1]);
      break;
  }
}

console.log(result.join("\n"));
