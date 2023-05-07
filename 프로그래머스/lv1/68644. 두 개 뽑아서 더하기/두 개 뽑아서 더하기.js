function solution(numbers) {
    var answer = [];
    for (let i in numbers) {
        for( let j in numbers) {
            if( i !== j) {
                // console.log(numbers[i], " + ", numbers[j]);
                answer.includes(numbers[i] + numbers[j]) ? null : answer.push(numbers[i] + numbers[j]);
            }
        }
    }
    
    answer.sort(function(a, b) {
        if(a > b) return 1;
        if(a === b) return 0;
        if(a < b) return -1;
    });
    return answer;
}