function solution(n, m, ans=[]) {
    ans.push(max(n, m));
    ans.push(min(n, m));
    return ans;
}

// 최대공약수 2부터 Math.min(n, m)까지 둘다 나누어 떨어지는 가장 큰 수
const max = (n, m, num=1) => {
    for(let i=2; i<=Math.min(n, m); i++) {
        if(n%i === 0 && m%i === 0) {
            num = i;
        }
    }
    return num;
}

// 최소공배수 1부터 둘다에 나누어 떨어지는 가장 작은 수
const min = (n, m, num=1) => {
    while(true) {
        if(num%n === 0 && num%m === 0) break;
        num++;
    }
    return num;
}