function solution(s, n) {
    const UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const LOWER = "abcdefghijklmnopqrstuvwxyz";
    
    return [...s].map(e => {
        if(e !== " ") {
            if(e.toUpperCase() === e) {
                return UPPER[(UPPER.indexOf(e)+n)%26];
            } else {
                return LOWER[(LOWER.indexOf(e)+n)%26];
            }
        } else return e;
    }).join("");
}