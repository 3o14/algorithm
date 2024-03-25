/*
    문제 요약: ()[]{} 괄호 리스트를 회전초밥집(원형리스트)이라 생각하고 한칸씩 회전시켰을 때 올바른 괄호가 되는 횟수 리턴하기
    
    투포인터로 슬라이딩 윈도우 + 스택
    [](){}
*/

function solution(s, ans=0) {
    let origin = s.slice()
    s += s
    let stack = []
    const open = ['[', '(', '{']
    const close = [']', ')', '}']
    
    for(let start=0; start<origin.length; start++) {
        for(let j=start; j<start+origin.length; j++) {
            if(close.includes(s[j]) && stack.length > 0) {
                if(s[j] === '}' && stack[stack.length-1] === '{') stack.pop()
                if(s[j] === ')' && stack[stack.length-1] === '(') stack.pop()
                if(s[j] === ']' && stack[stack.length-1] === '[') stack.pop()
            } else {
                stack.push(s[j])
            }
        }
        if(stack.length === 0) {
            ans += 1       
        } else stack = []
    }
    
    return ans
}