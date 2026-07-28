class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -4, -1, -1, 0, 1, 2
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int curr = nums[i] + nums[l] + nums[r];
                // System.out.println("i: " + i + " l: " + l + " r: " + r + " =" + curr);

                if (curr == 0) {
                    List<Integer> ans = List.of(nums[i], nums[l], nums[r]);
                    list.add(ans);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (curr > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return list;
    }
}
