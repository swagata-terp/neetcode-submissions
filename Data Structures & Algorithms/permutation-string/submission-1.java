class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        int l = 0;

        for (int i = s1.length() - 1; i < s2.length(); i++) {


            if (Arrays.toString(s1Map).equals(Arrays.toString(s2Map))) {
                return true;
            }
            int currLeft = s2.charAt(l) - 'a'; 
            s2Map[currLeft]--;
            l++;
            if ( i + 1 < s2.length()) {
                int currRight = s2.charAt(i + 1) - 'a';
                s2Map[currRight]++;
            }


        }

     return false;   
    }
}
