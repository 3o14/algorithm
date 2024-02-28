function solution(sizes) {
    const w = [];
    const h = [];
    
    sizes.forEach((card => {
        if(card[0] > card[1]) {
            w.push(card[0]);
            h.push(card[1]);
        } else {
            w.push(card[1]);
            h.push(card[0]);
        }
    }))
    
    w.sort((a, b) => a - b);
    h.sort((a, b) => a - b);
    
    return w[w.length-1]*h[h.length-1];
}