const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const [n, ...testcases] = input;
for (let i = 0; i < n; i++) {
  let count = 1;
  let target = Number(testcases[i * 2].split(' ')[1])
  let queue = testcases[i * 2 + 1].split(' ').map(Number);

  while (true) {
    const num = queue.shift();
    if (Math.max(...queue) <= num && target === 0) {
      console.log(count);
      break;
    } else if (Math.max(...queue) > num && target === 0) {
      queue.push(num);
      target = queue.length - 1;
    } else if (Math.max(...queue) > num) {
      queue.push(num);
      target -= 1;
    } else if (Math.max(...queue) <= num) {
      count += 1;
      target -= 1;
    }
  }
}