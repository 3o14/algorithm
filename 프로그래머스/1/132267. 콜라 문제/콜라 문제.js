function solution(a, b, n, ans=0) {
    // 20/3 = 6 // 받은 콜라
    // 6 * 3 = 18 // 준 콜라
    // 20 % 3 = 2 // 남은 콜라
    // // 20 - 18 + 6 => 현재 콜라병 개수 n
    // 남은 콜라 + 받은 콜라
    // n % a + n / a
    let getCnt = 0;
    while(n >= a) {
        getCnt = parseInt(n/a)*b;
        ans += getCnt;
        n = (n%a) + getCnt;
    }
    return ans;
}