/*
    이모티콘 플러스 가입자 수를 늘리고(1순위 목표), 이모티콘 판매액을 늘리기(2순위 목표) 행사를
    했을 때 늘어난 가입자 수와 판매액의 최선의 결과를 출력하기.
    
    1. users.비율 의 min값부터 max값까지 모두 계산해보기
    2. 이모티콘 가격이 users.가격 보다 큰 경우(이모티콘 플러스 신규 유입) 해당 경우로 덮어쓰기 한다.
    
    중복 순열로 할인 비율 경우의 수 각각 구해서 최선의 결과를 출력하기
*/
function permutation(arr, selectNum) {
  const result = [];
  if (selectNum === 1) return arr.map((v) => [v]);

  arr.forEach((v, idx, arr) => {
    const fixed = v;
    const restArr = arr;
    const permutationArr = permutation(restArr, selectNum - 1);
    const combineFix = permutationArr.map((v) => [fixed, ...v]);
    result.push(...combineFix);
  });
  return result;
}

function solution(users, emoticons) {
    let result = [0, 0]
    let min = null, max = null
    let arr = [10, 20, 30, 40]
    let answer = []
    // percent만큼 모든 emoticons를 할인시켰을 때의 가격 계산
    // 그 가격이 users.가격 보다 높으면 신규가입, 낮으면 가격을 매출에 포함
    // result의 신규가입자 수보다 크면 result값 갱신, 낮으면 기존값 유지

    let 할인율 = permutation(arr, emoticons.length)
    for(let arr of 할인율) {
        let temp = [0, 0]
        let expens = new Array(users.length).fill(0)
        for(let uid in users) {
            for(let idx in arr) {
                if(arr[idx] >= users[uid][0]) {
                    expens[uid] += emoticons[idx] - (emoticons[idx] * arr[idx] * 0.01)
                }
            }
        }
        
        for(let uid in expens) {
            if(expens[uid] >= users[uid][1]) temp[0] += 1
            if(expens[uid] < users[uid][1]) temp[1] += expens[uid]
        }

        answer.push(temp);
    }

    answer.sort((a, b) => {
        if(a[0] > b[0]) return b[0] - a[0]
        else if(a[0] === b[0]) return b[1] - a[1]
    })
    
    return answer[0]
}