function solution(s, skip, index, ans='') {
    let alphabet = 'abcdefghijklmnopqrstuvwxyz'
    
    // 1. skip할 문자를 replace로 자른다
    skip = [...skip].forEach(e => {
        alphabet = alphabet.replace(e, '') // 중간 문자열을 자를때 성능면에서 어떤게 더 낫지?
    })
    
    // 2. skip이 제거된 알파벳 문자열을 배열로 만든다.
    alphabet = [...alphabet]
    
    // 3. s를 돌면서 index를 더한 값을 ans에 더한다.
    s = [...s].forEach(e => {
        let idx = (alphabet.indexOf(e) + index) % alphabet.length // 3.1 z를 넘었을 경우 a로 돌아오기
        ans += alphabet[idx]
    })
    
    // 4. 정답 반환
    return ans
}