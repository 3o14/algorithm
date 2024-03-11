function solution(elements) {
    let ans = new Set()
    elements.push(...elements) // 주어진 수열을 2번 반복한 배열로 만든
    for(let i=1; i<=elements.length/2; i++) { // 1부터 N길이만큼의 부분 수열을 반복
        for(let j=0; j<elements.length; j++) { // 전체 수열을 순회할 반복문
            if(j >= elements.length/2) break
            ans.add(elements.slice(j, j+i).reduce((a, b) => a+b))
        }
    }
    
    return ans.size
}