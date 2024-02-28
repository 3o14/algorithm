def solution(nums):
    max = int(len(nums) / 2)
    arr = set(nums)
    
    return max if len(arr) > max else len(arr)