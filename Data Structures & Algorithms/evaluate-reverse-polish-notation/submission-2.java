class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            Integer curr = 201;
            try {
                curr = Integer.parseInt(token);
            } catch (NumberFormatException e) {

            }

            if (curr < 200) {
                stack.push(curr);
            } else {
                int curr1 = stack.poll();
                int curr2 = stack.poll();
                System.out.println("first: " + curr2 + " sec: " +curr1);

                if(token.equals("*")) {
                    stack.push(curr2 * curr1);

                } else if (token.equals("/")) {
                    stack.push(curr2 / curr1);
                } else if (token.equals("+")) {
                    stack.push(curr2 + curr1);

                } else if (token.equals("-")) {
                    stack.push(curr2 - curr1);
                }
                System.out.println(stack.peekLast());
            }

        }
        
        return stack.poll();
    }
}



// ((1 + 2) * 3) - (4 * 5)

//+ (5 + 6) = 5
// tokens = ["1","2","+","3","*"," "4",5", "*", "-" ]

