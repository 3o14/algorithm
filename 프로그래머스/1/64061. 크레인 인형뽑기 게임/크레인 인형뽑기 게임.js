// moves를 순회하면서 해당 열의 가장 상단 아이템을 stack에 넣는다.
// 각 열에서 직전 행 Index를 저장할 배열을 만들고 인형을 집은 인덱스를 저장해둔다.
// stack의 마지막 원소와 같을 경우 pop시키고 ans += 2 한다.
function solution(board, moves, ans=0) {
    let stack = []
    let idxArr = new Array(board.length).fill(0)
    for(const move of moves) {
        let doll = -1
        for(let row=idxArr[move-1]; row<board.length; row++) {
            doll = board[row][move-1]
            if(doll) {
                idxArr[move-1] = row
                if(doll === stack[stack.length-1]) {
                    stack.pop()
                    board[row][move-1] = 0
                    ans += 2
                    break
                }

                stack.push(doll)
                board[row][move-1] = 0
                break
            }
        }
    }
    
    return ans
}