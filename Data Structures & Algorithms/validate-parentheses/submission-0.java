class Solution {
    public boolean isValid(String s) {
        Deque<Character> e = new ArrayDeque<>();
        Map<Character,  Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
         mappings.put(']', '[');
        e.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            Character avail = mappings.get(curr);


            if(avail != null && e.peekFirst() == avail) {
                e.pop();

            } else {
                e.addFirst(curr);
            }

        }

        if(e.isEmpty()) {
            return true;
        }

        return false;
        
    }
}
