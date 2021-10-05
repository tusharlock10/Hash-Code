class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numMap = {}
        
        for i in range(len(nums)):
            num = nums[i]
            
            
            if target - num in numMap:
                return [numMap[target-num], i]
            
            numMap[num] = i