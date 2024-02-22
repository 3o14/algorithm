function solution(dartResult) {
    let stack = []
    dartResult.split('').forEach((e, i) => {
        if(!isNaN(e)) { // 숫자일 경우
            // console.log('숫자', e, ' stack: ', stack)
            if(e === '0') {
                const pre = stack.pop()
                if(pre === '1') {
                    stack.push(10)
                } else {
                    stack.push(pre ? pre : null)
                    stack.push(e)
                }
            } else {
                stack.push(e)
            }
        }
        if('SDT'.includes(e)) { 
            switch(e) {
                case 'D':
                    stack.push(stack.pop()**2)
                    break
                case 'T':
                    stack.push(stack.pop()**3)
                    break
            }
        }
        if('#*'.includes(e)) {
            switch(e) {
                case '#':
                    const prevs = stack.pop()
                    // console.log('# i: ', i, ' prev: ', prevs)
                    stack.push(-prevs)
                    break
                case '*':

                    const cur = stack.pop()
                    const prev = stack.pop()
                    // console.log('* i: ', i, ' prev: ', prev)                    
                    stack.push(prev ? prev*2 : null)
                    stack.push(cur*2)
            }
        }
    })
    
    // console.log(stack)
    return stack.reduce((prev, sum) => +prev + +sum)
}