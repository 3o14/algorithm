function solution(arr1, arr2) {
    var answer = arr1;
    arr1.forEach((arr, i) => {
        arr.forEach((e, j) => {
            answer[i][j] = e + arr2[i][j];
        })
    })
    return answer;
}