/*
2차원 배열로 만들기
line = num / w
line에서 num이 있는 인덱스를 마지막 배열에서부터 탐색해서 몇개인지 출력
*/
function solution(n, w, num) {
    let answer;
    let arr1 = [];
    let round = 0;
    let index = -1;
    const line = Math.ceil(num / w)-1;
    for(let i=0; i< Math.ceil(n/w); i++) {
        const arr2 = [];
        for(let j=1; j<=w; j++) {
            const number = j + (round*w);
            if(number === num) {
                index = i%2 === 1 ? w-(j-1)-1 : j-1;
            }
            if (number > n) {
                arr2.push(0);
            } else arr2.push(number);
        }
        arr1.push(i%2 === 1 ? arr2.reverse() : arr2);
        round += 1;
    }
    answer = arr1.length - line;
    if(arr1[arr1.length-1][index] === 0) answer -= 1;

    return answer;
}