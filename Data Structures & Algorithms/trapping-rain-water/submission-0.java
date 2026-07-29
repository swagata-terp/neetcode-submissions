class Solution {
    public int trap(int[] height) {

        int[] leftLargest = new int[height.length];
        int[] rightLargest = new int[height.length];

        int currMax = 0;

        for (int i = 0; i < height.length; i++) {
            leftLargest[i] = currMax;
            if (height[i] > currMax) {
                currMax = height[i];
            }
        }
        currMax = 0;

        for (int i = height.length - 1;  i >= 0; i--) {
            rightLargest[i] = currMax;
            if (height[i] > currMax) {
                currMax = height[i];
            }
        }
        int count = 0;

        for (int i = 0; i < height.length; i++) {
            int minSide = Math.min(leftLargest[i], rightLargest[i]);

            if(height[i] < minSide) {
                count += (minSide - height[i]);
            }

        }
        return count;
        
        
    }
}
