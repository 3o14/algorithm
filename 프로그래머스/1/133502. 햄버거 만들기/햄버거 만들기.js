function solution(ingredient, ans=0) {
    for(let i=0; i<ingredient.length; i++) {
        // i부터 i+4번째가 햄버거이면 그 부분을 잘라내고 인덱스를 3만큼 되돌려주고 정답 개수를 1 더한다
        if(ingredient.slice(i, +i+4).toString() === [1, 2, 3, 1].toString()) {
            ingredient.splice(i, 4)
            i -= 3
            ans += 1
        }
    }
    
    return ans
}