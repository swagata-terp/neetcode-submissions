class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Input: nums = [1,2,4,6]
        // total is 48 ? go through each index dividing said total from ith value
        // if 0s  == 1 set all value to 0 except the 0 which should equal the total
        // if more than 1 0 return empty array?

        int zeros = 0;
        int total = 1;
        int firstZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]  == 0) {
                zeros++;
                if(zeros == 1) {
                    firstZero = i;
                }
            } else {
                total *= nums[i]; 
            }
        }

        int[] res = new int[nums.length];
        System.out.println(zeros);
        if (zeros > 1) {
            return res;
        } else if (zeros == 1) {
            res[firstZero] = total;
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = total / nums[i];
        }
        return res;
        
    }
}  
