/*
    문제 요약: 주어진 단어의 사전에서의 순서를 출력하기
    
    N의 최대값이 (n*n*n*n*) + (n*n*n*n) + (n*n*n) + (n*n) + (n) 이고
    여기서 N은 5, 결국 최대값이 4천 이하이기 때문에 완전 탐색으로 풀어도 시간 초과가 나지 않는다.
    
    모든 가능한 문자를 배열에 넣고 정렬시킨 후 인덱스를 반환한다.
*/

function solution(word) {
    const words = [..."AEIOU"]
    let ans = []
    let w = ''
    
    const dfs = (w, len, ans) => {
        if(w.length === len) {
            return ans.push(w)
        }
        
        words.forEach((word) => dfs(w+word, len, ans))
    }
    
    for(let i in words) {
        dfs(w, Number(i)+1, ans)
    }
    
    return ans.sort().indexOf(word)+1
}