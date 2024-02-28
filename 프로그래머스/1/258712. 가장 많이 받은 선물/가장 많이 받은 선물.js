function solution(friends, gifts) {
    let info = new Map()    // 친구 이름으로 인덱스 번호를 얻기 위한 Map (key: 이름, value: 인덱스)
    let names = new Array(friends.length).fill(0)   // 다음 달에 받을 선물 개수를 담을 배열
    let gPercent = new Array(friends.length).fill(0)    // 선물 지수를 저장할 배열
    let map = Array.from(new Array(friends.length), () => new Array(friends.length).fill(0))
    
    // info Map에 정보 저장
    friends.forEach((e, i) => {
        info.set(e, i)
    })
    
    // 선물 주고받은 정보를 토대로 map에 저장과 동시에 선물 지수 측정
    gifts.forEach((e) => {
        let [giveOne, getOne] = e.split(' ')
        map[info.get(giveOne)][info.get(getOne)] += 1    
        gPercent[info.get(giveOne)] += 1
        gPercent[info.get(getOne)] -= 1
    })
      
    // 누가 더 많이 줬는지 names에 저장
    for(let i=0; i<friends.length; i++) {
        for(let j=0; j<friends.length; j++) {
            
            // 자기자신이거나 이미 확인한 경우 넘어감
            if(i === j) continue
            if(map[i][j] === -1) continue
            
            // 누가 더 많이 줬는지 result에 담기
            const result = map[i][j] - map[j][i]
            
            // 방문 체크
            map[i][j] = -1
            map[j][i] = -1
            
            // 더 많이 준 사람을 names 배열에 1 더함
            if(result > 0) names[i] += 1
            if(result < 0) names[j] += 1
            if(result === 0) { // 같을 경우 선물 지수에 따라 결정
                if(gPercent[i] === gPercent[j]) continue // 선물 지수도 같으면 그냥 넘어감
                gPercent[i] > gPercent[j] ? names[i] += 1 : names[j] += 1
            }
        }
    }
    
    // names 중 가장 큰 값 반환
    return Math.max(...names)
}