function solution(num, x = 0) {
    
    if(num === 1) return 0;
    while(x++ <= 500) {
        if(num % 2 === 0) {
            num /= 2;
        } else if(num % 2 === 1) {
            num = num*3+1;
        }
        
        if(num === 1) return x;
    }
    return -1;
}