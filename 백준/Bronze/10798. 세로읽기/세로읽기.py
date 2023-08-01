strr = []

for n in range(5):
    strr.insert(n, list([0 for _ in range(15)]))

for i in range(5):
    st = list(str(input()))
    stLen = len(st)
    for j in range(stLen):
        strr[i][j] = st[j]

for k in range(15):
    for l in range(5):
        if strr[l][k] != 0 :
            print(strr[l][k], end='')