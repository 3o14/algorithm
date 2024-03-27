/*
    문제 요약: 전화번호부 중 한 번호가 다른 번호의 접두어인 경우가 있는지 없는지 반환하기 (있으면 false)
    
    phone_book의 길이가 최대 100만..
    sort해서 앞에거랑 뒤에거랑 비교
    이게 왜 해시 문제지
*/

function solution(phone) {
    phone.sort()
    
    for(let i=0; i<phone.length-1; i++) {
        if(phone[i] === phone[i+1].substring(0, phone[i].length)) return false
    }
    
    return true
}