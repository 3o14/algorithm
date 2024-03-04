// 1. 각 모서리를 빼고 (-4)
// 2. 윗변과 왼쪽변의 길이합을 구해서 (/2)
// 3. 합이 위의값이 나오는 길이 2의 조합을 구한다. (예: 값이 3이면 [1, 2], [2, 1])
// 4. 나온 조합을 전부 탐색해보고 yellow가 개수에 맞게 들어가는지 확인한다.

// yellow의 경우의 수 구하기
// 1. yellow/n이 0으로 나누어 떨어지는 수를 x라고 하자
// 2. 1부터 yellow까지 x의 몫을 곱한다.
// 3. 그 곱 조합이 yellow 부분의 크기가 된다.
// 4. 이 크기가 brown의 조합과 맞는게 있다면 각 가로 세로에 2씩 더해서 반환한다.
function solution(brown, yellow) {
     const num = (brown-4)/2
     let set = []
     
     let i=1;
     while(i < num) {
         set.push([i, num-i])
         i += 1
     }
    
    let j=1
    if(yellow === 1) return [3, 3]
    while(j < yellow) {
        if(yellow%j === 0) {
            console.log([j, yellow/j])
            for(const e of set) {
                // console.log(e, [j, yellow/j], e.toString() === [j, yellow/j].toString())
                if(e.toString() === [j, yellow/j].toString()) {
                    let arr = [j, yellow/j]
                    arr = arr.sort((a, b) => b-a)
                    return [arr[0]+2, arr[1]+2]
                }
            }
            // set.indexOf[j, yellow/j]
        }
        j += 1
    }
}