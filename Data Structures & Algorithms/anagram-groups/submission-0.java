class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //mlgm * n 
        // key is array of characters activated value is list of orignial words
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            int[] currKey = new int[26];
             String curr = strs[i];
             for (char c : curr.toCharArray()) {
                int charArrIndex = c - 'a';
                currKey[charArrIndex]++;
             }
             String key = Arrays.toString(currKey);
             if (map.containsKey(key)) {
                List<String> v = map.get(key);
                v.add(curr);
             } else {
                List<String> v = new ArrayList<>();
                v.add(curr);
                map.put(key, v);
             }

        }

        List<List<String>> arr = new ArrayList<>();
        map.values().forEach(x -> arr.add(x));
        return arr;
        
    }
}
