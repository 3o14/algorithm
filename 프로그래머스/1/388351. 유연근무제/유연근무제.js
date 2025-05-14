function solution(schedules, timelogs, startday) {
    var answer = schedules.length;
    
    
    for(let i=0; i<schedules.length; i++) {
        let day = startday
        let worktime = schedules[i] + 10;
        
        if(worktime % 100 >= 60) {
            worktime += 100;
            worktime -= 60
        }
        
        for(let j=0; j<7; j++) {
            let day = startday + j
            if(day % 7 === 0 || day % 7 === 6) continue;
            
            if(worktime < timelogs[i][j]) {
                answer--;
                break;
            }
            
            day += 1;
        }
    }
    return answer;
}