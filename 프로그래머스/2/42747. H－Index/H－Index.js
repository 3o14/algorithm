/*
    문제 요약: 숫자가 담긴 배열이 주어질 때, h이상의 수가 h개 이상이고 나머지는 h개 이하의 수인 h를 출력하기
    
    내림차순 정렬 후
    하나씩 비교하면서 h=0부터 1씩 키워간다.
    현재 인덱스가 해당 요소보다 작거나 같아지는 순간 h 반환
    // 인덱스: 0 1 2 3 4
    // 인용수: 6 5 3 1 0
*/

function solution(papers, h=0) {
    papers.sort((a, b) => b - a)
    
    for(let i in papers) {
        if(papers[i] > i) h += 1
        else break
    }
    
    return h
}