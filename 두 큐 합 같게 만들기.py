from collections import deque

def solution(queue1, queue2):
    answer = 0

    # deque 이용
    queue1, queue2 = deque(queue1), deque(queue2)
    sum1, sum2 = sum(queue1), sum(queue2)
    half = sum1 + sum2 // 2
    
    # 3번 돌아도 반값 못찾으면 return -1
    for _ in range(3*len(queue1)):

        # 왼쪽 배열의 원소의 합이 더 클 경우
        # 왼쪽 배열의 첫번째 원소를 오른쪽 배열의 맨 끝으로 이동
        if sum1 > sum2:
            sum1 -= queue1[0]
            sum2 += queue1[0]
            queue2.append(queue1.popleft())

        # 오른쪽 배열의 원소의 합이 더 클 경우
        # 오른쪽 배열의 첫번째 원소를 왼쪽 배열의 맨 끝으로 이동
        elif sum1 < sum2:
            sum1 += queue2[0]
            sum2 -= queue2[0]
            queue1.append(queue2.popleft())
        
        # 두 배열의 값이 같은 경우
        # 이동횟수를 담은 answer 반환
        else: 
            return answer
        answer += 1

    return -1