// 1. 해시 테이블 생성
// 2. 참가자 이름 세기 key(이름) value 1 (동명이인이 있으면 value +1)
// 3. 완주자 이름 세기 key(이름) value 1 (동명이인이 있으면 value -1)
// 4. value 1만 출력 (완주하였으면 value 0 완주하지 못하였으면 value 1)

function solution(participant, completion) {
    let answer;
    // 1)
    let hashMap = new Map()

    // 2)
    participant.forEach(e => {
        if(hashMap.has(e)) {
            hashMap.set(e, hashMap.get(e)+1)  // Map(3) { 'mislav' => 2, 'stanko' => 1, 'ana' => 1 }

        } else {
            hashMap.set(e, 1)    
        }
    })

    // 3)
    completion.forEach(e => {
        if(hashMap.has(e)) {
            hashMap.set(e, hashMap.get(e)-1) // Map(3) { 'mislav' => 1, 'stanko' => 0, 'ana' => 0 }
        }
    })


    // 4)
    for(let [key, value] of hashMap) {
        if(value == 1) {
            answer = key
        }
    }

    return answer;
}