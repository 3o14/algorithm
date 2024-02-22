function solution(babbling, ans = 0) {
    const word = ['aya', 'ye', 'woo', 'ma']
    
    for(let i=0; i<babbling.length; i++) {
        for(let j=0; j<word.length; j++) {
            if(babbling[i].includes(word[j].repeat(2))) break
            babbling[i] = babbling[i].split(word[j]).join('!')
            
        }
    }
    
    babbling.forEach((e) => {
        if(e === '!'.repeat(e.length)) {
            ans += 1
        }
    })
    
    return ans
}

