class Solution {
    // [30,38,30,36,35,40,28]
    // 40  35 36 38
    //  5   4  3  1

    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Map.Entry<Integer, Integer>> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        Map.Entry<Integer, Integer> init = Map.entry(temperatures[0], 0);
        stack.push(init);
        for ( int i = 1; i < temperatures.length; i++) {
            int curr = temperatures[i];
            
            while (!stack.isEmpty() && curr > stack.peek().getKey()) {
                res[stack.peek().getValue()] = i - stack.peek().getValue(); 
                stack.pop();
            //  System.out.println("poppin entry:" + stack.pop() + "curr: " + curr + "index: " + i);
            }
            Map.Entry<Integer, Integer> newEntry = Map.entry(temperatures[i], i);
            // System.out.println("pushing entry:" + newEntry);
            stack.push(newEntry);

            
        }
        while (!stack.isEmpty()) {
            Map.Entry<Integer, Integer> e = stack.pop();
            res[e.getValue()] = 0;
        }
        return res;

    }
}
