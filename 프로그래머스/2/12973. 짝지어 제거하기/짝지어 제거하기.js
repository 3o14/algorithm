function solution(s)
{
    arr = s.split('');
    stack = [];
    const reg = /(.)\1+/;
    
    for(let i = 0 ; i < arr.length; i++){
        if(arr[i] === stack.at(-1)){
            stack.pop();
        }
        else{
            stack.push(arr[i]);
        }
    }
    
    return reg.test(s) === true ? (stack.length === 0 ? 1 : 0 ) : 0 ;
}