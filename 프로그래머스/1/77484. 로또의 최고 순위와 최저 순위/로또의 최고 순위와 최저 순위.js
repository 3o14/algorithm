const win = (n) => {
    switch(n) {
        case 6:
            return 1
        case 5:
            return 2
        case 4:
            return 3
        case 3:
            return 4
        case 2:
            return 5
        case 1:
            return 6
        default:
            return 6
    }
}

function solution(lottos, win_nums) {
    let zero = 0
    let sameNum = 0
    for(let i=0; i<lottos.length; i++) {
        if(lottos[i] === 0) {
            zero += 1
            continue
        }  
        for(let j=0; j<win_nums.length; j++) {
            if(lottos[i] === win_nums[j]) {
                sameNum += 1
            }
            
        }
    }
    
    return [win(sameNum), win(sameNum+zero)].sort((a, b) => a-b)
}