// 1. 이름: 인덱스 형식의 객체를 만든다.
// 2. 이름이 불린 값의 value-1의 value를 가진 값을 +1 해준다.
// 3. 이름이 불린 값의 value를 -1 해준다.
// 4. 위와 같은 방식으로 callings 배열 순회가 끝났다면 result 배열에 value값 순서대로 sorting하고 출력
function solution(players, callings) {
    const obj = {};
    
    for(let i=0; i<players.length; i++) {
        obj[players[i]] = i;
    }
    
    let prev, cur, name, idx;
    for(let i=0; i<callings.length; i++) {
        name = callings[i];
        idx = obj[name];
        
        prev = players[idx-1];
        cur = players[idx];
        
        obj[cur] -= 1;
        obj[prev] += 1;
        
        players[idx-1] = cur;
        players[idx] = prev;
    }
    
    return players;
}
