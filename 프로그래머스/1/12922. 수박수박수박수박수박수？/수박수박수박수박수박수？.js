function solution(n) {
    if(n === 1) {
        return "수";
    } else if (n >= 2) {
        let word = "";
        let num = Math.floor(n/2);
        for(let i=0; i<num; i++) {
            word += "수박";
        }
        if(n%2 === 0) {
            return word;
        } else {
            return word + "수";
        }
    }
}