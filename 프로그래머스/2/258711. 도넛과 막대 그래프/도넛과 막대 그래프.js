// Map 생성 (key: 노드 번호, value: [Out 간선 개수, In 간선 개수])
// edges의 정보를 map에 저장한다.
// map 정보를 토대로 각 그래프의 개수를 센다.
// 막대: Out이 0인 노드
// 8자: 중앙 노드가 out >= 2 in >= 2인 노드
// 도넛: 나머지
function solution(edges) {
    const graph = edges.reduce((map, edge) => {
        if(map.has(edge[0])) {
            const [outNum, inNum] = map.get(edge[0])
            map.set(edge[0], [outNum+1, inNum])
        } else {
            map.set(edge[0], [1, 0])
        }
        if(map.has(edge[1])) {
            const [outNum, inNum] = map.get(edge[1])
            map.set(edge[1], [outNum, inNum+1])
        } else {
            map.set(edge[1], [0, 1])
        }
        
        return map
    }, new Map())
    
    let ans = new Array(4).fill(0)
    for(let [node, edges] of graph) {
        const [out, get] = edges
        
        // 생성 노드
        if(out >= 2 && get == 0) {
            ans[0] = node
        }
        
        // 막대 그래프 개수
        if(out == 0) {
            ans[2] += 1
        }
        
        // 8자 그래프 개수
        if(out >= 2 && get >= 2) {
            ans[3] += 1
        }
    }
    
    // 도넛 = 생성 노드의 Out 간선 개수 - (막대 개수, 8자 개수)
    ans[1] = graph.get(ans[0])[0] - (ans[2] + ans[3])
    
    return ans
}