const solution = (d, budget) => {
    d.sort((a, b) => a - b);
    while(d.reduce((arr, cur) => arr+cur, 0) > budget) {
        d.pop();
    }
    
    return d.length;
}