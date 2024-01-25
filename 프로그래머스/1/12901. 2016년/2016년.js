function solution(a, b) {
    const month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    const week = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']

    let monthSum = month.slice(0, a).reduce((a, sum) => a + sum)
    monthSum = monthSum - month[a-1] + b - 1;
    return week[monthSum%7];
}