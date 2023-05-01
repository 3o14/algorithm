function solution(n, m, section) {
    var answer = 0;
    
    let list = [];
    for( let i= 0; i<n; i++)
        list.push(1);
    
    section.forEach(e => list.splice(e-1, 1, 0));
    
    for (idx in list) {
        if (list[idx] === 0) {
            list.splice(idx, m, 1);
            answer += 1;
        }
    }
    
    console.log(list)
    return answer;
}