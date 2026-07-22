class Solution {

    int[] arr = new int[46];
    public int climbStairs(int n) {

        return climbStairsHelper(n);

    }

    private int climbStairsHelper(int n) {

        if (n > 0) {
            if (arr[n] != 0) {

                return arr[n];
            }
            int curr =  climbStairsHelper(n -1) + climbStairsHelper(n-2);
            arr[n] = curr;
            return curr;
        } else if (n == 0) {
            return 1;
        }
        
        return 0;
    }


}