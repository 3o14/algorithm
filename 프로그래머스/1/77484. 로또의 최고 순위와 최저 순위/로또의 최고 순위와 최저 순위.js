function solution(lottos, win_nums) {
    const min = lottos.filter((e) => win_nums.includes(e)).length
    const max = lottos.filter((e) => e === 0).length
    return [!(min+max) ? 6 : 7-(min+max), !min ? 6 : 7-min ]
}