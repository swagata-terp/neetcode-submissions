class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:

        hasDup = set()
        for num in nums:
            if num in hasDup:
                return True
            hasDup.add(num)
        return False;
        