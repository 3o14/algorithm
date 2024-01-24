function solution(k, score, ans=[]) {
    let meiyo = [];
    score.forEach((s, i) => {
        meiyo.push(s);
        meiyo.sort((a, b) => a-b);
        if(meiyo.length > k) {
           meiyo = meiyo.slice(meiyo.length-k, meiyo.length); 
        }
        ans.push(meiyo[0]);
    })
    return ans;
}