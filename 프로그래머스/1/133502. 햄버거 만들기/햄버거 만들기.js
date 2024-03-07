function solution(ingredient, ans=0) {
    for(let i=0; i<ingredient.length; i++) {
        if(ingredient.slice(i, +i+4).toString() === [1, 2, 3, 1].toString()) {
            ingredient.splice(i, 4)
            i -= 4
            ans += 1
        }
    }
    
    return ans
}