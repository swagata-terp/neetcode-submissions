class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet();
        while(right < s.length()) {
            char currChar = s.charAt(right);
            if (!set.contains(currChar)) {
                set.add(currChar);
                right++;
                max = Math.max(max, set.size());

            } else {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }
        }
        return max;

    }
}
