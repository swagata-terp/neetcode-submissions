class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            Integer otherIndex = map.get(diff);
            if(otherIndex != null) {
                return new int[]{otherIndex, i,};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
        
    }
}


// 3 4 5 6 target = 7 