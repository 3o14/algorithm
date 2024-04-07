/*
    문제 요약: 캐시 교체 알고리즘 LRU를 적용해서 캐시 배열에 있으면 그걸 사용하고 1 더하기,
        캐시 배열에 없으면 5 더해서 실행시간을 구하기 (단, 캐시 사이즈는 정해져있다.)
        (LRU: 제일 오래 사용되지 않은 것을 캐시에서 교체한다. -> 큐 이용)
        
    위 그대로 구현하기
*/

function solution(cacheSize, cities, ans=0) {
    if(cacheSize === 0) return 5 * cities.length
    let cache = []
    
    cities.forEach((city) => {
        city = city.toLowerCase()
        const idx = cache.indexOf(city)
        if(idx !== -1) {
            cache.splice(idx, 1) // 이미 캐시되어 있으면 위치 업데이트
            ans += 1
        } else {
            if(cache.length === cacheSize) cache.shift()
            ans += 5
        }
        cache.push(city)
    })
    
    return ans
}