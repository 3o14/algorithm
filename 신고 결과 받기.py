    # 신고여부  무지 프로도 어피치 네오
    # 무지     0    0    1
    # 프로도    1    0    1    
    # 어피치              0
    # 네오      1    1        0
    # 무지 2회 프로도 1회 어피치 2회 네오 0회
    # 메일을 횟수: 본인이 신고한 유저가 정지를 당했을 경우, 본인이 정지당한 경우
    
# 행에서 1의 개수가 k 이상일 경우: 행의 인덱스 번호의 유저가 신고를 당함 -> +1
# 신고를 당한 유저의 인덱스가 포함되어있는 유저의 경우 -> +1

def solution(id_list, report, k):
    answer = [0 for i in range(len(id_list))]
    counted = [[0 for col in range(len(id_list))] for row in range(len(id_list))]
    result = [0 for i in range(len(id_list))]
    for r in report:
        arr = r.split(" ")
        activeName = arr[0]
        passiveName = arr[1]
        counted[id_list.index(passiveName)][id_list.index(activeName)] = 1
        # print("현재 counted 배열 상태")
        
    for c in range(len(counted)):
        num = 0
        for d in range(len(counted)):
            if counted[c][d] == 1:
                num += 1
        if num >= k:
            answer[c] += 1
            
    print("신고당한 내역: ", answer)
            
    for e in range(len(counted)):
        if answer[e] == 1:
            for f in range(len(counted)):
                if counted[e][f] == 1:
                    result[f] += 1
    return result