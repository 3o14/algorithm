function solution(number, limit, power, ans = 0) {
    let arr = [];
    while(number > 0) {
        let index = 0;
        let cnt = 0;
        for(let i=1; i <= number/2; i++) {
            (number % i) === 0 ? cnt++ : null
        }
        arr.push(cnt+1);
        number--;
    }
    
    return arr
    .map((n) => {
      return n > limit ? power : n;
    })
    .reduce((acc, cur) => acc + cur, 0);
}