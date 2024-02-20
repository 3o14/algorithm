
const getCombi = (arr, cnt) => {
    let result = []
    if(cnt === 1) return arr.map((num) => [num])
    
    arr.forEach((fix, idx, origin) => {
        const rest = origin.slice(idx+1)
        const combi = getCombi(rest, cnt-1)
        const attached = combi.map((combis) => [fix, ...combis])
        
        result.push(...attached)
    })
    
    return result
}

const check = (num) => {
    for(let i=2;i<=Math.sqrt(num);i++){
        if(num % i === 0) return false
    }
    return true
}


function solution(nums, ans=0) {
    const combis = getCombi(nums, 3)
    combis.map((arr) => {
        const sum = arr.reduce((prev, sum) => prev+sum)
        if(check(sum)) ans++
    })
    
    return ans
}