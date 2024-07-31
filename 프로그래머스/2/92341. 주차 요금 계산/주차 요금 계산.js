/*
    문제 요약: 차량번호가 작은 자동차부터 주차 요금을 계산해서 정수 배열로 출력하기.
    
    key-value 값으로 저장하고 key값으로 정렬도 가능한 map 객체를 사용하자. key: 차량번호, value: [{시각, 내역}, {}, ...]
    map에 records 배열을 정리하고 정렬 후 시간 계산, 요금 계산 후 정답 배열에 넣고 출력하기.
*/
function solution(fees, records) {
    let ans = []
    let map = new Map()
    const [basicMin, basicFee, basicUnit, feePerUnit] = fees
    
    for(let record of records) {
        const [time, car, kind] = record.split(" ")
        const info = {
            num: car,
            time: time,
            kind: kind
        }
        const prev = map.get(car)
        map.set(car, prev ? [...prev, info] : [info] )
    }
    
    map = new Map([...map].sort())

    const calcTime = (time) => {
        // 시간:분 데이터를 분 데이터로 치환
        const [hour, min] = time.split(":")
        return Number(hour)*60 + Number(min)
    }
    
    const getParkingTime = (IN, OUT) => {
        // 분으로 치환된 시간을 빼서 총 주차시간 구하기
        return Number(calcTime(OUT)) - Number(calcTime(IN))
    }

    for(let record of map.values()) {
        let stack = []
        let time = 0
        
        // 2. 주차 시간 계산하기
        for(let info of record) {
            if(info.kind === 'IN') {
                stack.push(info.time)
            }
            if(info.kind === 'OUT') {
                time += getParkingTime(stack.pop(), info.time)
            }
        }
        if(stack.length > 0) {
            // 출차가 없을 경우 23:59 출차로 간주하고 계산하기
            time += getParkingTime(stack.pop(), '23:59')
        }
        
        
        // 3. 요금 계산하기
        let cost = basicFee
        if(time <= basicMin) {
            ans.push(cost)
            continue
        }
        cost += Math.ceil((time - basicMin) / basicUnit) * feePerUnit
        ans.push(cost)
    }    

    return ans
}