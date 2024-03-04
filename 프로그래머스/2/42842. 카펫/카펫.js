function solution(brown, yellow) {
    // 1. 각 모서리를 빼고 (-4)
    // 2. 윗변과 왼쪽변의 길이합을 구해서 (/2)
    // 3. 합이 위의값이 나오는 길이 2의 조합을 구한다. (예: 값이 3이면 [1, 2], [2, 1])
     const num = (brown-4)/2
     let set = []
     
     let i=1;
     while(i < num) {
         set.push([i, num-i])
         i += 1
     }
    // 4. 나온 조합을 전부 탐색해보고 yellow가 개수에 맞게 들어가는지 확인한다.
    
    // yellow의 경우의 수 구해서 set의 원소와 같은 것을 찾는다.
    let j=1
    if(yellow === 1) return [3, 3] // yellow가 1인 경우는 3*3 한 가지 밖에 나올 수 없다.
    while(j < yellow) {
        // yellow가 될 수 있는 가로 세로 곱 조합을 구한다.
        if(yellow%j === 0) {
            for(const e of set) {
                if(e.toString() === [j, yellow/j].toString()) { // 같은 것을 찾을 경우
                    let arr = [j, yellow/j]
                    arr = arr.sort((a, b) => b-a) // 가로가 무조건 더 길게
                    return [arr[0]+2, arr[1]+2] // brown의 경우와 yellow의 경우가 같으면 값 반환
                }
            }
        }
        j += 1
    }
}