function solution(n, words) {
    let people = new Array(n).fill(0) // 사람들의 차례를 저장할 배열
    let arr = [] // 말한 단어들 저장할 배열
    
    for(const idx in words) {
        const word = words[idx]
        // 이미 있는 단어를 말할 경우
        if(arr.includes(word)) {
            return [idx%n+1, people[idx%n]+1]
        }
        
        // 틀린 단어를 말한 경우 (이전 단어와 연결되지 않는 단어)
        const prev = arr[arr.length-1]
        if(prev && prev[prev.length-1] !== word[0]) {
            return [idx%n+1, people[idx%n]+1] 
        }
        
        // 잘 말한 단어는 arr 배열에 저장하고 차례를 업데이트 해줌
        arr.push(word)
        people[idx%n] += 1
    }
    
    // 탈락자가 없을 경우 [0, 0] 반환
    return [0, 0]
}