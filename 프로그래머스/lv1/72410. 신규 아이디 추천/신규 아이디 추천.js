function solution(new_id) {
    let answer = '';
    new_id = new_id.toLowerCase();
    let renew_id = [];
    let moji = ["-", "_", "."];
    var check_spc = /[\{\}\[\]\/?,:\)*~!^\+<>@\#$%&\=\(]/;
    
    
    new_id = new_id.split("");    
    
    // 이상한 특수문자 제외
    for (let i = 0; i <new_id.length; i++) {
        if (check_spc.test(new_id[i])) { // i가 특수문자일 경우
            if (moji.includes(new_id[i])) { // 허용 가능한 특수문자일 경우
                renew_id.push(new_id[i]); // renew id에 삽입
            } 
        } else {
            renew_id.push(new_id[i]);
        }
    }
    
    // 처음, 끝, 연속된 온점 제외
    for(let i = 1; i < 30; i++) {
        if(renew_id[i-1] === "." && renew_id[i] === ".") {
            renew_id.splice(i-1, 1);
            i--;
        }
        
        if(renew_id[0] === ".") {
            renew_id.splice(0, 1);
        }
        
        if(renew_id[-1] === ".") {
            renew_id.splice(-1, 1);
        }
        
        
    }
    
    // 16글자 제한
    for (let i = 0; i<10 ; i++){
        renew_id.length >= 16 ? renew_id.splice(15, renew_id.length) : null
        
        // 끝 온점 검출
        if(renew_id.at(-1) === ".") {
            renew_id.splice(-1, 1);
        }
        if(renew_id.length === 0) {
            renew_id.push("a");
        }
    }
    
    for(let i=0; i<2; i++) {
        if(renew_id.length <= 2)
            renew_id.push(renew_id.at(-1));
    }

    renew_id = renew_id.join("");
    console.log(renew_id);
    
    
    
    return renew_id;
}