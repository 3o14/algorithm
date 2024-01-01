function solution(left, right, sum=0) {
    for(let i=left; i<=right; i++) {
        if (calc(i)%2===0) {
            sum += i;
        } else {
            sum -= i;
        }
    }
    return sum;
}

const calc = (num) => {
    let result = [];
    let index = 1;
    
    while (index <= num) {
      if (num % index === 0) result.push(index)
      index++;
    }
    return result.length;
}