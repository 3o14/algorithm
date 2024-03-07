function solution(progresses, speeds, ans=[]) {
    // 며칠 째에 개발이 끝나는지 계산 후 저장
    for(let i=0; i<progresses.length; i++) {
        progresses[i] = Math.ceil((100 - progresses[i])/speeds[i])
    }
    
    let cnt=1
    // 자기 자신보다 작은 값들은 함께 배포
    // ex)      95 90 99 99 80 99
    // 남은 작업일 5  10 1  1  20 1
    // [5], [10 1 1], [20 1] => 자신보다 작은 값들을 함께 배포
    for(let i=0; i<progresses.length; i++) {
        cnt = 1
        for(let j=i+1; j<progresses.length; j++) {
            if(progresses[i] >= progresses[j]) {
                cnt += 1
            } else {
                i = j-1
                break
            }
        }
        // ans의 값의 합을 계산해서 모든 기능 개발이 끝마쳤으면 return
        if(ans.length && ans.reduce((acc, prev) => acc+prev) === progresses.length) return ans
        ans.push(cnt)
    }
    
    return ans
}