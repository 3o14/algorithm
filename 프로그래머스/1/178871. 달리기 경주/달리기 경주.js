function solution(players, callings) {
    const hash = new Map();
    
    for(let i=0; i<players.length; i++) {
        hash.set(players[i], i);
    }
    
    for(let i=0; i<callings.length; i++) {
        const name = callings[i];
        const curIdx = hash.get(name);
        const front = players[curIdx-1];
        
        [players[curIdx], players[curIdx-1]] = [front, players[curIdx]];
        
        hash.set(name, hash.get(name)-1);
        hash.set(front, hash.get(name)+1);
    }
    
    return players;
}