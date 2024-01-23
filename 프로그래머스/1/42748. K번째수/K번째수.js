function solution(array, commands) {
    var answer = [];
    for(let i=0; i<commands.length; i++) {
        const start = commands[i][0]-1;
        const end = commands[i][1];
        const k = commands[i][2]-1;
        
        let arr = array.slice(start, end);
        arr.sort((a, b) => a - b);
        answer.push(arr[k]);
    }
    return answer;
}