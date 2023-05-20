function solution(n, arr1, arr2) {
    let answer = [];
    
    for(let i = 0; i < arr1.length; i++) {
        arr1[i] = arr1[i].toString(2).padStart(n, 0).split("");
        arr2[i] = arr2[i].toString(2).padStart(n, 0).split("");
    }
    
    for(let i = 0; i < arr1.length; i++){
        let arr = [];
        for(let j = 0; j < arr1[i].length; j++){
            if(arr1[i][j] === '1' || arr2[i][j] === '1'){
                arr.push("#");
            } else {
                arr.push(" ");
            }
        }
        answer[i] = arr.join("");
    }
    return answer;
}