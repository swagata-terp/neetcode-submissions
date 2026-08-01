class Solution {
    public int characterReplacement(String s, int k) {

        // currWindow -  maxFreq > k  s = "XYYX", k = 2

        // x -> 1 y -> 1
        //

        int l = 0;
        int r = 0;
        int max = 0; //1  2
        int maxWindow = 0;
        HashMap<Character , Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            // map.getOrDefault(curr, 0);
            Integer currCount = map.getOrDefault(curr, 0) + 1;
            map.put(curr, currCount);

            max = Math.max(currCount, max);

            while ((i - l + 1) - max > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxWindow = Math.max(maxWindow, (i - l + 1));     
        }
        return maxWindow;

    }
}
