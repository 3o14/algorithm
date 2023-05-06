function solution(numbers, hand) {
    let answer = '';
    const leftside = [1, 4, 7];
    const rightside = [3, 6, 9];
    const mid = [2, 5, 8, 0];
    
    let L_finger = "*"; 
    let R_finger = "#";
    
    const pos = {
        '1': [0, 0],
        '2': [0, 1],
        '3': [0, 2],
        '4': [1, 0],
        '5': [1, 1],
        '6': [1, 2],
        '7': [2, 0],
        '8': [2, 1],
        '9': [2, 2],
        '*': [3, 0],
        '0': [3, 1],
        '#': [3, 2],
    }
    
    const mid_distance = (L_finger, R_finger, target_num) => {
        let left_distance = Math.abs(pos[L_finger][0] - pos[target_num][0]) + Math.abs(pos[L_finger][1] - pos[target_num][1]);
        let right_distance = Math.abs(pos[R_finger][0] - pos[target_num][0]) + Math.abs(pos[R_finger][1] - pos[target_num][1]);
        
       if(left_distance === right_distance) {
           return hand === "right" ? "R" : "L";
       } else {
        return left_distance > right_distance ? "R" : "L";
       }
    }
    
    for(let i = 0; i < numbers.length; i++) {
        // console.log(L_finger, R_finger, numbers[i]);
        if(leftside.includes(numbers[i])){
            answer += "L";
            L_finger = numbers[i];
        }else if(rightside.includes(numbers[i])){
            answer += "R";
            R_finger = numbers[i];
        }else {
            answer += mid_distance(L_finger, R_finger, numbers[i]);
            answer.slice(-1) === "L" ? L_finger = numbers[i] : R_finger = numbers[i];
        }
    }
    return answer;
}