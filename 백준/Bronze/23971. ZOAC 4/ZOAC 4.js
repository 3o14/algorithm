const input = require("fs").readFileSync("/dev/stdin").toString().split(" ")

const H = +input[0]
const W = +input[1]
const N = +input[2]
const M = +input[3]

let cnt = 0
for(let i=0; i<H; i += N+1) {
  for(let j=0; j<W; j += M+1) {
    cnt += 1
  }
}

console.log(cnt)