// info Map를 생성한다. (key: 친구이름, value: 친구의 인덱스)
// -1로 채운 friends 길이의 2차원 배열 map을 만든다.
// gifts를 돌면서 선물을 주고받은 정보를 map에 넣는다. (이때 info 객체 이용)
// 이제 map을 돌면서 준 선물([i][j]), 받은 선물([j][i])의 개수를 확인하고 이름 배열에 담는다.
function solution(friends, gifts) {
    let info = new Map()
    let names = new Array(friends.length).fill(0)
    let gPercent = new Array(friends.length).fill(0)
    
    friends.forEach((e, i) => {
        info.set(e, i)
    })
    
    let map = Array.from(new Array(friends.length), () => new Array(friends.length).fill(0))
    
    gifts.forEach((e) => {
        let [giveOne, getOne] = e.split(' ')
        map[info.get(giveOne)][info.get(getOne)] += 1    
    })
     
    // 선물지수 구하기 -> 더 깔끔하게 하고싶다
    for(let i=0; i<friends.length; i++) {
        let giveSum = 0
        for(let j=0; j<friends.length; j++) {
            giveSum += map[i][j]   
        }
        gPercent[i] = giveSum
    }
    
    for(let j=0; j<friends.length; j++) {
        let giveSum = 0
        for(let i=0; i<friends.length; i++) {
            giveSum += map[i][j]   
        }
        gPercent[j] -= giveSum
    }

    for(let i=0; i<friends.length; i++) {
        for(let j=0; j<friends.length; j++) {
            if(i === j) continue
            if(map[i][j] === -1) continue
            const result = map[i][j] - map[j][i]
            map[i][j] = -1
            map[j][i] = -1
            if(result > 0) names[i] += 1
            if(result < 0) names[j] += 1
            if(result === 0) {
                if(gPercent[i] === gPercent[j]) continue
                gPercent[i] > gPercent[j] ? names[i] += 1 : names[j] += 1
            }
        }
    }
    
    return Math.max(...names)
}