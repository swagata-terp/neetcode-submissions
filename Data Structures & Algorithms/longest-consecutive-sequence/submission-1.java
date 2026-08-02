class Solution {
    public int longestConsecutive(int[] nums) {
        // [2,20,4,10,3,4,5]
        // add each number to a set?
        // then iterate through the set again to find starts? or start a loop
        // if curr item is a start, see if  ++ exists, if so remove that? increment curr count?
        // keep looping and see if curr count greater than max?
        //do so until hashset is empty?
        // for each start see if 

        if (nums.length  == 0) {
            return 0;
        }

        int max = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) {
            set.add(i);
        }

        for (int curr : nums) {
            
            if (set.isEmpty()) {
                return max + 1;
            }
            if (set.contains(curr) && !set.contains(curr - 1)) {
                int currMax = 0;
                set.remove(curr);
                while (set.contains(curr + 1)) {
                    curr++;
                    currMax++;
                    max = Math.max(max, currMax);
                    set.remove(curr);

                }
            }
        }
        return max + 1;
        
    }
}
