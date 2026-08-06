class Solution {
    public String minWindow(String s, String t) {


        HashMap<Character, Integer> toCheck = new HashMap<>();
        HashMap<Character, Integer> bigMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            toCheck.put(c, toCheck.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = toCheck.keySet().size();
        int l = 0;
        int r = 0;
        int resLen = Integer.MAX_VALUE;
        int resStart = 0;
        boolean moreLeft = true;
        while (r <= s.length() && moreLeft) {

            if(have == need) {
                if (r - l  < resLen) {
                    resLen = r - l;
                    resStart = l;
                }

                char charL = s.charAt(l);
                int currLCount = bigMap.get(charL) - 1;
                bigMap.put(charL, currLCount);
                if (toCheck.containsKey(charL) && toCheck.get(charL) > currLCount) {
                    have--;
                }
                l++;
            } else if (r == s.length()) {
                moreLeft = false;
            } else {
                char rChar = s.charAt(r);
                int currCharCount = bigMap.getOrDefault(rChar, 0) + 1;
                bigMap.put(rChar, currCharCount);
                if (toCheck.containsKey(rChar)) {
                    // what happens if greater - shouldn't care since technically we still have enough
                    if (toCheck.get(rChar) == currCharCount) {
                        have++;
                    }
                    
                }
                r++;
            }
            
            
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + resLen);
    }
}
