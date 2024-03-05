function solution(participant, completion) {
    let map = new Map()
    participant = participant.sort()
    completion = completion.sort()
    
    participant.forEach((e, i) => {
        map.set(i, e)
    })
    
    for(const e of map) {
        if(e[1] !== completion[e[0]]) {
            return e[1]
        }
    }
}