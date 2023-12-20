function solution(arr, divisor, ans = []) {
    ans = arr.filter(e => !(e%divisor));
    return ans.length ? ans.sort((a, b) => a - b) : [-1];
}