function solution(participant, completion) {
    // 해시맵 생성 (key: 이름, value: 이름 수)
    let map = new Map()
    
    // 마라톤 선수들 정보 입력
    participant.forEach(e => {
        // 같은 이름이 이미 있으면 기존 값에 +1 해준다.
        if(map.has(e)) map.set(e, map.get(e)+1)
        else map.set(e, 1)
    })
    
    // 완주한 선수는 -1
    completion.forEach(e => {
        map.set(e, map.get(e)-1)
    })
    
    // value가 1인 사람이 완주하지 못한 선수이므로 반환한다.
    for(const [key, value] of map) {
        if(value){
            return key
        }
    }
}