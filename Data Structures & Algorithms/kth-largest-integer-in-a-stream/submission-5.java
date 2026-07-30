class KthLargest {

    PriorityQueue<Integer> e;
    // created a priority queue of size k meaning its really saving the k smallest values? with 
    // top being smallest
    int size;
    public KthLargest(int k, int[] nums) {
        e = new PriorityQueue<>(k , (a, b) -> a - b);
        size = k;
        int i = 0;
        while (i < k && i < nums.length) {
            e.add(nums[i]);
            i++;
            size--;
        }
        while (i < nums.length) {
            if(nums[i] > e.peek()) {
                e.poll();
                e.add(nums[i]);
            }
            i++;
        }
    }
    
    public int add(int val) {
        System.out.println(e.peek());
        
        if(size > 0) {
            e.add(val);
            size--;
            return e.peek();
        }
        if(val > e.peek()) {
            e.poll();
            e.add(val);
            return e.peek();
        }
        return e.peek();
        
    }
}
