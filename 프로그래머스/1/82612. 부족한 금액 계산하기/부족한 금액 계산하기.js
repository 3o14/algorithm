function solution(price, money, count) {
    const sum = calc(price, count);
    if(money < sum) {
        return sum - money;
    } else return 0;
}

const calc = (price, count, sum=0) => {
    while(count > 0) {
        sum += price*count--;
    }
    return sum;
}