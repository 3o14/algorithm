function solution(arr) {
    var answer = 0;
    arr.forEach(i=>answer += i);
    return answer/arr.length;
}