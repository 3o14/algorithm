function solution(n) {
    const cnt = n.toString(2).split('').filter(e => e === '1').length // n의 1의 개수
    while(true) {
        n += 1
        if(n.toString(2).split('').filter(e => e === '1').length === cnt) {
            return n
        }
    }
}
