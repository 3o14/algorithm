def solution(s):
    ans = 0
    char = ""
    ch1, ch2 = 0, 0
    for idx, i in enumerate(s):
        if char == "":
            char = i
            ch1 += 1
        elif char == i:
            ch1 += 1
        elif char != i:
            ch2 += 1
        if ch1 == ch2 or idx == len(s)-1:
            print(char, i, idx)
            ans += 1
            ch1 = 0
            ch2 = 0
            char = ""
    return ans

# 첫문자를 담음
# 첫문자와 같으면 첫문자+1 다르면 둘째문자+1
# 매번 첫문자길이 둘째문자길이 비교
# 같으면 ans+1 그리고 두변수 초기화