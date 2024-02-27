// moves를 순회하면서 해당 열의 가장 상단 아이템을 stack에 넣는다.
// 각 열에서 직전 행 Index를 저장할 배열을 만들고 인형을 집은 인덱스를 저장해둔다.
// stack의 마지막 원소와 같을 경우 pop시키고 ans += 2 한다.

function solution(board, moves, ans=0) {
    let stack = []  // 장바구니 스택
    let idxArr = new Array(board.length).fill(0) // 각 열에서 직전에 인형을 집은 인덱스를 기억하기 위한 배열
    
    for(const move of moves) {
        let doll = -1
        for(let row=idxArr[move-1]; row<board.length; row++) { // 이전 위치부터 인형 탐색
            doll = board[row][move-1]
            if(doll) {
                idxArr[move-1] = row // 배열 row값 갱신
                
                // 집은 인형이 장바구니의 제일 위의 것과 똑같을 경우
                if(doll === stack[stack.length-1]) {
                    stack.pop()
                    board[row][move-1] = 0
                    ans += 2
                    break
                }

                // 장바구니에 인형 추가
                stack.push(doll)
                board[row][move-1] = 0
                break
            }
        }
    }
    
    return ans
}