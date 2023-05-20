def solution(s):
    answer = -1
    s = list(s)
    stack = []
    
    for i in range(len(s)) :
        if len(stack) != 0 :
            if s[i] == stack[-1] :
                stack.pop()
            else :
                stack.append(s[i])
        else :
            stack.append(s[i])
        
    return 1 if len(stack) == 0 else 0