
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
function solution(keymap, targets) {
    let answer = Array.from({length : targets.length}, ()=> 0);

    targets.forEach((target, index)=>{
       for(let i = 0; i<target.length; i++){
           let min = Number.MAX_SAFE_INTEGER;
           keymap.forEach((kv, ki) => {
               let k = kv.indexOf(target[i]);
               if(k !== -1) min = Math.min(k + 1, min);
           })
           if(min === Number.MAX_SAFE_INTEGER) {
               answer[index] = -1;
               break;
           }
           else answer[index] += min; 
       }
    })

    return answer;
}
