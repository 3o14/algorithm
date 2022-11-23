def solution(food):
    answer = ''
    arr1 = []
    for i in range(len(food)) :
        foodLen = food[i] // 2
        for _ in range(foodLen) :
            arr1.append(i)

    stri = "".join(str(s) for s in arr1)
    strin = stri[::-1]
    answer = stri + "0" + strin
    return answer

# food[1] 부터 food[len(food)] 까지의 숫자를 2로 나누었을 때의 수가 그 음식이 차지하는 길이임
# 한쪽 길이를 먼저 채우고 0을 더한 후 같은 배열을 reverse 하여 붙이기