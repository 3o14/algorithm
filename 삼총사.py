# itertools 모듈에서 combinations 함수 사용 (집합 뽑기)
from itertools import combinations
    
def solution (number) :
	# 정답이 되는 삼총사의 개수를 변수
    cnt = 0 
        
    # combinations함수를 이용해
    # number 배열에서 원소 3개씩 조합을 뽑아서 i에 담는 반복문
    for i in combinations(number,3) :
        # i의 합이 0이 될 경우 삼총사임
        if sum(i) == 0 : 
            cnt += 1
    return cnt
