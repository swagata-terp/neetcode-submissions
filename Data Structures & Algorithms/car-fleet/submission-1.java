class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Double> posToSpeed = new HashMap<>();

        for (int i = 0; i < speed.length; i++) {
            posToSpeed.put(position[i], new Double(speed[i]));
        }

        Arrays.sort(position);
        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = position.length - 1; i >= 0; i--) {
            
            Double currTime = ((target - position[i]) / posToSpeed.get(position[i]));
            // System.out.println(position[i]);
            // System.out.println(currTime);
            if (stack.isEmpty()) {
                stack.addFirst(currTime);
            } else if (currTime > stack.peekFirst()) {
                stack.addFirst(currTime);
            }
        }

        return stack.size();
    }
}
