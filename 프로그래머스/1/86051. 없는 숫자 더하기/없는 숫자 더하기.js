function solution(numbers, sum=[], ans=0) {
    sum = Array.from({length: 10}, () => true);
    for(let i=0; i<numbers.length; i++) {
        sum[numbers[i]] = false;
    }
    for(let i=0; i<sum.length; i++) {
        ans += sum[i] ? i : 0;
    }
    return ans;
}