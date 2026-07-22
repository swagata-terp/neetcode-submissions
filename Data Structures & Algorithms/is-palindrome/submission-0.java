class Solution {
    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char leftChar = Character.toLowerCase(s.charAt(start));
            char rightChar = Character.toLowerCase(s.charAt(end));
            if(!Character.isLetterOrDigit(leftChar)) {
                ++start;
            } else if(!Character.isLetterOrDigit(rightChar)) {
                --end;
            } else if(leftChar == rightChar) {
                
                System.out.println("start" + s.charAt(start));
                System.out.println("e" + s.charAt(end));

                ++start;
                --end;
            } else {
                return false;
            }
        }
        return true;
        
    }
}
