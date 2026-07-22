class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int max = 0;

        while (right < prices.length) {
            if(right == left) {
                right++;
                if(right > prices.length - 1) {
                    return max;
                }
            }
            int max1 = prices[right] - prices[left];
            if(max1 > max) {
                max = max1;
            }
            if(max1 < 0) {
                left++;
            }else {
                right++;
            }

        }
        return max;
        
    }
}
