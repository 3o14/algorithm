def solution(n, arr1, arr2):
    answer = []
    
    for i in range(len(arr1)):
        arr1[i] = list(format(arr1[i], 'b').zfill(n))
        arr2[i] = list(format(arr2[i], 'b').zfill(n))
        
    for i in range(len(arr1)):
        arr = []
        for j in range(len(arr2)):
            if arr1[i][j] == '1' or arr2[i][j] == '1':
                arr.append("#")
            else :
                arr.append(" ")
                
        answer.append(''.join(arr))
            
    return answer