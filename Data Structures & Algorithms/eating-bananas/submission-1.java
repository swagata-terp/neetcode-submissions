class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for(int i: piles) {
            max = Math.max(i, max);
        }

        int l = 0;
        int r = max;
        int smallestH =Integer.MAX_VALUE;
        
        while (l <= r) { // might need to update this
            int mid = (l + r) / 2;
            double h2 = (double) h;
            int i = 0;
            System.out.println(mid);
            while (h2 > 0 && i < piles.length) {
                System.out.println((double) piles[i]/mid);
                h2 = h2 -Math.ceil((double) piles[i]/mid);
                System.out.println(h2);
                i++;
            }
            if (i == piles.length && h2 >= 0) {
                smallestH = Math.min(smallestH, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            
        }

        return smallestH;
    }
}
