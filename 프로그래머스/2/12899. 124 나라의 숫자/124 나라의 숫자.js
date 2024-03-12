function solution(n) {
    const nums = [4, 1, 2]
    let ans = ''
    while(n) {
        ans = nums[n%3] + ans
        n = n%3 === 0 ? n/3 - 1 : Math.floor(n/3)
    }
    return ans
}