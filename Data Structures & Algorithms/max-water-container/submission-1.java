class Solution {
    public int maxArea(int[] heights) {
        // min of one side height * subarray width

        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        int leftPointerMax;
        while (r > l) { // r > l
            int currMax = (r - l) * Math.min(heights[l], heights[r]);
            max = Math.max(currMax, max);

            if ( heights[l] > heights[r]) { // if heights[l] > heights[r] decrease r else increase l
                r--;
            } else {
                l++;
            }
        }
        return max;
        
    }
}
