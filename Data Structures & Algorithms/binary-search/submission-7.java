class Solution {
    public int search(int[] nums, int target) {

        int lower = 0;
        int upper = nums.length -1;
        while (lower <= upper ) {
            int currIndex = lower + ((upper - upper) /2);
            if(nums[currIndex] == target) {
                return currIndex;
            } else if (nums[currIndex] > target) {
                upper = currIndex - 1;
            } else {
                lower = currIndex + 1;
            }

        }
        return -1;
        
    }
}
