function solution(id_list, report, k) {
    // answer를 id_list.length만큼 fill 0
    // key: id, value: {Set(신고한 id), 자신이 신고당한 count}
    // k이상의 신고된 id를 has 일 경우 answer.indexOf(key)++
    let answer = new Array(id_list.length).fill(0);
    let name = new Array(id_list.length).fill(0);
    let obj = {};
    id_list.forEach((e) => {
        obj[e] = new Set();
    })
    
    report.map((info) => {
        info = info.split(" ");
        obj[info[0]].add(info[1]);
    })
    
    id_list.map(e => {
        for (i in id_list) {
            obj[e].has(id_list[i]) && name[i]++;
        }
    })
    
    for(idx in id_list) {
        if(name[idx] >= k) { // idx : 2번 이상 신고당한 유저의 인덱스
            for (j in id_list) { // 그 유저를 신고한 유저 찾기
                obj[id_list[j]].has(id_list[idx]) && answer[j]++;
            }
        }
    }
    
    // map과 forEach의 차이는 뭐지?
    return answer;
}