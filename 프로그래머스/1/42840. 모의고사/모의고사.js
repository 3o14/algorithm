function solution(answers, ans=[0, 0, 0]) {
    const stu1 = [1, 2, 3, 4, 5];
    const stu2 = [2, 1, 2, 3, 2, 4, 2, 5];
    const stu3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    answers.forEach((e, i) => {
        if(e === stu1[i % stu1.length]) {
            ans[0] += 1;
        }
        if(e === stu2[i % stu2.length]) {
            ans[1] += 1;
        }
        if(e === stu3[i % stu3.length]) {
            ans[2] += 1;
        }
    })
    const max = Math.max(...ans);
    ans = ans.map((e, i) => {
        if(max === e)
            return i+1
    })
    return ans.filter(e => e);
}