function solution(bandage, health, attacks) {
    const maxHealth = health;
    let time = 1, band = 0;
    let attIdx = 0, attSec = null;
    
    while(true) {
        if(!attSec) {   
            attSec = attacks[attIdx][0];
        }
        
        if(time === attSec) { // 공격 성공시
            health -= attacks[attIdx][1];
            band = 0;
            attSec = null;
            if(attIdx < attacks.length-1) {
                attIdx += 1;
            } else break;
            
            if(health <= 0) return -1;
            
        } else { // 붕대 감기 성공시
            health += bandage[1];
            band++;
            if(band === bandage[0]) {
                health += bandage[2];
                band = 0;
            }
            
            health = health > maxHealth ? maxHealth : health;
        }
        
        time++;
    }
    
    return health > 0 ? health : -1;
}