function solution(wallpaper) {
    let answer = [];
    // 가장 작은 좌표와 가장 큰 좌표 구하기
    
    let S = [wallpaper.length, wallpaper[0].length], E = [0, 0]; // min[i, j] max[i, j]

    for(let i = 0; i < wallpaper.length; i++) {
        for(let j = 0; j < wallpaper[i].length; j++) {
            if (wallpaper[i][j] === "#"){
                // i와 j가 S의 그것보다 작을 경우 갱신
                if(i < S[0])
                    S[0] = i;
                if(j < S[1])
                    S[1] = j;
                // i와 j가 E의 그것보다 클 경우 갱신
                if(i > E[0])
                    E[0] = i;
                if(j > E[1])
                    E[1] = j;
            }
        }
    }
    
    E = E.map(e => e+1);
    answer.push(...S, ...E);
    return answer;
}