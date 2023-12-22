function solution(arr, min = Number.MAX_VALUE) {
    for(let i=0; i<arr.length; i++) {
        if(arr[i] < min) {
            min = arr[i];
        }
    }
    
    arr = arr.filter(e => e !== min);
    return arr.length ? arr : [-1];
}