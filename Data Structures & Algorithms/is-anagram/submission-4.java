class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> e = new HashMap<>();
        Map<Character, Integer> f = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }


        for(char c : s.toCharArray()) {
            e.put(c, e.computeIfAbsent(c, k -> 0) + 1);
        }
        for(char c : t.toCharArray()) {
            f.put(c, f.computeIfAbsent(c, k -> 0) + 1);
        }

        for (char key : e.keySet()) {
            if (!e.get(key).equals(f.getOrDefault(key, 0))) {
                return false;

            }

        }

        
    return true;
    }

}
