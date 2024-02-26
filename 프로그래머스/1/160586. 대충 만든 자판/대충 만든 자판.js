function solution(keymap, targets) {
    let ans = new Array(targets.length).fill(0)
    let arr = new Array(26).fill(0) // 각 알파벳의 최소 횟수 정보 담을 배열
    let target = null
    for(let i=0; i<targets.length; i++) {
        target = [...targets[i]]
        
        for(let j=0; j<target.length; j++) {
            const word = target[j]
            // 알파벳 배열에 최소 횟수 정보가 담겨 있으면 그걸 쓰고
            if(arr[word.codePointAt(0)-65]) {
                ans[i] += arr[word.codePointAt(0)-65]
                continue
            }
            
            // 없으면 최소 횟수 구하기
            let minIdx = Number.MAX_VALUE
            for(let k=0; k<keymap.length; k++) {
                const idx = keymap[k].indexOf(word)
                minIdx = Math.min(idx === -1 ? minIdx : idx, minIdx)
            }
            
            // 없을 경우 -1 넣고 다음 target으로 넘어감
            if(minIdx === Number.MAX_VALUE) {
                ans[i] = -1
                break
            }
            
            // 구한 값 배열에 저장하기
            arr[word.codePointAt(0)-65] = minIdx+1
            ans[i] += minIdx+1
        }
    }
    
    return ans
}