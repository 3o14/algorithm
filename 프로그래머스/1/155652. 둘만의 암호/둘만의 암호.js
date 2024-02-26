function solution(s, skip, index, ans='') {
    let alphabet = 'abcdefghijklmnopqrstuvwxyz'
    // 중간 문자열을 자를때 성능면에서 어떤게 더 낫지?
    skip = [...skip].forEach(e => {
        alphabet = alphabet.replace(e, '')
    })
    alphabet = [...alphabet]
    s = [...s].forEach(e => {
        let idx = (alphabet.indexOf(e) + index) % alphabet.length
        ans += alphabet[idx]
    })
    
    return ans
}