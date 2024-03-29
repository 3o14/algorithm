function solution(n, arr1, arr2) {
    let arr = [];
    
    for(let i = 0; i<n; i++){
        arr.push((arr1[i] | arr2[i]).toString(2).padStart(n, 0));
    }
    
    arr = arr.map(e => e.replace(/1|0/g, num => +num ? '#' : ' '));
    
    return arr;
}