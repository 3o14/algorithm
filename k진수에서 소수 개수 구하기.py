import math

# 소수 판별 함수
def is_prime_num(n):
    for i in range(2, int(math.sqrt(n))+1): # n의 제곱근을 정수화 시켜준 후 + 1
        if n % i == 0:
            return False
    return True

# 입력받은 숫자 n을 k진법으로 변환
def solution(n, k):
    word = ""
    while n:            
        word = str(n%k)+word
        n = n // k
        
    # 변환된 숫자를 0을 기준으로 split
    word = word.split("0")  
    
    count=0
    for w in word:
        if len(w)==0:    # 0 또는 1일 경우는 continue
            continue
        if int(w)<2:
            continue
            
        # 소수 판별함수를 이용해 소수가 맞을 경우에는 count    
        if is_prime_num(int(w)):
            count+=1
            
    return count