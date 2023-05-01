function solution(name, yearning, photo) {
    var answer = [];
    let sum = 0;
    
    photo.map(arr => {
        sum = 0;
        arr.map(arrName => {
            name.includes(arrName) ? sum += yearning[name.indexOf(arrName)] : null
        })
        answer.push(sum);
    })
    return answer;
}