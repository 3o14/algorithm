/*
    문제 요약: 0~1000까지 숫자가 담긴 배열을 받아서, 가장 큰 숫자가 되도록 붙이기
    
    sort를 할 때 앞뒤로 숫자를 붙여본 상태에서 크기를 비교하여 우선순위 결정하기
*/
function solution(numbers) {
    numbers = numbers.map((num) => String(num)).sort((a, b) => (b+a) - (a+b)).join('')
    
    return numbers[0] === "0" ? "0" : numbers
}
